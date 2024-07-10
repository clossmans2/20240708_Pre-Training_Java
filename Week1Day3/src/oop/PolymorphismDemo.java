package oop;

import java.util.ArrayList;

// Polymorphism translates to: 
// Poly - "Many/Multiple" 
// | morph "Forms" 
// | ism "practice/system" 
// Overriding -> changing the behavior of a method in a subclass inherited from a parent class, run time
// Overloading -> multiple methods same name but different arguments in the same class, compile time
// Covariance -> the ability of one class to substitute for another class in its inheritance chain

public class PolymorphismDemo {

	public static void main(String[] args) {
		HondaCivic myCivic = new HondaCivic();
		ToyotaCorrola myToy = new ToyotaCorrola();
		myCivic.lockDoors(1);
		myCivic.lockDoors("A1B2C3D4");
		myCivic.start();
		myCivic.toString();
		ArrayList<Car> autos = new ArrayList<>();
		autos.add(myToy);
		autos.add(myCivic);
		
		// The following line will not compile
		// ToyotaCorrola myOtherToy = new Car();
		Automobile myOtherCivic = new HondaCivic();
	}
}

class Automobile {
	public void start() {
		System.out.println("The automobile has started.");
	}
}

class Car extends Automobile {
	@Override // not required
	public void start() {
		System.out.println("The car has started and is ready to go.");
	}
}

class HondaCivic extends Car {
	private boolean areDoorsLocked;
	// Overloaded method 1
	public void lockDoors(int doorControlNumber) {
		this.areDoorsLocked = true;
		System.out.println("The doors were locked by door control " + doorControlNumber);
	}
	// Overloaded method 2	
	public void lockDoors(String keyFobId) {
		this.areDoorsLocked = true;
		System.out.println("The doors were locked by a key fob with id " + keyFobId);
	}
	
	public void start() {
		System.out.println("The driver turned the key and the engine is on.");
	}
}

class ToyotaCorrola extends Car {
	public void start() {
		System.out.println("The vehicle has started and is ready for driver input.");
	}
}
