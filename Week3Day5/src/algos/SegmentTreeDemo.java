package algos;

// Segment Tree: binary tree used for storing segments or intervals about an
// array. It allows you to query information about stored segments efficiently 

public class SegmentTreeDemo {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 11};
		SegmentTree st = new SegmentTree(arr);
		System.out.println("Sum of range (2, 5): " + st.sumRange(2, 5));
		st.update(3, 10);
		System.out.println("Sum of range (2, 5) after update: " + st.sumRange(2, 5));
	}
}

class SegmentTree {
	private int[] tree;
	private int length;
	
	public SegmentTree(int[] arr) {
		length = arr.length;
		this.tree = new int[length*2];
		buildTree(arr);
	}
	
	private void buildTree(int[] arr) {
		for(int i = 0; i < length; i++) {
			tree[length + i] = arr[i];
		}
		for(int i = length - 1; i > 0; --i) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
	}
	
	public void update(int index, int value) {
		index += length;
		tree[index] = value;
		while(index > 1) {
			index /= 2;
			tree[index] = tree[index * 2] + tree[index * 2 + 1];
		}
	}
	
	public int sumRange(int left, int right) {
		left += length;
		right += length;
		int sum = 0;
		while(left <= right) {
			if((left % 2) == 1) {
				sum += tree[left++];
			}
			if((right % 2) == 0) {
				sum += tree[right--];
			}
			left /= 2;
			right /= 2;
		}
		return sum;
	}
	
	
}
