package algos;

import java.util.stream.IntStream;

// Binary Search: a search algorithm that finds the position of a target value within
// a sorted array. It compares the target value to the middle element and narrows the
// search interval by half each time.
// (Divide & Conquer paradigm)
// Real world use cases:
// Look up a word in a dictionary or encyclopedia
// Look up someone in a phone book
// Looking up IP Addresses (firewall rules, router firmware, depending if storage is sorted)
// Debugging (binary search used to find the spot where a bug exists, narrowing the search
// window from project to module to file to class to method to block to line in stack trace)

public class BinarySearchDemo {

	public static void main(String[] args) {
		int[] guessingRange = IntStream.rangeClosed(1, 100).toArray();
		int target = 27;
		int result = search(guessingRange, target);
		if(result == -1) {
			System.out.println("The element was not present in the range");
		} else {
			System.out.println("The element was found at index: " + result);
			System.out.println("The element was: " + guessingRange[result]);
		}
	}
	
	// Time complexity
	// Binary search
	// Best Case - O(1)
	// Worst/Avg - O(log(n))
	// Space Complexity
	// O(1)
	public static int search(int[] arr, int target) { //1-100, 27
		int left = 0;
		int right = arr.length - 1; // 99
		int guessCounter = 0;
		while (left <= right) {
			guessCounter++;
			int mid = left + (right - left) / 2; // 50
			print("Guess #"+ guessCounter + ": " + arr[mid]);
			if(arr[mid] == target) {
				print("The mid point is the target value.");
				return mid;
			}
			if(arr[mid] < target) {
				print("The target value is greater than " + arr[mid]);
				print("Resetting the left value to " + (arr[mid] + 1));
				left = mid + 1;
			} else {
				print("The target value is less than " + arr[mid]);
				print("Resetting the right value to " + (arr[mid] - 1));
				right = mid - 1;
			}
		}
		print("Value does not exist inside the array.");
		return -1;
	}
	
	private static void print(String msg) {
		System.out.println(msg);
	}
}


class TreeNode {
	private int data;
	
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public int getData() {
		return this.data;
	}
}

class Tree {
	public TreeNode root;
	
	public void add(int data) {
		root = addRecursive(root, data);
	}
	
	public TreeNode addRecursive(TreeNode current, int data) {
		if (current == null) {
			return new TreeNode(data);
		}
		if (data < current.getData()) {
			current.left = addRecursive(current.left, data);
		} else if (data > current.getData()) {
			current.right = addRecursive(current.right, data);
		}
		return current;
	}
	
	public void traverse(TreeNode node) {
		if (node != null) {
			traverse(node.left);
			System.out.println(node.getData() + " ");
			traverse(node.right);
		}
	}
}

class BinarySearchTree extends Tree {
	
	public boolean contains(int data) {
		return containsRecursive(root, data);
	}
	
	public boolean containsRecursive(TreeNode current, int data) {
		if (current == null) {
			return false;
		}
		if (data == current.getData()) {
			return true;
		}
		
		return data < current.getData()
				? containsRecursive(current.left, data)
				: containsRecursive(current.right, data);
	}
	
	public boolean containsIterative(int data) {
		
		return false;
	}
}