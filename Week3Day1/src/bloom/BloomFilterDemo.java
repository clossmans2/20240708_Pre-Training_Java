package bloom;

import java.util.BitSet;
import java.util.function.Function;

// Bloom Filter: Data structure used to test whether an element is a member of a set
// False positive matches are possible, but false negatives are not.
// Cache filtering: prevents unnecessary network requests and reduces latency, check if
// webpage is in the cache before fetching from the server
// Call-detail record existence checking at Telecom companies
// Mobile number porting/routing for cell phones
// Database systems checking for existence of a record before running full query
// Networking - address assignment in IP Routing tables
// Spell check - determine whether a word exists in a dictionary or not
// Anti-spam/malware - checking against a blacklist of domains or a list
// of file signatures for existence
// Genomic Data Processing - represent and query large DNA sets with Bloom Filter

public class BloomFilterDemo {

	public static void main(String[] args) {
		int[] hashSeeds = {7, 11, 42, 31, 13, 37, 61};
		BloomFilter bloomFilter = new BloomFilter(1000, hashSeeds);
		
		bloomFilter.add("Honda Civic");
		bloomFilter.add("Toyota Camry");
		bloomFilter.add("Hyundai Sonata");
		bloomFilter.add("Ford Mustang");
		bloomFilter.add("Toyota Sienna");
		bloomFilter.add("Ford F-150");
		bloomFilter.add("BMW 335i");
		
		System.out.println("Bloom Filter: " + bloomFilter);
		System.out.println("Contains BMW 335i?: " 
							+ bloomFilter.mightContain("BMW 335i"));
		
		System.out.println("Contains Toyota Tundra?: " 
							+ bloomFilter.mightContain("Toyota Tundra"));
		

	}

}


class BloomFilter {
	private BitSet bitSet;
	private int bitSetSize;
	private int[] hashSeeds;
	private Function<String, Integer>[] hashFunctions;
	
	@SuppressWarnings("unchecked")
	public BloomFilter(int bitSetSize, int[] hashSeeds) {
		this.bitSetSize = bitSetSize;
		this.hashSeeds = hashSeeds;
		this.bitSet = new BitSet(bitSetSize);
		this.hashFunctions = new Function[hashSeeds.length];
		
		for (int i = 0; i < hashSeeds.length; i++) {
			final int seed = hashSeeds[i];
			hashFunctions[i] = (String key) -> {
				int hash = 0;
				for (char c : key.toCharArray()) {
					hash = seed * hash + c;
				}
				return (bitSetSize - 1) & hash;
			};
		}
	}
	
	public void add(String key) {
		for (Function<String, Integer> hashFunction : hashFunctions) {
			bitSet.set(hashFunction.apply(key));
		}
	}
	
	public boolean mightContain(String key) {
		for (Function<String, Integer> hashFunction : hashFunctions) {
			if (!bitSet.get(hashFunction.apply(key))) {
				return false;
			}
		}
		return true;
	}
}
















