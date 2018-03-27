package com.github.johrstrom.workshop.person;

import org.junit.Assert;
import org.junit.Test;


public class PersonTest {
	
	@Test
	public void testCorrectJsonWithEmptyPerson() {
		Person p = new Person();
		
		String actualJson = p.toJsonString();
		String expectedJson = "{\"age\": 0.0, \"height\": 0, \"weight\": 0, \"haircolor\": \"\"}";
		
		Assert.assertTrue(
				String.format("%s -- Expected\n%s -- Actual\n", expectedJson, actualJson),
				actualJson.equals(expectedJson));
	}
	
	@Test
	public void testCorrectJsonWithPopulatedPerson() {
		Person p = new Person(32.7,83,136,"blonde");
		
		String actualJson = p.toJsonString();
		String expectedJson = "{\"age\": 32.7, \"height\": 83, \"weight\": 136, \"haircolor\": \"blonde\"}";
		
		Assert.assertTrue(
				String.format("%s -- Expected\n%s -- Actual\n", expectedJson, actualJson),
				actualJson.equals(expectedJson));
	}

}
