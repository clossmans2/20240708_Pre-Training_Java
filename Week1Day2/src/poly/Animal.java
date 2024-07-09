package poly;

// Method Overriding
// When an instance method in a subclass with the same signature
// (plus the number and type of its parameters) and return type 
// as an instance method in a superclass
// Method hiding
// When a subclass defines a static method with the same signature
// as a static method in the superclass
public class Animal {
	public static void main(String[] args) {
		Cat phantom = new Cat();
		Animal feline = phantom;
		Animal.testClassMethod();
		feline.testInstanceMethod();
	}
	
	public static void testClassMethod() {
		System.out.println("The static method in Animal");
	}
	
	public void testInstanceMethod() {
		System.out.println("The instance method in Animal");
	}
}

class Cat extends Animal {
	public static void testClassMethod() {
		System.out.println("The static method in Cat");
	}
	public void testInstanceMethod() {
		System.out.println("The instance method in Cat");
	}
}

