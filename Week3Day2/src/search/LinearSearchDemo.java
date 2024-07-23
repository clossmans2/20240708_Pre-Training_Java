package search;

// Linear Search: Simple search algorithm that checks every element in a list sequentially
// until the desired element is found or the list ends.
// Time to run depends on the array input size

public class LinearSearchDemo {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,9,8,5,15,22,11,60,98,40,35,30,10};
		int key = 21;
		int index = LinearSearch.search(array, key);
		if(index != -1) {
			System.out.println("Element found at index: " + index);
		} else {
			System.out.println("Element was not found in the array.");
		}
	}

}

class LinearSearch {
	// O(log(n))
	public static int search(int[] arr, int key) {
		// Loop through the array from the start
		for(int i = 0; i < arr.length; i++) {
			// If our item matches the search key
			if(arr[i] == key) {
				// Return it's position in the array
				return i;
			}
		}
		// If we don't find an item and reach the end
		// Of the list, return -1
		return -1;
	}
}
