package hash;

import java.util.LinkedList;

// Hash Function: any function that takes an arbitrary length input
// and returns a fixed length output, should be able to take the same input
// and always return the same output, 
// 
// Collision: When a hash value is computed that matches a hash value
// already present in the data structure (hashmap/hashtable)
// 
// Two ways of handling collisions
// 1. Open Addressing - probing the hash table/map to find an empty slot
// 2. Chaining - each bucket contains a linked list instance of elements that hash to
// the same index, when a collision occurs the item is added to the list at that index

public class HashFunctionDemo {

	public static void main(String[] args) {
		String UpperSeth = "Seth";
		String lowerSeth = "Steh";
		int USHashValue = basicHashFunction(UpperSeth);
		int LSHashValue = basicHashFunction(lowerSeth);
		System.out.println("Hash value for " + UpperSeth + ": " + USHashValue);
		System.out.println("Hash value for " + lowerSeth + ": " + LSHashValue);
		
		HashMapOpenAddressing hashMap = new HashMapOpenAddressing();
		hashMap.put("Apple", 1);
		hashMap.put("Orange", 2);
		hashMap.put("Banana", 3);
		hashMap.put("Pear", 4);
		hashMap.put("Cherry", 5);
		hashMap.put("Lemon", 6);
		System.out.println("HashMap" + hashMap);
		System.out.println("Value for 'Apple': " + hashMap.get("Apple"));
		
		HashMapChaining hashMap2 = new HashMapChaining();
		hashMap2.put("Apple", 1);
		hashMap2.put("Orange", 2);
		hashMap2.put("Banana", 3);
		hashMap2.put("Pear", 4);
		hashMap2.put("Cherry", 5);
		hashMap2.put("Lemon", 6);
		System.out.println("HashMap" + hashMap2);
		System.out.println("Value for 'Apple': " + hashMap2.get("Apple"));
	}
	
	public static int basicHashFunction(String key) {
		int hash = 0;
		for(char c : key.toCharArray()) {
			hash = (hash * 31) + c;
			//hash += c;
		}
		return hash;
	}

}

class HashMapOpenAddressing {
	private static final int INITIAL_CAPACITY = 16;
	private static final double LOAD_FACTOR = 0.75;
	
	private CustomKeyValueEntry[] table;
	private int size;
	private int threshold;
	
	public HashMapOpenAddressing() {
		this.table = new CustomKeyValueEntry[INITIAL_CAPACITY];
		this.threshold = (int) (INITIAL_CAPACITY * LOAD_FACTOR);
	}
	
	private int hash(String key) {
		return (key.hashCode() & 0x7FFFFFFF) % table.length;
	}
	
	public void put(String key, Integer value) {
		if (size >= threshold) {
			resize();
		}
		
		int index = hash(key);
		
		while(table[index] != null) {
			if(table[index].getKey().equals(key)) {
				table[index].setValue(value);
			}
			index = (index + 1) % table.length;
		}
		table[index] = new CustomKeyValueEntry<String,Integer>(key, value);
		size++;
	}
	
	private void resize() {
		CustomKeyValueEntry<String,Integer>[] oldTable = table;
		table = new CustomKeyValueEntry[oldTable.length * 2];
		threshold = (int) (table.length * LOAD_FACTOR);
		size = 0;
		
		for (CustomKeyValueEntry<String,Integer> entry : oldTable) {
			if (entry != null) {
				put(entry.getKey(), entry.getValue());
			}
		}
	}
	
	public Integer get(String key) {
		int index = hash(key);
		while (table[index] != null) {
			if(table[index].getKey().equals(key)) {
				return (Integer) table[index].getValue();
			}
			index = (index + 1) % table.length;
		}		
		return null;
	}
}

class HashMapChaining {
	private static final int INITIAL_CAPACITY = 16;
	private LinkedList<CustomKeyValueEntry>[] table;
	
	public HashMapChaining() {
		table = new LinkedList[INITIAL_CAPACITY];
		for(int i = 0; i < INITIAL_CAPACITY; i++) {
			table[i] = new LinkedList<>();
		}
	}
	
	private int hash(String key) {
		return (key.hashCode() & 0x7FFFFFFF) % table.length;
	}
	
	public void put(String key, Integer value) {
		int index = hash(key);
		LinkedList<CustomKeyValueEntry> bucket = table[index];
		for (CustomKeyValueEntry<String, Integer> entry : bucket) {
			if (entry.getKey().equals(key)) {
				entry.setValue(value);
			}
		}
		bucket.add(new CustomKeyValueEntry<String, Integer>(key, value));
	}
	
	public Integer get(String key) {
		int index = hash(key);
		LinkedList<CustomKeyValueEntry> bucket = table[index];
		for (CustomKeyValueEntry<String, Integer> entry : bucket) {
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		return null;
	}
}





