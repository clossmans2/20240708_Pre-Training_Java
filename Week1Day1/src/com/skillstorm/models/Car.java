package com.skillstorm.models;

public class Car {

	String color;
	String model;
	String make;
	int numberOfDoors;
	
	public static void main(String[] args) {
		int coupeDoors = 2;
		int sedanDoors = 4;
		Car car1 = new Car("White", "Honda", "Ridgeline", sedanDoors);
		Car car2 = new Car("Blue", "Hyundai", "Sonata", coupeDoors);
		car1.displayDetails();
		car2.displayDetails();
	}
		
	public Car(String color, String make, String model, int doorNumber) {
		this.color = color; 
		this.make = make;
		this.model = model;
		this.numberOfDoors = doorNumber;
	}
	
	public void displayDetails() {
		System.out.println("Color: " 
							+ color 
							+ ", Make: " 
							+ make 
							+ ", Model: " 
							+ model
							+ ", Number of Doors: "
							+ numberOfDoors);
	}
}
