package maps;


import java.util.HashMap;
import java.util.Map;
// Map: a data strucure/collection key-value pairs, each key is unique
// (Can allow for duplicate values so long as the keys are not duplicated)


public class MapDemo {

	public static void main(String[] args) {
		Map<String, Integer> interstates = new HashMap<>();
		interstates.put("Florida", 95);
		interstates.put("Michigan", 75);
		interstates.put("Alabama", 85);
		interstates.put("Virginia", 85);
		interstates.put("Maine", 95);
		
		
		System.out.println("Interstate Map: " + interstates);
		System.out.println("Value for Alabama: " + interstates.get("Alabama"));
		interstates.remove("Florida");
		System.out.println("Interstate Map: " + interstates);
		interstates.put("Florida", 75);
		System.out.println("Interstate Map: " + interstates);
	}

}
