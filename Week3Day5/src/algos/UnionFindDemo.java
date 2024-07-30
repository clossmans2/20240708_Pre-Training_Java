package algos;

// Disjoint Set Union [DSU] (Union-Find): data structure that keeps track
// of a partition of a set into disjoint subsets and supports two operations:
// finding the set a particular element is in and uniting two sets. 

public class UnionFindDemo {
	private int[] parent;
	private int[] rank;
	
	public UnionFindDemo(int length) {
		// Initialized the parent array
		this.parent = new int[length];
		// Initialized the rank array
		this.rank = new int[length];
		// Set the parent array index to index
		// [0, 1, 2, 3, 4]
		// Set the rank array from the start to all 0s
		// [0, 0, 0, 0, 0]
		for(int i = 0; i < length; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}
	
	public static void main(String[] args) {
		UnionFindDemo ufd = new UnionFindDemo(5);
		ufd.union(0, 2);// [0, 1, 0, 3, 4] // [1, 0, 0, 0, 0]
		ufd.union(4, 2);// [0, 1, 0, 3, 0] // [1, 0, 0, 0, 0]
		ufd.union(3, 1);// [0, 3, 0, 3, 0] // [1, 0, 0, 1, 0]
		
		System.out.println("Find(4): " + ufd.find(4));
		System.out.println("Find(3): " + ufd.find(3));
		
		ufd.union(1, 2);// [3, 3, 0, 3, 0] // [1, 0, 0, 1, 0]
		System.out.println("Find(3) after union with 2: " + ufd.find(3));
	}
	
	public int find(int x) {
		// Use path compression to make the tree flat
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	public void union(int x, int y) {
		int rootX = find(x); //find(1) returns 3
		int rootY = find(y); //find(2) returns 0
		
		// Using a union by rank to keep the tree shallow
		if(rootX != rootY) {
			if(rank[rootX] > rank[rootY]) {
				parent[rootY] = rootX;
			} else if(rank[rootX] < rank[rootY]) {
				parent[rootX] = rootY;
			} else {
				parent[rootY] = rootX;
				rank[rootX]++;
			}
		}
	}

}





