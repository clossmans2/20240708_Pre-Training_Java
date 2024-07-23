package trees;

import java.util.ArrayList;

// Tree: A hierarchical data structure, made up of nodes,
// the base node is referred to as the root node,
// each node can have 0, 1 or many child nodes,
// nodes that don't have children are referred to as leaves

// BinaryTree: (see Tree above) A Tree structure but 
// with each child node having at most 2 children (left, right).
// Not required to be ordered

// Binary Search Tree: Binary Tree with nodes arranged in a specific order
// The left node has a value less than it's parent
// The right node always contains a value greater than it's parent
// Left subtrees are always less than the root, right subtrees always greater than root
// If left and/or right nodes exist, they must also be a binary search tree
// and follow the same rules
// No duplicate values are allowed

//Time Complexity
// Binary Search Trees:
//	- Access: Average: O(log(n)) Worst: O(n) 
//	- Search: Average: O(log(n)) Worst: O(n) 
//	- Insert: Average: O(log(n)) Worst: O(n) 
//	- Delete: Average: O(log(n)) Worst: O(n) 
//Space Complexity O(n)

public class TreeDemo {

	public static void main(String[] args) {
		Tree oakTree = new Tree();
		oakTree.add(6);
		oakTree.add(7);
		oakTree.add(8);
		oakTree.add(9);
		oakTree.add(10);
		oakTree.add(1);
		oakTree.add(3);
		oakTree.add(5);
		oakTree.add(4);
		oakTree.add(2);
		oakTree.traverse(oakTree.root);	
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(6);
		bst.add(7);
		bst.add(8);
		bst.add(9);
		bst.add(10);
		bst.add(1);
		bst.add(3);
		bst.add(5);
		bst.add(4);
		bst.add(2);
		System.out.println(bst.contains(4)); // True
		System.out.println(bst.contains(14)); // False
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
}










