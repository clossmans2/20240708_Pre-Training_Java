package com.skillstorm.pojos;

import java.io.Serializable;
import java.util.Objects;

public class AnimalClass implements Serializable {
	
	private static final long serialVersionUID = 7286233297380624546L;

	private String name;
	
	private int numLegs;
	
	public AnimalClass() {
		this.name = "dog";
		this.numLegs = 4;
	}
	
	public AnimalClass(String name, int numLegs) {
		if (name == null || name.isBlank())
			throw new IllegalArgumentException(
					String.format("Invalid name: \"%s\" cannot be null or blank", name));
		if (numLegs < 0)
			throw new IllegalArgumentException(
					String.format("Invalid numLegs: %d, cannot be negative", numLegs));
		
		this.name = name;
		this.numLegs = numLegs;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumLegs() {
		return this.numLegs;
	}
	
	public void setName(String name) {
		if (name == null || name.isBlank())
			throw new IllegalArgumentException(
					String.format("Invalid name: \"%s\" cannot be null or blank", name));
		this.name = name;
	}
	
	public void setNumLegs(int legs) {
		if (numLegs < 0)
			throw new IllegalArgumentException(
					String.format("Invalid numLegs: %d, cannot be negative", legs));
		this.numLegs = legs;
	}

	@Override
	public String toString() {
		return "AnimalClass [name=" + name + ", numLegs=" + numLegs + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, numLegs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnimalClass other = (AnimalClass) obj;
		return Objects.equals(name, other.name) && numLegs == other.numLegs;
	}
	

}
