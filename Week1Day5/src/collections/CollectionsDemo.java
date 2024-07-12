package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

// What is a Collection? A group of objects housed in a type
// To perform operations or return a new collection (filtered or sorted)
public class CollectionsDemo {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();
		int stringListSize = stringList.size();
		if (stringList.isEmpty()) {
			// Do something if the list is empty
		}
		// .contains -> check for an item in the list
		// .add -> put a new item in our list
		// .remove -> remove an item from the list
		// Iterator -> allows for-each iteration of items in the list
		
		// Whole collection operations
		// .containsAll -> check if all elements in one collection are present in another
		// .addAll -> add all elements of one collection into another
		// .removeAll -> clears all elements in a collection from another
		// .clear -> clears all elements in a single collection
		// .retainAll -> remove all items from a target collection
		// that are not contained in a specified collection
		// .toArray -> returns an array of the elements for array operations
		
		// Traversing collections
		// 1. Aggregate operations
		// 2. For-each construct
		// 3. Iterators
		
		// Lambda expressions: functional programming construct in java
		// -> 
		stringList.stream() // convert the list into a stream
		.filter(e -> e.length() > 0) // only pass along items that have a length greater than 0
		.forEach(e -> System.out.println(e)); // for each item, print it out
		// Equivalent to ^
		for (String item : stringList) {
			if (item.length() > 0) {
				System.out.println(item);
			}
		}
		Employee empl1 = new Employee(50000, 3); 
		Employee empl2 = new Employee(55000, 2);
		Employee empl3 = new Employee(60000, 1);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(empl1);
		employees.add(empl2);
		employees.add(empl3);
		
		empl1.compareTo(empl3);
		
		int totalSalary = employees.stream()
				.collect(Collectors.summingInt(Employee::getSalary));
		
		System.out.println(totalSalary);
		
		// Iterator -> object that enables moving through a collection 
		// and potentially removing from the collection selectively
		
		for (Iterator<Employee> emp = employees.iterator(); emp.hasNext(); ) {
			if((emp.next()).getSalary() > 55000) {
				emp.remove();
			}
		}
		
		int[] numberArray = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10};
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; 
		System.out.println("First element: " + numberArray[0]);
		
		for (int i = 0; i < numberArray.length; i++) {
			System.out.println("Element at index " + i + ": " + numberArray[i]);
		}
		System.out.println(matrix[1][2]); //6
		
		ArrayList<String> newList = new ArrayList<>();
		newList.add("Hello World"); // Set the first item by index
		String firstElement = newList.get(0); // Get the first item by index
		newList.add("Seth");
		newList.remove(0);
		newList.remove("Seth");
		int newListLength = newList.size();
		for (String item : newList) {
			System.out.println(item);
		}
		
		List<String> linkedStrings = new LinkedList<>();
		
		Map<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("Maple", 1);
		treeMap.put("Cherry Blossom", 2);
		treeMap.put("Palm", 3);
		System.out.println("Tree Map " + treeMap);
		
		for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.println("TreeMap Entry: " + entry.getKey() + " = " + entry.getValue());
		}
		
		Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put(1, "google.com");
		linkedHashMap.put(2,  "skillstorm.com");
		linkedHashMap.put(3,  "microsoft.com");
		System.out.println("LinkedHashMap " + linkedHashMap);
		
		for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
			System.out.println("LinkedHashMap Entry: " + entry.getKey() + " = " + entry.getValue());
		}
		
		PriorityQueue<Integer> myPriorityNumberQueue = new PriorityQueue<>();
		myPriorityNumberQueue.add(5);
		myPriorityNumberQueue.add(3);
		myPriorityNumberQueue.add(1);
		myPriorityNumberQueue.add(15);
		myPriorityNumberQueue.add(11);
		myPriorityNumberQueue.add(105);
		System.out.println("PriorityQueue: " + myPriorityNumberQueue);
		
		System.out.println("Removed: " + myPriorityNumberQueue.remove());
		System.out.println("MyPriorityNumberQueue after removal: " + myPriorityNumberQueue);
		
		
		Deque<String> pokeDex = new ArrayDeque<>();
		pokeDex.addFirst("Bulbasaur");
		System.out.println("PokeDex " + pokeDex);
		pokeDex.addLast("Mew");
		System.out.println("PokeDex " + pokeDex);
		pokeDex.addFirst("Ivysaur");
		
		System.out.println("PokeDex " + pokeDex);
		System.out.println("Removed from front: " + pokeDex.removeFirst() );
		System.out.println("Removed from back: " + pokeDex.removeLast() );
		System.out.println("PokeDex after removals: " + pokeDex);
		
	}
	
//	 0 1 2 3 4 5 6 7 8 9
//	 _ _ _ _ _ _ _ _ _ _ 
//	| | | | | | | | | | |
//	---------------------
//	Arrays -> used to store more values than a single variable
//  Fixed size - determined at creation, inflexible
//	Performance - Constant time complexity when getting 
//	or setting an element an a specific index
//	Type-Safety - Arrays store one type of element, int[] only takes integers
//	Store primitives and objects
	
	// ArrayList -> java.util dynamic array implementation
	// Dynamic size -> adjusts to the amount of items stored if more are added
	// (default size 10, dynamically increases by 50%)
	// Easy manipulation -> list operations
	// Generic Type Safety
	// Can only store objects, no primitives
	
}


//interface Iterator<E> {
//	boolean hasNext(); // returns true if more elements to move through
//	E next(); // gets next element in the collection
//	void remove(); // removes the last element returned by next
//}

// Ordering = order items were added to a collection
// Sorting = elements are arranged according to a specified order

// Comparable -> has compareTo method to provide a natural order
// Comparator -> has compare method to provide a custom order

// List: ordered collection (sequence), items accessible by integer index, searchable
// ArrayList: resizable array implementation of the List interface
// LinkedList: Double-linked by default in java collection of nodes, each node
// containing the data and then a reference to the previous and next nodes,
// in java it implements both List and Deque, Head = 1st item, Tail = last item
// Single linked => has next()
// Double linked => has next() and prev()
// Circular linked => tail points to head

// Sets
// A collection without duplicate elements
// SortedSet: a set that maintains elements in ascending order
// TreeSet: implementation of the SortedSet, uses a red-black tree to store elements
// in a sorted order
// HashSet: implements the Set, uses a hash table to store elements, but doesn't guarantee
// a specific order of the elements

// Maps
// Uses KVP (Key Value Pairs), cannot contain duplicate keys
// TreeMap: implements the SortedMap interface, stores keys in Red black tree structure
// LinkedHashMap: implementation of Map interface with predictable iteration order, maintains
// a double-linked list through all of its entries, which also defines the iteration ordering


// Queue
// A collection that follows the FIFO (first in first out) principle
// LinkedList underneath that holds the items
// PriorityQueue:  Queue implementation that provides ordering based on priority of items


// Deque
// Double-ended queue, queue that supports insertion and removal at both ends
// ArrayDeque: resizable array with the Deque interface, faster than LinkedList when
// used as a deque

class Employee implements Comparable<Employee>, Comparator<Employee> {
	private int salary;
	private int id;
	
	public Employee(int id, int money) {
		this.id = id;
		this.salary = money;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public int getId() {
		return this.id;
	}

	@Override
	public int compareTo(Employee o) {
		return Integer.compare(this.id, o.getId());
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return Integer.compare(o1.salary, o2.salary);
	}
}
