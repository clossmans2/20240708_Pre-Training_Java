package control_flow;

public class Logic {

	public static void main(String[] args) {
		int numberToTest = 0;
		
		// Regular If Else
		if (numberToTest >= 1) {
			System.out.println("Number greater than or equal to 1");
		} else {
			// Do something with a 0
		}
		
		int dayNumber = 4;
		String dayText;
		
		// Switch Case
		switch (dayNumber) {
			case 1:
				dayText = "Sunday";
				break;
			case 2:
				dayText = "Monday";
				break;
			case 3:
				dayText = "Tuesday";
				break;
			case 4:
				dayText = "Wednesday";
				break;
			case 5:
				dayText = "Thursday";
				break;
			case 6:
				dayText = "Friday";
				break;
			case 7:
				dayText = "Saturday";
				break;
			
			default:
				System.out.println("Day outside normal bounds.");
				dayText = "Unknown Day";
		}
		
		System.out.println(dayText);
		
		// Standard For Loop
		for (int i = 1; i < 10; i++) {
			System.out.println("The value of i is: " + i);
			i++;
		}
		int n = 1;
		// Nearly unreadable for loop that still works
		for (; n < 10;) {
			System.out.println("The value of n is: " + n);
			n++;
		}
		
		int[] numbersToCheck = {1,2,3,4,5};
		
		// For each loop
		for (int num : numbersToCheck) {
			System.out.println("Number " + num);
		}
		
		int count = 0;
		
		while (count < 2) {
			System.out.println("Still inside While Loop");
			System.out.println("Count " + count);
			count++;
		}
		
		do {
			System.out.println("Inside Do-While Loop");
			System.out.println("Count " + count);
			count++;
		} while (count < 2);
		
		
		
	}
	
	
	
	
	
	
	public static void print(String msg) {
		System.out.println(msg);
	}
	
	

}
