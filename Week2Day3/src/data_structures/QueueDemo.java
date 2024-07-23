package data_structures;

import java.util.Queue;
import java.util.LinkedList;
// Queue: linear data structure that follows the FIFO 
// (First in, First out)
// Elements are added to the rear and removed from the front
//Time Complexity
//Queue:
//	- Access: O(n)
//	- Search: O(n)
//	- Insert: O(1)
//	- Delete: O(1)
//Space Complexity O(n)

public class QueueDemo {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		queue.add(7);
		
		System.out.println("Queue: " + queue);
		// Remove an element with remove()
		System.out.println("Element removed: " + queue.remove());
		// Queue after the popping has occurred
		System.out.println("Queue after removing: " + queue);
		// View the next element at the front of the queue
		// Without removing the element
		System.out.println("Front Element: " + queue.peek());
		
	}

}
