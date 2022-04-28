package com.schrack.sfsAutomation;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.schrack.sfsAutomation.config.FetchData;

public class CsvToMap extends BaseTest {
    

    
    @Test
    public void readData() {

//        for (Books e : list) {
//            System.out.println(
//                    e.getTitle() + " || " + e.getSubTitle() + " || " + e.getPublisher() + " || " + e.getVersion());
//
//        }
        LinkedHashMap<String,String> map = FetchData.csvToMap("Labels", "UAT");
        System.out.println(map);
        

    }
}
