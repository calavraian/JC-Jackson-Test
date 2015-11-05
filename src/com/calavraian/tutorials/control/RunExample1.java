package com.calavraian.tutorials.control;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import com.calavraian.tutorials.jacksontest.People;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RunExample1 {
	
	public static void main(String[] args) {
		//Ejemplo 1
		readJSON();
		
		writeJSON();
	}

	private static void writeJSON() {
		People objectToParse = new People();
		ObjectMapper mapperObj = new ObjectMapper(); // Se construye una sola vez y se puede utilizar en todos los casos presentados abajo

		// Se registran los valores de la instancia del objeto que sera usado en todos los casos siguientes
		objectToParse.name = "Comming Soon";
		objectToParse.email = "comming@example.com";
		objectToParse.age = 0;
		
		// El try catch es necesario para este tipo de evaluacion pero se puede hacer un through al inicio de la clase
		// por otro lado se puede hacer un mejor detalle del catch para personalizar las excepciones posibles y no usar una sola generica
		try {
			mapperObj.writeValue(new File("Resources/Example1Output.json"), objectToParse);
			
			System.out.println("File saved with new data");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// otra forma:
		// Los bytes se mostraran como un arreglo de enteros, si se necesita el caracter es necesario convertirlo
		try {
			byte[] jsonBytes = mapperObj.writeValueAsBytes(objectToParse);
			
			System.out.println("Bytes array: " + Arrays.toString(jsonBytes));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		// otra forma:
		// Se obtiene el valor completo del objeto en una cadena en formato de JSON
		try {
			String jsonString = mapperObj.writeValueAsString(objectToParse);
			
			System.out.println("String: " + jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	private static void readJSON() {
		ObjectMapper mapperObj = new ObjectMapper(); // Se construye una sola vez y se puede utilizar en todos los casos presentados abajo

		
		// Lectura directa de un archivo dentro del proyecto
		// El try catch es necesario para este tipo de evaluacion pero se puede hacer un through al inicio de la clase
		// por otro lado se puede hacer un mejor detalle del catch para personalizar las excepciones posibles y no usar una sola generica
		try {
			People dataFromFile = mapperObj.readValue(new File("Resources/DataExample1.json"), People.class);
			
			System.out.println("Name: " + dataFromFile.name);
			System.out.println("Email: " + dataFromFile.email);
			System.out.println("Age: " + dataFromFile.age);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// otra forma:
		// Directo de un archivo en un servidor (URL)
		try {
			People dataFromURL = mapperObj.readValue(new URL("http://calavraian.com/DataExample1.json"), People.class);
			
			System.out.println("Name: " + dataFromURL.name);
			System.out.println("Email: " + dataFromURL.email);
			System.out.println("Age: " + dataFromURL.age);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// otra forma:
		// Escribiendo la cadena directo en el metodo, recuerden espacar el caracter "
		// Otra forma es obviamente creando una cadena tipo String tomando valores de diferentes lados y despues se para
		// como parametro
		try {
			People dataFromText = mapperObj.readValue("{\"name\":\"Elizabeth\", \"email\":\"eliza@example.com\", \"age\":25}", People.class);
			
			System.out.println("Name: " + dataFromText.name);
			System.out.println("Email: " + dataFromText.email);
			System.out.println("Age: " + dataFromText.age);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
