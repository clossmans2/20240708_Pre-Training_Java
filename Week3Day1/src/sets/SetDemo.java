package sets;

import java.util.EnumSet;
import java.util.HashSet;
// Set: a data structure/collection of distinct elements
// (that contains only unique values/does not allow duplicate elements)
// Good for storing unique elements, efficient at adding, removing and checking for existence
// Normal implementations: HashSet, TreeSet, LinkedHashSet
// Special implementations: EnumSet, CopyOnWriteArraySet
// EnumSet: turns an existing enum into a Set
// CopyOnWriteArraySet: uses a copy-on-write array as the backing store, 
// all mutative operations return a new copy of the array, thread safe, slower
public class SetDemo {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("Monday");
		set.add("Tuesday");
		set.add("Wednesday");
		set.add("Friday Jr.");
		set.add("Friday");
		set.add("Saturday");
		set.add("Saturday"); // ignored
		set.add("Saturday"); // ignored
		set.add("Saturday"); // ignored
		
		EnumSet.of(Day.MONDAY, Day.FRIDAY, Day.SATURDAY);
		
		System.out.println("Set: " + set);
		System.out.println("Contains 'Friday': " + set.contains("Friday"));
		
		set.remove("Friday Jr.");
		set.add("Thursday");
		System.out.println("Set: " + set);
	}

}

enum Day {
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY
}
