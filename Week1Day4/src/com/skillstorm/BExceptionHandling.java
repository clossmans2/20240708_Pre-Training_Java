package com.skillstorm;

import java.util.IllegalFormatConversionException;
import java.util.Random;
import java.util.Scanner;

// Resource: https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html
public class BExceptionHandling {

	public static void main(String[] args) {

//		main(null); // java.lang.StackOverflowError

		///////////////////////////////////
		// Types of exceptions
		// Checked Exceptions - you are required to handle them or specify
		// Unchecked Exceptions - these are runtime exceptions in the inheritance
		/////////////////////////////////// hierarchy

		///////////////////////////////////
		// Definition:
		// Exceptino - the unexcpected event that interupts the nomrmal flow of the
		/////////////////////////////////// program
		// Exception - the object Java creates holding data about what went wrong and
		/////////////////////////////////// what was happening

		//////////////////////////////////
		// Exception Handling

		// try-catch multiple
//		try {
//			float x = 1;
//			float y = 1;
//			System.out.println(x / y);
//			System.out.printf("x = %d, y = %d%n", x, y); //  java.util.IllegalFormatConversionException
//		} catch (ArithmeticException | IllegalFormatConversionException e) {
//			System.out.println(e.getLocalizedMessage());
//		}
		
		// try-catch-catch
//		try {
//			int a = 1;
//			int b = 0;
//			System.out.println(a / b);
//			double x = 1.5;
//			double y = 2.4;
//			System.out.printf("x = %d, y = %d%n", x, y); //  java.util.IllegalFormatConversionException
//		} catch (ArithmeticException e) {
//			System.out.println("Was not able to find a solution to the arithmetic problem");
////			System.out.println("because b was " + b); // b is block scoped to only exist in the try-block
//		} catch (IllegalFormatConversionException e) {
//			System.out.println("Was not able to parse the values to display the string");
//		}
		
		// try-catch-catch-catch
//		try {
//			int a = 1;
//			int b = 1;
//			System.out.println(a / b);
//			double x = 1.5;
//			double y = 2.4;
//			System.out.printf("x = %f, y = %f%n", x, y); //  java.util.IllegalFormatConversionException
//			int[] nums = {1, 2, 3};
//			System.out.println(nums[-1]);
//		} catch (IllegalFormatConversionException e) {
//			System.out.println("Was not able to parse the values to display the string");
//		} catch (ArithmeticException e) {
//			System.out.println("Was not able to find a solution to the arithmetic problem");
////			System.out.println("because b was " + b); // b is block scoped to only exist in the try-block
//		} 
		
		// try-catch-finally
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println();
			System.out.print("Guess a number 1-10: ");
			int guess = scanner.nextInt(); 
			
			// 2 ways to generate a random number java.lang.Math.random() or java.util.Random
			int answer = new Random().nextInt(10); // gives me 0 to 9 inclusive
			answer++; // gives me 1 to 10
			answer = answer / 0;
			System.out.printf("[debugging purposes you can see the number generated is %d]%n", answer);
					
			if (guess == answer) {
				System.out.println("Correct!");
			} else {
				System.out.println("Sorry, the correct number was " + answer);
			}
		} catch (java.util.InputMismatchException e) {
			System.out.println(e.getClass());
		} finally {
			// code I want to run whether
			// - try executed normally
			// - catch caught an exception
			// - try threw an uncaught exception 
			if (scanner != null)
				scanner.close();
		}
		System.out.println("Continued to execute code");
	}

	public static void example1() {
		////////////////////////////////////
		// Code that causes an exception
		int x = 1;
		int y = 0;

		// Guard clause
		if (y == 0) {
			System.out.println("Cannot divide by zero");
		} else {
			System.out.println(x / y); // java.lang.ArithmeticException: / by zero
		}
		System.out.println("Continued to execute code");
	}

	public static void example2() {
		int x = 1;
		int y = 0;

		// try-catch
		try {
			System.out.println(x / y);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Continued to execute code");
	}

}
