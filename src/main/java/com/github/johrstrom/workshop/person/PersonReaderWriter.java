package com.github.johrstrom.workshop.person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonReaderWriter {
	
	/**
	 * Print all the people out to standard out, in json format.
	 * 
	 * @param people
	 */
	public void printJSON(List<Person> people) {
		
		for(Person person : people) {
			System.out.println(person.toJsonString());
		}
		
	}
	
	/**
	 * Read a file that is a CSV representation of the {@link com.github.johrstrom.workshop.person#Person}
	 * of the format
	 * 
	 * height (int),weight (int),age (double),hair color (string) 
	 * 
	 * @param filename the input file
	 * @return a list of people read from the file.
	 * @throws IOException if there are problems reading the fiel
	 */
	public List<Person> readPeopleFromCSV(String filename) throws IOException {
		List<Person> people = new ArrayList<Person>();
		
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		
		for (String line = reader.readLine(); line != null; line = reader.readLine()) {
		   Person person = tupleToPerson(line);
		   
		   if(person != null) {
			   people.add(person);
		   }
		}
		
		reader.close();
		return people;
	}
	
	/**
	 * Covert a CSV string in the appropriate format and length to a {@link com.github.johrstrom.workshop.person#Person}
	 * 
	 * @param tuple the CSV representation of the person
	 * @return the person object if no failures. null if there are failures in parsing or length of the tuple.
	 */
	protected Person tupleToPerson(String tuple) {
		
		String[] fields = tuple.split(",");
		if(fields.length == 0 || fields.length > 4)
			return null;	//interface contract: this returns null if it can't build the object correctly
		
		try {
			double age = Double.parseDouble(fields[0]);
			int height = Integer.parseInt(fields[1]);
			int weight = Integer.parseInt(fields[2]);
			String hairColor = fields[3];
			
			return new Person(age,height,weight,hairColor);
			
		// all or nothing. the interface contract; this function either fully builds the object or returns null
		}catch(Exception e) {
			System.err.println(String.format("Cant parse %s into Person because of %s:%s", 
					tuple, e.getClass().toString(), e.getLocalizedMessage()));
			return null;	
		}
	}

}
