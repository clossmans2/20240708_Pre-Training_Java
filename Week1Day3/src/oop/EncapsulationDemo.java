package oop;

// Encapsulation -> wrapping/binding related data (variables/properties) and behavior (methods/functions)
// together into a single unit, and to restrict direct access to protect the integrity of data inside that class
// Involves access modifiers
// default, public, private, protected
// Modules

public class EncapsulationDemo {

	public static void main(String[] args) {
		Person seth = new Person();
		seth.setName("Seth");
		seth.setAge(55);
		System.out.println("Name: " + seth.getName());
		System.out.println("Age: " + seth.getAge());
	}
	
}

class Person {
	private String name;
	private int age;
	
	public Person() {
		this.age = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		if (age > 30) {
			return 30;
		} else {
			return age;
		}
	}
	
	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		} else {
			System.out.println("Age must be positive");
		}	
	}
	
	protected void introduceYourself() {
		System.out.println("Hi! I'm " + this.name + ", And I'm " + this.age + " years old!");
	}
}

class Dude extends Person {
	public void introduceYourself() {
		System.out.println("Hi! I'm " + this.getName() + ", And I'm " + this.getAge() + " years old!");
	}
}


