package com.calavraian.tutorials.control;

import java.io.File;
import java.io.IOException;

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
	}
}
