package com.skillstorm.pojos;

import java.util.Objects;

public class Potato {
	// defaults for primitive types are:
	// What are the primitive
	// - byte - 0
	// - short - 0 
	// - char - 0
	// - int - 0
	// - long - 0l
	// - float - 0.0f
	// - double - 0.0
	// - boolean - false
	// - String - null
	// - objects - null
	
	private double size;
	private String color;
	
	// Constructor implicitly defined is the default
	// no-arg
	public Potato() {
		this.color = "red";
		this.size = 1;
	}
	
	
	public double getSize() {
		return this.size;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setSize(double size) {
		if (size <= 0)
//			size = 1;// default 
			throw new IllegalArgumentException("size cannot be 0 or negative");
		else
			this.size = size;
	}
	
	public void setColor(String color) {

		if(color == null){
			throw new IllegalArgumentException("color cannot be null");
		}
		if (color.isBlank()) {
			throw new IllegalArgumentException("color cannot be blank");
		}
		this.color = color;
	}
	
	@Override
	public String toString() {
		return String.format("%s potato weighs %.2f oz", this.color, this.size);
	}

	//
	@Override
	public int hashCode() {
		return Objects.hash(color, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Potato other = (Potato) obj;
		return Objects.equals(color, other.color)
				&& Double.doubleToLongBits(size) == Double.doubleToLongBits(other.size);
	}
	
	public static void main(String[] args) {
		Potato potato1 = new Potato();
//		System.out.println(potato1);
		try {
			potato1.setSize(0);
		} catch (IllegalArgumentException ebubbles) { // note e is a 
			System.out.println("Potato is still " + potato1.getSize() + " oz");
			System.out.println(ebubbles.getMessage());
		}
		try {
			Kitchen.cookPotatos(potato1);
		} catch (ImpossiblePotatoException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	

}

/**
 * @throws ImpossiblePotatoException 
 */
class Kitchen {
	
	public static void cookPotatos(Potato potato) throws ImpossiblePotatoException {
		System.out.println("Washing and trimming potato");
		try {
		potato.setSize(potato.getSize() - 1);
		} catch (IllegalArgumentException e) {
			throw new ImpossiblePotatoException("Potato trimming failed", e);
		}
		System.out.println();
	}
}
