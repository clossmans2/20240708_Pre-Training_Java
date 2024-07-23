package recursion;

// Recursion: see Recursion, a function calling itself 
// directly or indirectly until it solves the problem

public class RecursionDemo {

	public static void main(String[] args) {
		long number = 33;
		long result = factorial(number);
		System.out.println("Factorial of " + number + " is: " + result);
	}
	
	public static long factorial(long n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

}
