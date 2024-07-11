package com.skillstorm;


import java.util.Random;

// Notes:
// imports make classes from other packages available by name

import java.util.Scanner;
import java.util.random.*; 

public class AScannerExamples {
	
	public static void main(String[] args) {
		// Example 1: Prompting a user
		//  Steps:
		//   - create scanner
		Scanner scanner = new Scanner(System.in);
		//   - print prompt
		System.out.print("Please enter your name: ");
		//   - read input
		String name = scanner.next();
		//   - do something with the data
		String message = "Hello, " + name;
		//   - print response
		System.out.println(message);
		
		// Hello, {name}
		

		// Example 2: Reading in different data types
		// What are the primitive
		// - byte
		// - short
		// - char
		// - int 
		// - long
		// - float
		// - double
		// - boolean
		
		
		// Guess a number 1-10:
		System.out.println();
		System.out.print("Guess a number 1-10: ");
		int guess = scanner.nextInt(); 
		
		// 2 ways to generate a random number java.lang.Math.random() or java.util.Random
		int answer = new Random().nextInt(10); // gives me 0 to 9 inclusive
		answer++; // gives me 1 to 10
		System.out.printf("[debugging purposes you can see the number generated is %d]%n", answer);
				
		if (guess == answer) {
			System.out.println("Correct!");
		} else {
			System.out.println("Sorry, the correct number was " + answer);
		}
		////////////////////////////////////////////////////////////////////
		// TODO create a FileWriter and record the resulsts of each game
		////////////////////////////////////////////////////////////////////
		
		// Try entering in "Ten" instead of 10
		// What happens? java.util.InputMismatchException
		
		
		// Example 4: do-while re-prompt
				
		scanner.close();
	}


}
