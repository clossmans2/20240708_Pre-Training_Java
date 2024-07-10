package utils;
//MEMORY IN JAVA
//Stack vs Heap
//Stack stores primitive data types (int, short, long, bytes, float, doubles, char)
//Stack stores variables, results inside of methods, object references
// Stack is basically emptied at the end of context
// Heap stores Objects, has GC to take care of managing memory


public class MemoryDemo {
	public static void main(String[] args) {
		int x = 10; //stored in stack
		SethList<Integer> wrappedInteger = new SethList<Integer>(); // object reference in stack, actual object in heap
		Integer myInt = 42; // object reference in stack, actual object in heap
		wrappedInteger.setData(myInt);
	}
}
