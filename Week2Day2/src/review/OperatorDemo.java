package review;

import java.util.ArrayList;
import java.util.List;

public class OperatorDemo {

	public static void main(String[] args) {
		int a1 = 5;
		// Prefix Increment operator
		int a2 = ++a1; // a1 = 6, a2 = 6
		System.out.println(a1+a2); // 12
		
		int b1 = 5;
		// Postfix decrement operator
		int b2 = b1--; // b2 = 5, b1 = 4
		System.out.println(b1-b2); // -1
		
		List<Integer> numList = new ArrayList<Integer>();
		ArrayList<Integer> numList2 = new ArrayList<Integer>();
		processTheList(numList);
	}
	
	public static void processTheList(List<Integer> theList) {
		
	}

}
