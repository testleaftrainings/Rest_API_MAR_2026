package com.testleaf.matschie.tests;

import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testleaf.matschie.data.utils.JsonHandler;

public class TestData {
	
	@DataProvider
	public Iterator<Map<String, String>> getTestData() {
		return JsonHandler.getData("create-data");
	}
	
	@Test(dataProvider = "getTestData")
	public void testData(Map<String, String> data) {
		System.out.print(data.get("shortDescription"));
		System.out.print(" | ");
		System.out.print(data.get("description"));
		System.out.print(" | ");
		System.out.print(data.get("category"));
		System.out.print(" | ");
		System.out.println("");
	}

}