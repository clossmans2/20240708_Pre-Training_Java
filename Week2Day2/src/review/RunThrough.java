package review;

import java.time.LocalDate;

// Java topics review
// Class is a blueprint, the object is an instance of the class
// Everything derives from the Object class
// The Object class gives everything a default constructor
// ^ and toString and equals

public class RunThrough {
	// Static keyword on variable
	// Bound to the class definition instead of the instance
	// All instances have access but the same value for all
	// Changing the value from one instance will change it for all instances
	// Because they all point back to the class
	private static int theAnswer = 42;
	
	// Static keyword on a method
	// The method does not require the containing class to be instantiated
	// to run the method (RunThrough.main();)
	// Can't operate on instance properties with "this"
	public static void main(String[] args) throws Exception {
		Person newPerson = new Person();
		Child person = new Child("Seth");
		person.talk();
		// Obj ref = Obj instance
		Demo demo = new Demo();
		// De-referencing an object
		// Cant get it back
		demo = null;
		System.gc();
		try {
			Thread.sleep(1000);
			throw new Exception("An error occurred.");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw new Exception("An error occurred.");
		} finally {
			System.out.println("Will run after all exceptions or the try.");
		}
		
		// Lambda Expressions
		// Anonymous method/function usually assigned to variable
		// Defined in-line, uses () -> {}
		Thread myLuckyNumber = new Thread(() -> {});
		
		// Multi-threading: Multiple threads running at the same time using shared resources
		// ^ Why?: Using more threads we can process through tasks faster than with a single thread
		
		// Java Memory Allocation
		// Stack vs Heap
		// Stack: Used to store variables, parameters, primitive data types, object references
		// ^ Emptied at the end of the function, memory released
		// Heap: Dynamic memory, objects themselves, 
		// objects are removed when they are no longer referenced in the stack
		
	}
	
	// Static keyword on a nested class
	// Can be instantiated
	// Can only exist on a nested
	// Inner belongs to the outer class definition
	// Can't access non-static properties of containing class unless passed to the class
	// as an object
	static class Demo {
		
	}

}

class Person {
	// private property
	private int age;
	// Final keyword on a variable
	// Cant be changed after it is initialized
	private final String dnaSequence = "ATGCGATCCTAGGGCATAGC";
	// Can either be set in-line or in the constructor
	private final LocalDate dateOfBirth;
	// Constructor -> Method that uses the same name as 
	// the class to instantiate an object from the class
	public Person() {
		this.age = 0;
		this.dateOfBirth = LocalDate.now();
	}
	// Overloaded constructor
	// Same name, inside the same class, different params
	// Happens at compile time, compiler can see the usage and arguments
	public Person(int age) {
		this.age = age;
		this.dateOfBirth = LocalDate.now();
	}
	
	
	public void talk() {
		System.out.println("Hello!");
	}
	
	// Final keyword used on a method
	// Prevents the method from being overridden
	public final void blink() {
		
	}
	

	
	// Encapsulation -> Binding of class properties and methods into a single unit
	// to secure the data in the class and ensure data integrity
	// Fully encapsulated -> All the variables inside the class are private and only
	// accessible through getters and setters
	// (Most accessible -> Least Accessible)
	// Public, Protected, Default, Private
	// Protected is accessible in subclasses, Default is not
	
	// Getter (accessor)
	public int getAge() {
		return this.age;
	}
	// Setter (mutator)
	public void setAge(int age) {
		this.age = age;
	}
}

// Inheritance -> Create a new class from an existing class using the keyword extends
// Child classes inherit the properties and behaviors of a parent class
// Can only inherit from one class
// Types: Hierarchical, Single-Level, Multi-Level | Multiple, Hybrid

// Final keyword used on a class
// Cannot be inherited
final class Child extends Person {
	private String name;
	
	public Child(String name) {
		super(5);
		this.name = name;		
	}
	
	// Polymorphism -> Many forms
	// Overriding and Overloading
	// Overriding: Subclass can alter the behavior of a method 
	// passed down from a super class
	// Happens at run time - checks if the lowest class 
	// in the inheritance tree has the method and moves up trying to find it
	@Override
	public void talk() {
		System.out.println("Hi!");
	}
	
}

// Abstraction -> Showing the user only whats necessary for them to use the object
// Think of driving a car, only need to know where the steering wheel, accelerator and
// brake pedals, and how to shift the car from park to drive, maybe how to start the car

// Abstract class vs Interface
// 1. Methods
// Out of the box, interface methods are abstract unless proceeded by the keyword default
// Abstract class methods are concrete unless proceeded by the keyword abstract
// 2. Usage keywords
// Abstract classes are generally extended from, interfaces are normally implemented
// An interface can extend another interface
// 3. Conceptual Usage
// Abstract class usually defines state/properties that a class will inherit
// Interfaces usually define the intended behavior/methods that a class will implement

interface Walker extends Crawler {
	void walk();
}

interface Crawler {
	void crawl();
}

abstract class Neurodivergent {
	// Abstract
	public abstract void talk();
	// Concrete
	public void speak() {
		
	}
}


