package algos;

// String Matching:
// Brute Force Search - goes character by character comparing the
// match value with the string from that point, when it matches, it
// moves to the next character in the pattern and search string until
// it either matches the whole pattern or doesn't find a match
// Rabin-Karp - uses a hash function to find a value for the search
// pattern, then hashes that many characters of the search string
// and moves a character at a time hashing as it goes, until it either
// matches the hash or returns false

public class StringMatchingDemo {

	public static void main(String[] args) {
		String text = "TheQuickBrownFoxJumpsOverTheLazyDog";
		String pattern = "Quick";
		
		int resultFromBruteForce = bruteForceSearch(text, pattern);
		System.out.println("Brute Force Result: " 
					+ resultFromBruteForce);
		
		int resultFromRabinKarp = rabinKarpSearch(text, pattern);
		System.out.println("Rabin-Karp Result: " 
					+ resultFromRabinKarp);
	}
	
	public static int bruteForceSearch(String text, String pattern) {
		int tl = text.length();
		int pl = pattern.length();
		
		// Moving forward in our text
		for(int i = 0; i < tl - pl; i++) {
			int j;
			// Move the character we're checking in the pattern
			for(j = 0; j < pl; j++) {
				if(text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			// If J is equal to the length of the pattern
			// that means we found the whole pattern in our text
			if(j == pl) {
				// Match was found at i
				return i;
			}
		}
		
		return -1; // No match found
	}
	
	public static int rabinKarpSearch(String text, String pattern) {
		int textLength = text.length();
		int patternLength = pattern.length();
		
		int prime = 31; // Any prime number
		int hashText = 0;
		int hashPattern = 0;
		int h = 1;
		
		for (int i = 0; i < patternLength - 1; i++) {
			h = (h * 256) % prime;
		}
		
		// Calculate the hash value of the pattern and first window
		// of text
		for (int i = 0; i < patternLength; i++) {
			hashPattern = (256 * hashPattern 
					+ pattern.charAt(i)) % prime;
			hashText = (256 * hashText + text.charAt(i)) % prime;
		}
		
		// Move the pattern over the text one by one
		for(int i = 0; i <= textLength - patternLength; i++) {
			// Check the hash values of the current window of text
			// and the pattern
			if(hashPattern == hashText) {
				int j;
				for(j = 0; j < patternLength; j++) {
					if(text.charAt(i + j) != pattern.charAt(j)) {
						break;
					}
				}
				// If J is equal to the pattern length
				if(j == patternLength) {
					return i; // Found a match an i
				}
			}
			
			// Calculate the hash value for the next window of text
			// Remove the leading digit, add trailing digit
			if(i < textLength - patternLength) {
				hashText = (256 * (hashText - text.charAt(i) * h) 
						+ text.charAt(i + patternLength)) % prime;
				
				if(hashText < 0) {
					hashText = (hashText + prime);
				}
			}
		}
		return -1; // No match found
	}
}


