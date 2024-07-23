package tables;

// Sparse Tables: data structure used for efficiently querying static range minimum queries
// Useful when the array doesn't change often and only queries are performed

public class SparseTablesDemo {

	public static void main(String[] args) {
		int[] array = { 1, 3, -1, 8, 5, 6, -2, 3 };
		SparseTable st = new SparseTable(array);
		
		System.out.println("Minimum in range [0, 3]: " + st.query(0, 3)); // -1
		System.out.println("Minimum in range [4, 7]: " + st.query(4, 7)); // -2
	}

}


class SparseTable {
	private int[][] table;
	private int[] log;
	
	public SparseTable(int[] array) {
		int n = array.length;
		int k = (int)(Math.log(n) / Math.log(2)) + 1;
		table = new int[n][k];
		log = new int[n + 1];
		
		for (int i = 2; i <= n; i++) { 
			log[i] = log[i / 2] + 1;
		}
		
		for (int i = 0; i < n; i++) {
			table[i][0] = array[i];
		}
		
		for (int j = 1; j < log[n]; j++) {
			for (int i = 0; i + (1 << j) <= n; i++) {
				table[i][j] = 
						Math.min(
								table[i][j - 1],
								table[i + (1 << (j - 1))][j - 1]);
			}
		}
	}
	
	public int query(int l, int r) {
		int j = log[r - l + 1];
		return Math.min(table[l][j], table[r - (1 << j) + 1][j]);
	}
}









