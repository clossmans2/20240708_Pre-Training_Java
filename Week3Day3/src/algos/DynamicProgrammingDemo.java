package algos;

import java.util.ArrayList;

// Dynamic Programming: an optimization technique that solves complex problems by breaking
// them down into simpler subproblems and storing the results of the subproblems to
// avoid redundant computations

public class DynamicProgrammingDemo {

	public static void main(String[] args) {
		//System.out.println("The 65th number in the fib sequence is " + fibo3(40));
		//System.out.println("The 65th number in the fib sequence is " + fibo4(40));
		
		String seth = "sethclossman";
		String sethd = "sethdclossman";
		int l1 = seth.length();
		int l2 = sethd.length();
		int[][] lookup = findLCS(seth, sethd, l1, l2);
		diff(sethd, seth, l2, l1, lookup);
	}
	
	// O(2^n) [Exponential time complexity]
	public static long fibo1(int n) {
		if (n <= 1) {
			return n;
		}
		return fibo1(n - 1) + fibo1(n - 2);
	}
	
	// O(n) [Linear time complexity]
	public static long fibo2(int n) {
		ArrayList<Long> dp = new ArrayList<>(); // O(1)
		dp.add(0, (long) 0); // O(1)
		dp.add(1, (long) 1); // O(1)
		for (int i = 2; i <= n; i++) { // O(n)
			long newVal = dp.get(i - 1) + dp.get(i - 2); // O(1)
			dp.add(i, newVal); // O(1)
		}
		return dp.get(n); // O(1)
	}
	
	// O(n) [Linear time complexity]
	// Tabulation (bottom-up)
	public static long fibo3(int n) {
		long arr[] = new long[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n];
	}
	
	// Memoization (top-down)
	// TODO: Implement without recursion
	public static long fibo4(int n) {
		long[] lookup = new long[n + 1];
		for(int i = 0; i < n + 1; i++) {
			lookup[i] = -1;
		}
		if(lookup[n] == -1) {
			if (n <= 1) {
				lookup[n] = n;
			} else {
				lookup[n] = fibo4(n - 1) + fibo4(n - 2);
			}
		}
		return lookup[n];		
	}

	// Method to show the differences between 2 strings
	// 2 strings (A, B)
	// Character in A that's not in B: -
	// Character in B that's not in A: +
	// Character is the same, we print the character
	public static void diff(String A, String B, int m, int n, int[][] lookup) {
		// If the characters at the given point match
		// Return the characters
		if(m > 0 && n > 0 && A.charAt(m - 1) == B.charAt(n - 1)) {
			diff(A, B, m - 1, n - 1, lookup);
			System.out.print(" " + A.charAt(m - 1));
		// If the character exists in B but not in A,
		// Return the character with a +
		} else if (n > 0 && (m == 0 || lookup[m][n - 1] >= lookup[m - 1][n])) {
			diff(A, B, m, n - 1, lookup);
			System.out.print(" +" + B.charAt(n - 1));
		// If the character exists in A, but not in B,
		// Return the character with a -
		} else if (m > 0 && (n == 0 || lookup[m][n - 1] < lookup[m - 1][n])) {
			diff(A, B, m - 1, n, lookup);
			System.out.print(" -" + A.charAt(m - 1));
		}
	}
	
	public static int[][] findLCS(String A, String B, int m, int n) {
		int[][] lookup = new int[A.length() + 1][B.length() + 1];
		// First column = 0
		for(int i = 0; i < m; i++) {
			lookup[i][0] = 0;
		}
		
		// First row = 0
		for(int j = 0; j < n; j++) {
			lookup[0][j] = 0;
		}
		// Fill up the lookup table
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <=n; j++) {
				// If the current character in A matches the B character
				if(A.charAt(i - 1) == B.charAt(j - 1)) {
					lookup[i][j] = lookup[i - 1][j - 1] + 1;
				} else {
					// Otherwise if they don't match
					lookup[i][j] = Integer.max(lookup[i - 1][j], lookup[i][j - 1]);
				}				
			}
		}
		return lookup;
	}
}









