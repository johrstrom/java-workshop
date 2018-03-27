package com.github.johrstrom.workshop;

import java.util.List;

import com.github.johrstrom.workshop.person.Person;
import com.github.johrstrom.workshop.person.PersonReaderWriter;

public class WorkshopMain {

	public static void main(String[] args) {
		
		PersonReaderWriter personIO = new PersonReaderWriter();
		
		try {
			List<Person> people = personIO.readPeopleFromCSV(args[0]);
			personIO.printJSON(people);
			
		} catch (Exception e) {
			System.err.println(String.format("Didn't process file because of %s: %s", 
					e.getClass().toString(),e.getLocalizedMessage()));
		}
		
	}

}
