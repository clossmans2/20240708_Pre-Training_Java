package poly;

public class LoadAndRide {

	private int currentValue = 0;
	
	public static void main(String[] args) {
		
	}
	
	// Method Overloading -> 2 or more methods with the same name inside
	// the same class but with a different number or types of parameters
	
	public int add(int a, int b) {
		this.currentValue = a + b;
		return currentValue;
	}
	
	public int add(int a, int b, int c) {
		this.currentValue = a + b + c;
		return currentValue;
	}
	
	public int add(int[] numbers) {
		for(int num : numbers)
			currentValue = currentValue + num;
		
		return currentValue;
	}
	
}


