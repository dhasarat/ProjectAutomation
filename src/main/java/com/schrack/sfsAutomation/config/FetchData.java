package com.schrack.sfsAutomation.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.exceptions.CsvException;

public class FetchData extends BasicConfig {

    /*
     * Method to convert CSV to Bean and return a list of Bean Class Object
     */
    public static <T> List<T> getData(Map<String, String> map, Class<T> BeanClass, String fileName, String env) {
        String datafilePath = filePath + "testData." + env + slash + fileName + ".csv";
        HeaderColumnNameTranslateMappingStrategy<T> strategy = new HeaderColumnNameTranslateMappingStrategy<T>();
        strategy.setType(BeanClass);
        strategy.setColumnMapping(map);

        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(datafilePath));
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(csvReader).withType(BeanClass).withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true).build();
        List<T> list = csvToBean.parse();

        return list;

    }

    /*
     * Method to convert CSV to Bean and return a Stream of Bean Class Object
     */
    public static <T> Stream<T> getDataStream(Map<String, String> map, Class<T> BeanClass, String fileName,
            String env) {
        String datafilePath = filePath + "testData." + env + slash + fileName + ".csv";
        HeaderColumnNameTranslateMappingStrategy<T> strategy = new HeaderColumnNameTranslateMappingStrategy<T>();
        strategy.setType(BeanClass);
        strategy.setColumnMapping(map);

        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(datafilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(csvReader).withType(BeanClass).withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true).build();
        Stream<T> stream = csvToBean.stream();

        return stream;

    }

    /*
     * Method to convert CSV to Map directly(Only for CSV with 2 column)
     */
    public static LinkedHashMap<String, String> csvToMap(String fileName, String env) {
        String datafilePath = filePath + "testData." + env + slash + fileName + ".csv";
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        CSVReader csvReader = null;
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        try {
            FileReader filereader = new FileReader(datafilePath);
            csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        List<String[]> allData = null;
        try {
            allData = csvReader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < allData.size(); i++) {
            String[] row = allData.get(i);
            map.put(row[0], row[1]);
        }

        return map;
    }

}
