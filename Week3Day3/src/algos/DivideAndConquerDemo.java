package algos;

import java.util.Arrays;

// Divide & Conquer: is an algorithm design paradigm that involves breaking a problem
// down into smaller subproblems, solving each subproblem recursively, and combining
// their solutions to solve the original problem

public class DivideAndConquerDemo {

	public static void main(String[] args) {
		int[] array = {15,2,3,4,9,8,5,1,22,11,60,98,40,35,30,10};
		MergeSort ms = new MergeSort();
		ms.sort(array, 0, array.length - 1);
		System.out.println("Sorted array: ");
		System.out.println(Arrays.toString(array));
	}

}


class MergeSort {
	public void sort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}
	
	private void merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		System.arraycopy(arr, left, L, 0, n1);
		System.arraycopy(arr, mid + 1, R, 0, n2);
		
		int i = 0;
		int j = 0;
		int k = left;
		
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				arr[k++] = L[i++];
			} else {
				arr[k++] = R[j++];
			}
		}
		while (i < n1) {
			arr[k++] = L[i++];
		}
		while (j < n2) {
			arr[k++] = R[j++];
		}
	}
}









