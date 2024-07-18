package data_structures;

import java.util.NoSuchElementException;

// LinkedList: linear data structure made up of nodes that contain data and reference to
// the next node in the sequence, non-contiguous, final node next = null
// Java default implementation is a Doubly-LinkedList
// Single Linked -> Reference to the next node
// Double Linked -> Reference to next and previous nodes
// Circular Linked -> Tail points to the head of the list

public class LinkedListDemo {

	public static void main(String[] args) {

	}
}

class LinkNode {
	private int data;
	public LinkNode next;
	
	public LinkNode(int data) {
		this.data = data;
		this.next = null;
	}
	
	public int getData() {
		return this.data;
	}
}

class LinkedList {
	public LinkNode head;
	
	public LinkedList() {
		this.head = null;
	}
	
	public void add(int value) {
		LinkNode newNode = new LinkNode(value);
		// Would only be true right after creating the list before adding anything
		if (this.head == null) {
			this.head = newNode;
		} else {
			// Get a reference to the head
			LinkNode current = head;
			// Move through the list setting the current node equal
			// to the next node until we find the last node in the list
			// that has next = null
			while(current.next != null) {
				current = current.next;
			}
			// Set the next for the last node = newNode
			current.next = newNode;
		}
	}
	
	public boolean contains(int value) {
		// Get a reference to the head
		LinkNode current = this.head;
		
		// While we loop through as long as the current node isn't null
		while(current != null) {
			// If the data in the current node matches the value to check
			if (current.getData() == value) {
				// Return true
				return true;
			}
			// Otherwise update the reference to move to the next node
			current = current.next;
		}
		// If nothing is found, return false
		return false;
	}

	public boolean remove(int value) {
		// Figure out if the list is empty
		if (head == null) {
			// The list is empty, we can stop
			return false;
		}
		// If the first node in the list is the one we want
		if (head.getData() == value) {
			// If the head node is the only node in the list
			if (head.next == null) {
			// Just remove the head reference
				this.head = null;
			} else {
				// Change the reference from the head to the next node after the head
				this.head = head.next;
			}
			return true;
		}
		// Get the reference to head node to start iteration
		LinkNode current = this.head;
		// As long as we aren't at the last node
		// AND the next node value doesn't match what we're searching for
		while (current.next != null && current.next.getData() != value) {
			// Update the reference and continue moving forward
			current = current.next;
		}
		// If we're not on the last node
		// And the loop has exited because the next node has the value
		// we've been searching for
		if (current.next != null) {
			// Update the reference that was pointing to the node with the matching value
			// to be a reference to the node after that next node
			current.next = current.next.next;
			return true;
		}
		// We didn't find the value, return false
		return false;
	}

	// Find and return the middle element
	public int getMiddleElementValue() throws NoSuchElementException {
		// If the list is empty, throw an exception
		if (head == null) {
			throw new NoSuchElementException();
		}
		// If there's only one element in the list
		// return the element
		if (head.next == null) {
			return this.head.getData();
		}
		// If there's only 2 elements in the list
		// Just send the first one back again
		if (head.next.next == null) {
			return this.head.getData();
		}
		
		// If there's 3 or more elements
		// We'll need to get the length
		// Start with a reference to the head
		// And a counter to track the length
		LinkNode current = this.head;
		int length = 1;
		// Loop through the list until last node
		while (current.next != null) {
			// Increment our length
			length++;
			// Move to the next node
			current = current.next;
		}
		// If it is an even number
		if (length % 2 == 0) {
			// Add one to the length
			length++;
		}
		// Now our length is odd
		// Divide by 2 and round up
		int center = Math.round(length / 2);
		
		current = this.head;
		// Get the center value
		// Starting at the first node, use 1 instead of 0
		for(int i = 1; i < center; i++) {
			// As long as we are moving through
			// Set the reference to the next node
			current = current.next;
		}
		// We've reached the center
		// Return the value
		return current.getData();
	}

	// Two pointer method for traversing a linkedlist
	public int getMiddleValueFast() {
		// Step 1: create 2 references to the head node
		// 1 will be our fast pointer
		// 1 will be our slow pointer
		LinkNode fastRef = head;
		LinkNode slowRef = head;
		
		// Keep moving through the list until the fast reference hits the end
		// At that point the slow reference should be in the middle of the list
		while (fastRef.next != null && fastRef.next.next != null) {
			// Each iteration
			// Fast reference advances by 2
			fastRef = fastRef.next.next;
			// Slow reference advances by 1
			slowRef = slowRef.next;
		}
		// Return the value that the slow pointer landed on
		return slowRef.getData();
	}
}

class DoubleLinkNode {
	private int data;
	public DoubleLinkNode next;
	public DoubleLinkNode prev;
	
	public DoubleLinkNode(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public int getData() {
		return this.data;
	}
}

class DoubleLinkedList {
	public DoubleLinkNode head;
	public DoubleLinkNode tail;
	
	public DoubleLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	// Adds to the beginning of the list
	public void add(int value) {
		DoubleLinkNode newNode = new DoubleLinkNode(value);
		// Would only be true right after creating the list before adding anything
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			DoubleLinkNode headToShift = this.head;
			this.head = newNode;
			this.head.next = headToShift;
		}
	}
	
