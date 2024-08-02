package review;

// Class vs Object: class is blueprint with methods and attributes,
// object is an instance of the class
// 

public class Overview {
	public static void main(String[] args) {
		Overview overview = new Overview();
	}
	
	// Constructor: method that initializes the class and variables in it
	// Object class gives us implicit default constructor
	public Overview() {}
	
	// OOP
	// Abstraction - hide implementation details from the user and expose
	//	only what's needed to interact with the object (Car metaphor)
	// Polymorphism - many forms, gives a class flexibilty to inherit code
	//  and change the implementation of methods as needed, Covariance, Method Overloading/Overriding
	// Inheritance - A class inherits the attributes and methods of a parent/super class
	// Encapsulation - Wrapping/binding of data into a single class and controlling
	// 	access to variables in the class through access modifiers and getters/setters
	
	// Array vs ArrayList
	// Array: Fixed size, contiguous, can hold primitives and reference types
	// ArrayList: Dynamic sizing based on items inside, can only handle objects/ref types
	
	// LinkedList: collection of nodes, first node is head, each node has data and a reference to the next node
	// DoubleLinkedList: previous and next nodes, usually has a head and tail
	// CircularLinkedList: tail points to the head
	
	// Foreign Key: column in one table that points to a primary key in another table
	// Primary Key: unique and not null identifier for each row in the table (entity integrity)
	// Difference Between Left Join and Inner Join:
	// Left: Returns everything from the left table and matches found in the right table
	// Inner: Only returns rows that match the condition between the two tables
	
	// Diff between Abstract Classes and Interfaces
	// AC: concrete methods and properties unless labeled "abstract", can only be extended once
	// I: abstract methods and final static properties unless labeled default, can implement multiple
	
		
}
