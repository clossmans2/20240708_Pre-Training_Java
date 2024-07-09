package poly;

// You can go for more access (private to public) in the implementing class
// But you cannot go for less (public to private) or you'll receive a compiler error
public class FlyingCar implements OperateCar, FlyCar {

	public int startEngine(String key) {
		FlyCar.super.startEngine(key);
		OperateCar.super.startEngine(key);
		return 1;
	}
	
	public static void main(String[] args) {
		
	}
}
// Bonus fact: Static methods defined inside an interface
// Will never be inherited
interface OperateCar {
	default public int startEngine(String key) {
		return 1;
	}
}

interface FlyCar {
	default public int startEngine(String key) {
		return 2;
	}
}
