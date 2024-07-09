package modifiers;

public class Extra {
	// Static = belongs to the class and not the instance
	public static String staticMessage = "Hello, World!";
	public final String nonStaticMessage;
	
	public Extra() {
		nonStaticMessage = "Hello, World!";
	}
	
	public Extra(String nsMessage) {
		nonStaticMessage = nsMessage;
	}
	
	public static void main(String[] args) {
		Extra ex1 = new Extra("New message");
		Extra ex2 = new Extra();
		Extra ex3 = new Extra();
		
		print(ex1.staticMessage);
		ex1.staticMessage = "Hello Seth!";
//		ex1.nonStaticMessage = "Hello Clossman";
		print(ex1.nonStaticMessage);
		print(ex2.nonStaticMessage);
		print(ex2.staticMessage);
		print(ex3.staticMessage);
		Extra.print(staticMessage);
	}
	
	// 
	public static final void print(String msg) {
		System.out.println("Output: " + msg);
	}
	
	static class Car {
		
	}
	
	static {
		System.out.println("Inside a static block");
	}
	

}
// Final prevents any subclasses from being created
final class DatabaseConfiguration {
	
}
// Will show an error because of extension of a final class
//class MySqlDatabaseConfiguration extends DatabaseConfiguration {
//	
//}

class ExtraPartTwo extends Extra {
	// The print method can't be overridden
	//	public static void print(String msg) {
//		
//	}
}
