package hash;

import java.util.Hashtable;
// HashTable: a data structure that implements an associative array, maps key to values
// uses hash function to compute an index into an array of buckets or slots
// Thread safe (synchronized)
// No keys or values can be null
// Subclass of Dictionary
//Time Complexity
//Hash Table:
//	- Search: Average: O(1) Worst: O(n) 
//	- Insert: Average: O(1) Worst: O(n) 
//	- Delete: Average: O(1) Worst: O(n) 
//Space Complexity O(n)

public class HashTableDemo {

	public static void main(String[] args) {
		Hashtable<String, Integer> pokeDex = new Hashtable<String, Integer>();
		pokeDex.put("Reshiram", 643);
		pokeDex.put("Charmander", 4);
		pokeDex.put("Vulpix", 37);
		pokeDex.put("Pikachu", 26);
		pokeDex.put("Sigilyph", 561);
		pokeDex.put("Ceruledge", 937);
		pokeDex.put("Dragonite", 149);
		pokeDex.put("Squirtle", 7);
		
		System.out.println("Pokedex: ");
		System.out.println(pokeDex);
		System.out.println("What number is Sigilyph? " + pokeDex.get("Sigilyph"));
		System.out.println("Is Mew in our Pokedex already? " + pokeDex.containsKey("Mew"));
		System.out.println("Do we have 007 in our Pokedex? " + pokeDex.containsValue(7));
		
		pokeDex.remove("Charmander");
		System.out.println("Pokedex after Team Rocket attack: ");
		System.out.println(pokeDex);
	}

}
