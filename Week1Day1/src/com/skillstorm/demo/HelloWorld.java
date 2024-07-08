package com.skillstorm.demo;

import java.util.ArrayList;

// java.lang.Object <- root class
// JDK = Java Development Kit
// JRE = Java Runtime Environment
// JVM = Java Virtual Machine
// Compilation produces Bytecode
// Write Once, Run Anywhere

import com.skillstorm.models.Car;

public class HelloWorld {
	
	public static void main(String[] args) {
		// Creating a new instance of the Animal class
		Animal animal = new Animal();
		// Calling the speak method of the Animal typed object
		animal.speak();
		Car car3 = new Car("Black", "Toyota", "Tacoma", 4);
		car3.displayDetails();
		
		// Primitive data types
		// int max = 2147483647
		int age = 36;
		int maxValue = Integer.MAX_VALUE;
		// long max = 2^
		long lMaxValue = Long.MAX_VALUE;
		// Char 
		char letterA = 'A';
		char defaultChar = '\u0000';
		// Boolean - true/false
		boolean isJavaFun = true;
		boolean defaultBool = false;
		// Float - 0.0f
		float temperature = 85.0f;
		// Double
		double cashValue = 99.99d;
		// Short max 127
		short smallValues = 15;
		// Non-primitive types
		// String
		String greeting = "Hello, World!";
		// Array
		String[] food = {"apple", "cheese"};
		Dog dog = new Dog("Labrador Retriever");
		dog.breed();
		
		// Operators
		int aValue = 25;
		int bValue = 75;
		// Math operators
		int sum = aValue + bValue;
		int result = bValue - aValue;
		int product = aValue * bValue;
		int quotient = bValue / aValue;
		// Equality
		boolean isEqual = (aValue == bValue);
		boolean isNotEqual = (aValue != bValue);
		boolean isGreaterThan = (aValue > bValue);
		boolean isLessThan = (aValue < bValue);
		boolean isGreaterThanOrEqual = (aValue >= bValue);
		boolean isLessThanOrEqual = (aValue <= bValue);
		// Increment Addition Operator
		int a = 5;
		// Postfix Increment Addition Operator
		int b = a++; // b = 5; a = 5 + 1 = 6;
		int incAddResult = a + b; // 11
		// Prefix Increment Addition Operator
		int c = 5; // c = 5
		int d = ++c; // c = 5 + 1 = 6; d = 6;
		int preIncAddResult = c + d; // 12
		// Decrement Operator --
		// Expressions
		int overallResult = (a + b - c + d) * 4; //44
		System.out.println(overallResult);
		// Control Flow
		// If Else
		if (a == 5) {
			System.out.println("A = 5");
		} else {
			System.out.println("A is not 5");
		}
		// Switch-Case, While, Do-While, For, For (each)
	}
	
	String message;
	
}

class Animal {
	private int numberOfLegs;
	
	public Animal() {
		
	}
	
	public void speak() {
		System.out.println("<Animal noise!>");
	}
}

record Dog(String breed) {};
