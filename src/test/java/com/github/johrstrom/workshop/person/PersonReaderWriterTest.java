package com.github.johrstrom.workshop.person;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PersonReaderWriterTest {
	
	@Test
	public void testSimpleRead() throws IOException {
		PersonReaderWriter personIO = new PersonReaderWriter();
		
		List<Person> people = personIO.readPeopleFromCSV("./src/test/resources/simple_read_test.csv");
		Person oldPerson = new Person(293.8,86,40,"gray");
		Person newBorn = new Person(0.4,12,3,"bald");
		
		Assert.assertTrue(people != null && people.size() == 2);
		Assert.assertTrue(people.get(0).equals(oldPerson));
		Assert.assertTrue(people.get(1).equals(newBorn));
	}
	
	

}
