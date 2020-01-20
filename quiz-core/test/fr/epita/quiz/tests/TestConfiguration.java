package fr.epita.quiz.tests;

import fr.epita.quiz.services.data.Configuration;

public class TestConfiguration {

	
	public static void main(String[] args) {
		//given
		//the conf.properties exists and contain a "data.file" property
		
		//when
		String value = Configuration.getValue("data.file");
		
		
		//then
		boolean success = value.equals("data.csv");
		System.out.println("success ? " + success); 
		
		
	}
}
