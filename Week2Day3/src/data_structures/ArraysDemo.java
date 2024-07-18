package data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

	public static void main(String[] args) {
		int[] numArray = {
				600,  200, 300, 400,
				500,  700, 1100, 
				900, 1000, 100, 800 };
		
		Arrays.sort(numArray); // Allows you to sort the array in place in ascending order
		// Requires the list to be sorted, 
		// only finds the first occurrence
		int indexOf700 = Arrays.binarySearch(numArray, 700);
		// Creates a copy of one array to a new array with a specified length
		int[] newNumArray = Arrays.copyOf(numArray, 5);
		// Creates a copy of one array to a new array with a start and end index
		int[] newRangeNumArray = Arrays.copyOfRange(numArray, 5, 10);
		int[] theAnswerArray = new int[42];
		// Fills an array with a specified value
		Arrays.fill(theAnswerArray, 42);
		String[] firstStringGroup = new String[5];
		String[] secondStringGroup = new String[5];
		// Compare equality between arrays with primitive types or ref types
		if (Arrays.equals(numArray, newNumArray)) {
			// Compares ref type arrays for deep equality
			if(Arrays.deepEquals(firstStringGroup, secondStringGroup)) {
				
			}
		}
		// Convenient method to get a string representation of each element in an array
		System.out.println(Arrays.toString(numArray));
		
		// Returns a List representation of an array with changes persisted without dynamic sizing
		List<int[]> numList = Arrays.asList(numArray);
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
	}

}
