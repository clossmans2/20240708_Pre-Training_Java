package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
// HashMap: data structure that stores Key-Value pair (KVP)
// and uses a hash function to compute an index into an array of
// buckets or slots, from which the desired value can be found
// Not thread safe (not synchronized)
// Would technically allow a single null key, and many null values
// Subclass of AbstractMap

public class HashMapDemo {

	public static void main(String[] args) {
		CustomHashMap<String, Integer> map = new CustomHashMap<String, Integer>();
		map.put("Apple", 1);
		map.put("Orange", 2);
		map.put("Banana", 3);
		map.put("Pear", 4);
		map.put("Cherry", 5);
		map.put("Lemon", 6);
		
		System.out.println("HashMap" + map);
		System.out.println("Value for 'Apple': " + map.get("Apple"));
		System.out.println("Contains key for 'Banana'? " + map.containsKey("Banana"));
		//System.out.println("Contains value 5? " + map.containsValue(5));
		
		System.out.println("Contains value for 4 (Pear)? " + map.containsValue(4));
		map.remove("Pear");
		System.out.println("HashMap after removing Pear:");
		System.out.println(map);
		System.out.println("Contains value for 4 (Pear)? " + map.containsValue(4));
	}
}

class CustomKeyValueEntry<K, V> {
	private K key;
	private V value;
	
	public CustomKeyValueEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return this.key;
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	
	public V getValue() {
		return this.value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}

	@Override
	public String toString() {
		return "CKVEntry [" + (key != null ? "key=" + key + ", " : "")
				+ (value != null ? "value=" + value : "") + "]";
	}
	
	
}

class CustomBucket {
	private List<CustomKeyValueEntry> entries;
	
	public CustomBucket() {
		if(entries == null) {
			entries = new LinkedList<>();
		}
	}
	
	// Get all of the entries
	public List<CustomKeyValueEntry> getEntries() {
		return entries;
	}
	
	// Add entries to the list
	public void addEntry(CustomKeyValueEntry entry) {
		this.entries.add(entry);
	}
	
	// Remove entries from the list
	public void removeEntry(CustomKeyValueEntry entry) {
		this.entries.remove(entry);
	}

	@Override
	public String toString() {
		return "CBucket [ " 
				+ (entries != null ? "entries=" 
						+ entries : "") 
						+ " ]";
	}
	
	
}

class CustomHashMap<K, V> {
	// An instance of our bucket to store the entries
	private int capacity = 10;
	private CustomBucket[] bucket;
	private int size = 0;
	
	// Default Constructor
	public CustomHashMap() {
		this.bucket = new CustomBucket[capacity];
	}
	
	private int getHash(K key) {
		return (key.hashCode() & 0xfffffff) % capacity;
	}
	
	private CustomKeyValueEntry getEntry(K key) {
		int hash = getHash(key);
		for (int i = 0; i < bucket[hash].getEntries().size(); i++) {
			CustomKeyValueEntry kvEntry = bucket[hash].getEntries().get(i);
			if (kvEntry.getKey().equals(key)) {
				return kvEntry;
			}
		}
		return null;
	}
	
	// Method to get an entry value using a key
	public V get(K key) {
		if (containsKey(key)) {
			return (V) getEntry(key).getValue();
		} else {
			return null;
		}
	}
	
	// Method to put new entries in with a key and value
	public void put(K key, V value) {
		if (containsKey(key)) {
			CustomKeyValueEntry entry = getEntry(key);
			entry.setValue(value);
		} else {
			int hash = getHash(key);
			if(bucket[hash] == null) {
				bucket[hash] = new CustomBucket();
			}
			bucket[hash].addEntry(new CustomKeyValueEntry<K,V>(key, value));
			size++;
		}
	}
	
	// Method to check for existence of a key
	public boolean containsKey(K key) {
		int hash = getHash(key);
		return !(Objects.isNull(bucket[hash]) || Objects.isNull(getEntry(key)));
	}
	
	// Method to check for existence of a value (Optional)
	// Homework (Optional)
	public boolean containsValue(V value) {
		boolean retVal = false;
		for (CustomBucket buck : bucket) {
			if (buck != null) {
				for (CustomKeyValueEntry<K, V> entry : buck.getEntries()) {
					if (entry.getValue().equals(value)) {
						retVal = true;
					}
				}
			}
		}
		return retVal;
	}
	
	// Method to remove an entry using the key
	public void remove(K key) {
		if (containsKey(key)) {
			int hash = getHash(key);
			bucket[hash].removeEntry(getEntry(key));
			size--;
		}
	}
	
	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		return "CustomHashMap [" 
				+ (bucket != null ? "bucket=" 
				+ Arrays.toString(bucket) : "") 
				+ "]";
	}
	
	
}










