package data_structures;

import java.util.Arrays;

// Array: linear data structure, can hold multiple values in a single variable, contiguous
// (meaning same memory location), primitive values or objects/reference types
// ArrayList: dynamic/re-sizeable array, implements List interface, reference types only (Objects)

public class ArrayDemo {

	public static void main(String[] args) {
		int[] numArray = {
				100, 200, 300, 400,
				500, 600, 700, 800,
				900, 1000, 1100 };
		
		int[] intArray = new int[12];
		
		System.arraycopy(numArray, 0, intArray, 0, 11);
		System.out.println(intArray.toString());
		//if(numArray.equals(intArray)) {
		System.out.println(Arrays.compare(numArray, 0, 11, intArray, 0, 11));
		Arrays.sort(intArray);
		System.out.println(Arrays.binarySearch(intArray, 500)); //4
		System.out.println(Arrays.mismatch(numArray, intArray));
		//}
		System.out.println(Arrays.toString(intArray));
	}

}
