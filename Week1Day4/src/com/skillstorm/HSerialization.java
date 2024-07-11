package com.skillstorm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.skillstorm.pojos.AnimalClass;

public class HSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

//		System.out.println(System.getProperty("user.dir")); // current working directory
		String filepath = "src/com/skillstorm/resources/"; // relative to working directory
		String filename;
		//////////////////////////////////////////////////////////
		// Example 1: Instantiate an object and save it to a file
		
		/////////////////////////////////////////////////////////
		// Example 2: Read the data from the file

		/////////////////////////////////////////////////////////
		// Example 3: 
		// Read the data from sad-dog.dat
		// What is wrong with the data?
		// Why didn't the guard clauses prevent these values?
//		filename = "sad-dog.dat";
//		readData(filepath + filename); 
		
		/////////////////////////////////////////////////////////
		// Example 4: 
		// Try saving some data, then changing the serialVersionUID.
		// What happens when you try to read the data saved before the change?
		
		/////////////////////////////////////////////////////////
		// Example 5:
	    // Try marking year as transient, then saving some data.
		// What happens when you read the data back?
	}

	public static <T> void saveData(T obj, String filename) throws IOException {
		
	}

	public static void readData(String filename) throws IOException, ClassNotFoundException {
		
	}

}

class Car implements Serializable {
	////////////////////////////////////////////////////////
	// Try saving some data, then changing the serialVersionUID.
	// What happens when you try to read the data saved before the change?
	private static final long serialVersionUID = 1L;
	
	private String make;
	private String model;
	
	/////////////////////////////////////////////////////////
	// Try marking year as transient, then saving some data.
	// What happens when you read the data back?
	private int year; 

	public Car() {
		this.make = "Kia";
		this.model = "Rio";
		this.year = 2024;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", year=" + year + "]";
	}

}
