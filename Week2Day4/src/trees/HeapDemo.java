package trees;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Heap: Tree based data structure that follows a specific order
// Binary heap: a node will only have at most 2 children and is ordered usually
// as a min or max heap
// Min heap: binary tree structure with the value of each node greater than or equal to
// the value of its parent, with the smallest/minimum value being the root element
// Max heap: binary tree structure with the value of each node lesser than or equal to
// the value of its parent, with the highest/maximum value element as the root element

public class HeapDemo {

	public static void main(String[] args) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2-i1;
			}
		});
		PriorityQueue<Integer> maxHeapTwo = new PriorityQueue<>((i1, i2) -> i2 - i1);
		maxHeap.add(14);
		maxHeap.add(1);
		maxHeap.add(2);
		maxHeap.add(3);
		maxHeap.add(4);
		maxHeap.add(5);
		maxHeap.add(0);
		maxHeap.add(11);
		System.out.println("Max element: " + maxHeap.peek()); // 14
		maxHeap.remove();
		System.out.println("Max element: " + maxHeap.peek()); // 11
		
		MinHeap minHeap = new MinHeap();
		minHeap.add(14);
		minHeap.add(1);
		minHeap.add(2);
		minHeap.add(3);
		minHeap.add(4);
		minHeap.add(5);
		minHeap.add(0);
		minHeap.add(11);
		System.out.println("Min element: " + minHeap.peek()); // 0
		minHeap.poll();
		System.out.println("Min element after poll: " + minHeap.peek()); // 1
		minHeap.printHeap();
	}

}

class MinHeap {
	// Create a variable to hold the array capacity
	private int capacity = 10;
	
	// Create a variable to hold the current size
	private int size = 0; 
	// We use an array to store the individual nodes
	int[] items = new int[capacity];
	
	// Helper method to automatically resize our backing
	// store (array) so we don't run out of room
	// (similar to the way an ArrayList resizes dynamically)
	private void makeRoom() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	// Helper Methods
	// Returns the index of the parent node given the index of its child
	// (Index of Child Node - 2) / 2;
	private int getParentIndex(int childIndex) {
		return (childIndex - 2) / 2;
	}

	// Returns the index of the left child node given the index of its parent
	// (Index of Parent Node x 2) + 1;
	private int getLeftChildIndex(int parentIndex) {
		return (parentIndex * 2) + 1;
	}

	// Returns the index of the right child node given the index of its parent
	// (Index of Parent Node x 2) + 2;
	private int getRightChildIndex(int parentIndex) {
		return (parentIndex * 2) + 2;
	}
	
	// Returns true if a node at the given index has a parent node
	// Essentially anything with an index greater than 0 should have a parent
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	// Returns true if a node at the given index has a left child node
	// The index of the child will always be lower than the size of the array
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	// Returns true if a node at the given index has a right child node
	// The index of the child will always be lower than the size of the array
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	
	// Returns the value of the left child node for a given parent node index
	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	// Returns the value of the right child node for a given parent node index	
	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	
	// Returns the value of the parent node for a given node index
	private int parent(int index) {
		return items[getParentIndex(index)];
	}
	
	// Method used to handle swapping the values of 2 nodes
	private void swap(int firstIndex, int secondIndex) {
		// Create a temporary variable to hold the first value
		int temp = items[firstIndex];
		// Set the first node value to the value of the second node
		items[firstIndex] = items[secondIndex];
		// Set the second node equal to the value we stored in the temp variable
		items[secondIndex] = temp;
	}
	
	// Method to show the minimum (first) item in the tree
	public int peek() throws IllegalStateException {
		// If there's no items, throw
		if (size == 0) {
			throw new IllegalStateException();
		}
		return items[0];
	}
	
	// Method to remove and return the minimum (first) item in the tree
	public int poll() {
		// If there's no items, throw
		if (size == 0) {
			throw new IllegalStateException();
		}
		// Get a reference to the first item so we can return it
		int item = items[0];
		// Grab a value from the end of the list and place it at the top
		items[0] = items[size - 1];
		// Decrease the size variable
		size--;
		// Fix the list moving from the value we just put at the top
		// Down the line until its back to the correct structure
		heapifyDownward();		
		// Return the value we stored earlier
		return item;
	}
	
	public void add(int item) {
		// Double check to make sure we have room before we try to add another item
		// If we don't have room, increase our capacity before adding
		makeRoom();
		// Use the variable tracking the total count of items in our array
		// to place a value in the next available slot
		items[size] = item;
		// Increment our item count tracking variable so that our
		// calls to makeRoom work as designed
		size++;
		// Fix the list from the bottom working our way up
		// until it's back in the partial order we need
		heapifyUpward();
	}
	
	// Fixes the list after an add and makes sure the smallest value
	// is at the top of the list
	public void heapifyUpward() {
		// Get a reference to the last item we inserted
		// Since it always gets added at the end,
		// We can just use our size - 1 to get the index
		int index = size - 1;
		// Start looping through the tree from the bottom moving upward
		// Until we reach the top of the tree 
		// and the (parent) item directly above our current item is greater
		// than our current item
		while(hasParent(index) && parent(index) > items[index]) {
			// Swap the smaller value with the larger value
			swap(getParentIndex(index), index);
			// Reset our index to follow the item we moved
			index = getParentIndex(index);
			// Continue the loop until we reach the root
		}
	}
	
	// Fixes the list after a removal and ensures the smallest
	// value is at the top of the list
	public void heapifyDownward() {
		// Start with a reference to our root node
		int index = 0;
		// As long as the node we're working on has a left child
		while (hasLeftChild(index)) {
			// Create a reference to that left node
			int smallerChildIndex = getLeftChildIndex(index);
			// If a right node exists
			// AND the right child node is smaller than the left child node
			if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
				// Change the smallerChildindex variable to the right child node
				smallerChildIndex = getRightChildIndex(index);
			}
			// Once the items below are larger than our current item
			// Break out of the loop, our work is finished
			if (items[index] < items[smallerChildIndex]) {
				break;
			} else {
				// Otherwise, swap the smaller value with the larger value
				swap(index, smallerChildIndex);
			}
			// Move our node reference to the smallest child and loop again
			index = smallerChildIndex;			
		}
	}
	
	// Helper method to print out all of the items in the heap.
	public void printHeap() {
		for (int i = 0; i < size; i++) {
			System.out.println(items[i] + " ");
		}
	}
}



