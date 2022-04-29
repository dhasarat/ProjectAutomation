package com.project.automation;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.project.automation.config.FetchData;

public class CsvToMap extends BaseTest {

	@Test
	public void readData() {

		LinkedHashMap<String, String> map = FetchData.csvToMap("Labels", "UAT");
		System.out.println(map);

	}
}
