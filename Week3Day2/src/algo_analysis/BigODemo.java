package algo_analysis;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
// Big O Notation: A way to represent the amount of time required for an operation to be
// performed based on the number of elements provided to the operation.
// Shows best, worst and average for an operation
// Time Complexity: How long it takes to run an operation with N number of elements
// Space Complexity: How much space (memory) an operation uses to complete


public class BigODemo {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,9,8,5,15,22,11,60,98,40,35,30,10};
		//BigODemo.printFirstNumber(array);
		//BigODemo.printArray(array);
		//BigODemo.printArray2(array);
		//BigODemo.stringPerms("supercalifragilisticexpialidocious");
		//int[] simpleArray = {1,2,3,4,5};
		//BigODemo.listCombinations(array);
		System.out.println(BigODemo.fibonacci1(18));
	}
	
	// Not super useful
	// Given N size input array of numbers
	// It will always take the same amount of time to run
	// O(1) Constant Time
	public static void printFirstNumber(int[] numbers) {
		System.out.println(numbers[0]);
	}
	
	
	// Given N size input array of numbers
	// It will always take the same amount of time to run
	// O(1)  [Technically O(3)]
	public static void printFirstThree(int[] numbers) {
		System.out.println(numbers[0]);
		System.out.println(numbers[1]);
		System.out.println(numbers[2]);
	}
	
	// Given N size input array of numbers
	// The time it takes to run this method increases
	// proportionally as the size of the array goes up
	// O(n) Linear time
	public static void printArray(int[] numbers) {
		System.out.print("Array: { ");
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.print("}");
	}
	
	// As the number of items increases
	// The time it takes to run increases by
	// O(n^2)  [O(n + n^2)]
	public static void printArray2(int[] numbers) {
		for(int first : numbers) {
			for (int second : numbers) {
				System.out.println(first + " " + second);
			}
		}
	}
	
	// Find all possible permutations of a string
	// As the length of the input string changes
	// The time it takes to run changes based on N!
	// O(n!)
	private static void perms(String perm, String word) {
		if(word.isEmpty()) {
			System.out.println(perm + word);
		} else {
			for (int i = 0; i < word.length(); i++) {
				perms(perm + word.charAt(i), 
					  word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
	}
	
	public static void stringPerms(String input) {
		perms("", input);
	}
	//O(n^2)
	private static List<ArrayList<Integer>> genCombinations(int[] array) {
		ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < (1 << array.length); i++) { // O(n)
			ArrayList<Integer> combo = new ArrayList<Integer>();
			for(int j = 0; j < array.length; j++) { // O(n)
				if ((i & (1 << j)) > 0) {
					combo.add(array[j]);
				}
			}
			combinations.add(combo);
		}
		
		return combinations;
	}
	// O(2^n) time complexity
	public static void listCombinations(int[] array) {
		for (ArrayList<Integer> combo : genCombinations(array)) { // O(n)
			System.out.println(Arrays.toString(combo.toArray()));
		}
	}
	
	// O(n) Space Complexity
	public static int fibonacci1(int n) {
		// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(0);
		arr.add(1);
		for(int i = 2; i <= n; ++i) {
			arr.add(arr.get(i - 2) + arr.get(i - 1)); // O(n) Space
		}
		return arr.get(n);
	}
	
	// O(1) space complexity
	public static int fibonacci2(int n) {
		int x = 0; // O(1)
		int y = 1; // O(1)
		int z = 0; // O(1)
		
		// If n is 0, return 0
		if (n == 0) {
			return x;
		} else if (n == 1) {
			return y;
		}
		for (int i = 2; i <= n; ++i) { // O(1)
			z = x + y;
			x = y;
			y = z;
		}
		return z;
	}
	
	
}




