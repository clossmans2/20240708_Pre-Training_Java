package wrappers;

import java.util.ArrayList;
import java.util.List;

public class Boxes {

	public static void main(String[] args) {
		// Primitive Type	|   Wrapper Class
		// boolean			|	Boolean
		// byte				| 	Byte
		// char				|	Character
		// float			|	Float
		// int				|	Integer
		// long				|	Long
		// short			|	Short
		// double			|	Double
		
		int myNumber = 5;
		// Wrapping primitive myNumber into an object
		Integer myWrapperForNumber = Integer.valueOf(myNumber);
		// Unwrapping the Integer object to get access to the primitive value
		int myUnwrappedNumber = myWrapperForNumber.intValue();
		
		List<Integer> li = new ArrayList<Integer>();
		
//		for (int i = 1; i < 50; i += 2)
//			li.add(i);
		
		for (int i = 1; i < 50; i += 2) {
			li.add(Integer.valueOf(i));
		}
		
		// Autoboxing - converts the primitive value into the wrapper class automagically
		Character ch = 'a';
	}

}
