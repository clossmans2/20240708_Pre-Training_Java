package com.skillstorm.pojos;

/*
 * Record classes, which are a special kind of class, help to model plain data
 * https://docs.oracle.com/en/java/javase/17/language/records.html
 */
public record AnimalRecord(String name, int numLegs) {
	
	/*
	 * Auto-generated methods:
	 * -
	 * -
	 * -
	 * -
	 * -
	 * 
	 * Can customize constructors and methods by defining them explicitly.
	 */
	
	
	// Compact constructor whose signature is implicit 
	//  (derived from the header components automatically)
	public AnimalRecord {
		if (name == null || name.isBlank())
			throw new IllegalArgumentException(
					String.format("Invalid name: \"%s\" cannot be null or blank", name));
		if (numLegs < 0)
			throw new IllegalArgumentException(
					String.format("Invalid numLegs: %d, cannot be negative", numLegs));
	}

}
