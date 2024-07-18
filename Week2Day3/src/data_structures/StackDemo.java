package data_structures;

// Stack: linear data structure that follows the LIFO/FILO 
// (Last in/First Out, or First in, Last out)
// Elements are added or removed from the top
import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		// Adding items to the stack using push
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		System.out.println("Stack: " + stack);
		// Remove an element with pop()
		System.out.println("Element popped: " + stack.pop());
		// Stack after the popping has occurred
		System.out.println("Stack after popping: " + stack);
		// View the next element at the top of the stack
		// Without removing the element
		System.out.println("Top Element: " + stack.peek());
	}

}

