package modifiers;

public class Access {
	// Java has 4 "access" modifiers
	// public - open to the world
	// protected - open to subclass and the package
	// "default" or no modifier - open to the package
	// private - open only to the class

	public static void main(String[] args) {
		
	}
	
}

class Animal {
	protected int numberOfLegs;

	private int age;
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		if (age < 0) {
			this.age = 0;
		} else {
			this.age = age;			
		}		
	}
	
	public int getNumberOfLegs() {
		return numberOfLegs;
	}
	
	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}
}

class Dog extends Animal {
	public Dog() {
		this.setNumberOfLegs(4);
	}
}