	// Adds to the end of the list
	public void append(int value) {
		DoubleLinkNode newNode = new DoubleLinkNode(value);
		// Would only be true right after creating the list before adding anything
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			// Get a reference to the head
			DoubleLinkNode current = head;
			// Move through the list setting the current node equal
			// to the next node until we find the last node in the list
			// that has next = null
			while(current.next != null) {
				current = current.next;
			}
			// Set the next for the last node = newNode
			current.next = newNode;
			// Set the tail to point to the newNode
			this.tail = newNode;
			// Make sure our previous reference points to the current node
			newNode.prev = current;
		}
	}
	
	public boolean contains(int value) {
		// Get a reference to the head
		DoubleLinkNode current = this.head;
		
		// While we loop through as long as the current node isn't null
		while(current != null) {
			// If the data in the current node matches the value to check
			if (current.getData() == value) {
				// Return true
				return true;
			}
			// Otherwise update the reference to move to the next node
			current = current.next;
		}
		// If nothing is found, return false
		return false;
	}

	public boolean remove(int value) {
		// Figure out if the list is empty
		if (head == null) {
			// The list is empty, we can stop
			return false;
		}
		// If the first node in the list is the one we want
		if (head.getData() == value) {
			// If the head node is the only node in the list
			if (head.next == null) {
			// Just remove the head reference
				this.head = null;
			} else {
				// Change the reference from the head to the next node after the head
				this.head = head.next;
				this.head.prev = null;
			}
			return true;
		}
		// Get the reference to head node to start iteration
		DoubleLinkNode current = this.head;
		// As long as we aren't at the last node
		// AND the next node value doesn't match what we're searching for
		while (current.next != null && current.next.getData() != value) {
			// Update the reference and continue moving forward
			current = current.next;
		}
		// If we're not on the last node
		// And the loop has exited because the next node has the value
		// we've been searching for
		if (current.next != null) {
			// Update the reference that was pointing to the node with the matching value
			// to be a reference to the node after that next node
			current.next = current.next.next;
			// Update the reference from the new next node to point toward our current node
			current.next.prev = current;
			return true;
		}
		// We didn't find the value, return false
		return false;
	}

	// Find and return the middle element
	public int getMiddleElementValue() throws NoSuchElementException {
		// If the list is empty, throw an exception
		if (head == null) {
			throw new NoSuchElementException();
		}
		// If there's only one element in the list
		// return the element
		if (head.next == null) {
			return this.head.getData();
		}
		// If there's only 2 elements in the list
		// Just send the first one back again
		if (head.next.next == null) {
			return this.head.getData();
		}
		
		// If there's 3 or more elements
		// We'll need to get the length
		// Start with a reference to the head
		// And a counter to track the length
		DoubleLinkNode current = this.head;
		int length = 1;
		// Loop through the list until last node
		while (current.next != null) {
			// Increment our length
			length++;
			// Move to the next node
			current = current.next;
		}
		// If it is an even number
		if (length % 2 == 0) {
			// Add one to the length
			length++;
		}
		// Now our length is odd
		// Divide by 2 and round up
		int center = Math.round(length / 2);
		
		current = this.head;
		// Get the center value
		// Starting at the first node, use 1 instead of 0
		for(int i = 1; i < center; i++) {
			// As long as we are moving through
			// Set the reference to the next node
			current = current.next;
		}
		// We've reached the center
		// Return the value
		return current.getData();
	}

	// Two pointer method for traversing a double linkedlist
	public int getMiddleValueFast() {
		// Step 1: create 2 references
		// 1 will be our head pointer
		// 1 will be our tail pointer
		DoubleLinkNode headRef = head;
		DoubleLinkNode tailRef = tail;
		
		// Start at each end of the list
		// Move toward the center 1 step at a time
		// Checking for equality, when they meet
		// Return the value they both landed on
		while (headRef.next != null 
				&& tailRef.prev != null
				&& tailRef.getData() != headRef.getData()) {
			// Each iteration
			// Move the headRef ahead by 1
			headRef = headRef.next;
			if(headRef.getData() == tailRef.getData()) {
				return headRef.getData();
			} else {
				tailRef = tailRef.prev;
			}
		}
		// Return the value that the either pointer landed on
		return tailRef.getData();
	}
}

class CircularNode {
	private int data;
	public CircularNode next;
	
	public CircularNode(int data) {
		this.data = data;
		this.next = null;
	}
	
	public int getData() {
		return this.data;
	}
}

class CircularLinkedList {
	public CircularNode head;
	
	public void add(int data) {
		CircularNode newNode = new CircularNode(data);
		if (this.head == null) {
			head = newNode;
			head.next = newNode;
		} else {
			CircularNode current = head;
			while(current.next != head) {
				current = current.next;
			}
			current.next = newNode;
			newNode.next = head;
		}
	}
	
	public boolean remove(int value) {
		CircularNode current = head;
		CircularNode prevNode = head;
		if (current.getData() == value) {
			// Loop through the list until we reach
			// the last node (current.next == this.head)
			while(current.next != this.head) {
				current = current.next;
			}
			// Use current as a reference to the final node
			// De-refence head node (this.head = current.next.next)
			this.head = current.next.next;
			// Set the last node to point towards the head (current.next = this.head)
			current.next = this.head;
			return true;
		} else {
			// Loop through the list checking each value as we go
			// Use head reference to know when to stop current.next == this.head
			while(current.next != this.head && current.getData() != value) {
				prevNode = current;
				current = current.next;
			}
			// Either we've reached the end of the list
			// Or we found our value
			if (current.getData() == value) {
				// Make the previous node point to the node after the current
				prevNode.next = current.next;
				// Make sure the current node.next points to null
				current.next = null;
				// Return true because we found the value
				// And have removed it from the list
				return true;
			}
		}		
		return false;
	}
}



