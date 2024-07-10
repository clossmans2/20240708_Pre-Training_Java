package oop;

// Abstraction -> hiding implementation details and showing only intended functionality to the user
// in an attempt to ease use of the object between various concrete types
// Diff between abstract class and interface
// Abstract keyword vs Default Keyword
// Interface is implemented | abstract class is extended
// Implement multiple interfaces, extend only one abstract class
// Variables in interfaces are static final, can be anything in abstract classes
// Interfaces usually describe behavior (can-be)
// Abstract classes usually describe state/type/shape of an object (is-a)

public class AbstractionDemo {

	public static void main(String[] args) {

	}

}

abstract class Property {
	protected String address;
	public double value;
	
	abstract double determineValue();
	
	public String getLocation() {
		return this.address;
	}
}

class House extends Property implements Rentable {

	@Override
	public double determineValue() {
		return this.value;
	}
	
	public double getMonthlyRentCost() {
		return this.value / 24;
	}
	
}

interface Rentable {
	double getMonthlyRentCost();
}

