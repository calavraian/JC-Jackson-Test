package com.calavraian.tutorials.control;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.calavraian.tutorials.jacksontest.People;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RunExample1 {
	
	public static void main(String[] args) {
		//Example 1
		ObjectMapper mapperObj = new ObjectMapper();

		try {
			People dataFromFile = mapperObj.readValue(new File("Resources/DataExample1.json"), People.class);
			
			System.out.println("Name: " + dataFromFile.name);
			System.out.println("Email: " + dataFromFile.email);
			System.out.println("Age: " + dataFromFile.age);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// or:
		try {
			People dataFromURL = mapperObj.readValue(new URL("http://calavraian.com/DataExample1.json"), People.class);
			
			System.out.println("Name: " + dataFromURL.name);
			System.out.println("Email: " + dataFromURL.email);
			System.out.println("Age: " + dataFromURL.age);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
