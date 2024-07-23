package sorts;

import java.util.Arrays;

// Sorting Algorithm: Method of organizing a list of items in a specific order
// (Divide & Conquer Sorting Algorithms)
// Quick Sort: Selects a pivot element and the partitions the array into two
// sub-arrays, elements less than pivot and elements greater than pivot, 
// recursively sorts the sub-arrays
// Merge Sort: Divides the array into sub-arrays repeatedly until they are singular blocks,
// Then merges each sub-array until the full array is sorted


public class SortingDemo {

	public static void main(String[] args) {
		int[] arr = {11, 15, 10, 4, 6, 1, 9, 5};
		int len = arr.length;
		MergeSort.sort(arr, 0,  arr.length - 1);
//		QuickSort.sort(arr, 0, len - 1);
		System.out.print("Sorted number array: ");
		for (int num: arr) {
			System.out.println(num + " ");
		}
//		Arrays.sort(arr);
	}

}

// Time Complexity
// Quick Sort:
// Average: O(n log(n)) Worst: O(n^2) 
// Space Complexity O(log(n))
class QuickSort {
	public static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int part = partition(arr, low, high);
			sort(arr, low, part - 1);
			sort(arr, part + 1, high);
		}
	}
	
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp2 = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp2;
		return i + 1;
	}
}

// Time Complexity
// Merge Sort:
// Average: O(n log(n)) Worst: O(n log(n)) 
// Space Complexity O(n)
class MergeSort {
	public static void sort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			merge(arr, left, mid, right); 
		}
	}
	
	private static void merge(int[] arr, int left, int mid, int right) {
		// left = 0
		// mid = 2
		// right = 7
		int n1 = mid - left + 1; // 3
		int n2 = right - mid; // 5
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for (int i = 0; i < n1; ++i) {
			L[i] = arr[left + i];
		}
		for (int j = 0; j < n2; ++j) {
			R[j] = arr[mid + 1 + j];
		}
		
		int i = 0;
		int j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}






