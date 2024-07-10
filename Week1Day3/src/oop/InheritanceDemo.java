package oop;

// OOP - 1967 Alan Kay Smalltalk
// OOP is Object Oriented Programming
// 4 main concepts
// 1. Inheritance
// 2. Polymorphism
// 3. Encapsulation
// 4. Abstraction

// Inheritance -> Building a sublcass from a superclass, it inherits
// the attributes and the methods
// Types ->
// A. Single-Level Inheritance: Parent-Child Relationship, Super/Sub class
// B. Multi-Level Inheritance: Grandparent-Parent-Child
// C. Hierarchical Inheritance: One parent to multiple children
// === Unsupported In Java ===
// D. Multiple Inheritance: Two or more parents to a single child
// E. Hybrid Inheritance
public class InheritanceDemo {

	public static void main(String[] args) {
		GreatDane scooby = new GreatDane();
		ShibaInu doge = new ShibaInu();
		
		scooby.speak(); // Instance method on the child class
		doge.speak(); // Instance method on the child class
		scooby.eat(); // Inherited from animal
		doge.eat(); // Inherited from animal
	}

}

class Animal {
	private int numberOfLegs;
	
	public Animal() {
		this.numberOfLegs = 4;
	}
	
	public int getNumberOfLegs() {
		return numberOfLegs;
	}
	
	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}
	
	public void speak() {
		System.out.println("<Animal noise>!");
	}
	
	public void eat() {
		System.out.println("The animal eats food");
	}
}

// Single level of inheritance
class Dog extends Animal {
	private String breed;
	
	public Dog(String breed) {
		this.breed = breed;
	}
	
	public void setBreed(String breed) { 
		this.breed = breed;
	}
	public String getBreed() { 
		return this.breed;
	}
	
	public void speak() {
		System.out.println("Bark!");
	}
}

// Multi-Level Inheritance
class GreatDane extends Dog {
	
	public GreatDane() {
		super("Great Dane");
	}
	
	public void speak() {
		System.out.println("Woof!");
	}
}

// Hierarchical Inheritance
class ShibaInu extends Dog {
	public ShibaInu() {
		super("Shiba Inu");
	}
	
	public void speak() {
		System.out.println("Rawrawraw!");
	}
}








