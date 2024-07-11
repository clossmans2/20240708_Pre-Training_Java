package com.skillstorm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GCsvExamples {

	public static void main(String[] args) throws IOException {


		// Example 1: Converting to CSV style string
		Cereal cocoPuffs = new Cereal(
				"Coco Puffs", // name
				220, // calories
				4, // fat
				26, // carbs
				4, // fiber
				26, // sugar
				5, // protein
				255, // sodium
				50, // potasium
				10); // iron
		System.out.println(cocoPuffs);
		System.out.println(cocoPuffs.csvformat());

		// Example 2: Saving data to a CSV file
		

		// Example 3: Reading from a CSV file
		List<Cereal> cereals = readData();
	}

	public static List<Cereal> readData() throws IOException {
		// Read from a CSV file and create objects by parsing the comma-separated values
		List<Cereal> cereals = new ArrayList<>(200);
		try (BufferedReader reader = new BufferedReader(new FileReader("resources/cereals.csv"))) {
			// TODO Code here

		}
		return cereals;
	}

	public static void saveData() {
		// TODO Code here

	}
}

/**
 * Model class for a Cereal's name and nutrition facts.
 */
class Cereal {

	private String name;
	private int calories;
	private double fat;
	private double carbs;
	private double fiber;
	private double sugar;
	private double protein;
	private double sodium;
	private int potasium; // need to check for n/a in csv file
	private double iron;

	public Cereal() {
	}

	public Cereal(String name, int calories, double fat, double carbs, double fiber, double sugar, double protein,
			double sodium, int potasium, double iron) {
		this.name = name;
		this.calories = calories;
		this.fat = fat;
		this.carbs = carbs;
		this.fiber = fiber;
		this.sugar = sugar;
		this.protein = protein;
		this.sodium = sodium;
		this.potasium = potasium;
		this.iron = iron;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getCarbs() {
		return carbs;
	}

	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

	public double getFiber() {
		return fiber;
	}

	public void setFiber(double fiber) {
		this.fiber = fiber;
	}

	public double getSugar() {
		return sugar;
	}

	public void setSugar(double sugar) {
		this.sugar = sugar;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getSodium() {
		return sodium;
	}

	public void setSodium(double sodium) {
		this.sodium = sodium;
	}

	public int getPotasium() {
		return potasium;
	}

	public void setPotasium(int potasium) {
		this.potasium = potasium;
	}

	public double getIron() {
		return iron;
	}

	public void setIron(double iron) {
		this.iron = iron;
	}

	@Override
	public String toString() {
		return "Cereal [name=" + name + ", calories=" + calories + ", fat=" + fat + ", carbs=" + carbs + ", fiber="
				+ fiber + ", sugar=" + sugar + ", protein=" + protein + ", sodium=" + sodium + ", potasium=" + potasium
				+ ", iron=" + iron + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + calories;
		long temp;
		temp = Double.doubleToLongBits(fat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(carbs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fiber);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sugar);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(protein);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sodium);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + potasium;
		temp = Double.doubleToLongBits(iron);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cereal other = (Cereal) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (calories != other.calories)
			return false;
		if (Double.doubleToLongBits(fat) != Double.doubleToLongBits(other.fat))
			return false;
		if (Double.doubleToLongBits(carbs) != Double.doubleToLongBits(other.carbs))
			return false;
		if (Double.doubleToLongBits(fiber) != Double.doubleToLongBits(other.fiber))
			return false;
		if (Double.doubleToLongBits(sugar) != Double.doubleToLongBits(other.sugar))
			return false;
		if (Double.doubleToLongBits(protein) != Double.doubleToLongBits(other.protein))
			return false;
		if (Double.doubleToLongBits(sodium) != Double.doubleToLongBits(other.sodium))
			return false;
		if (potasium != other.potasium)
			return false;
		if (Double.doubleToLongBits(iron) != Double.doubleToLongBits(other.iron))
			return false;
		return true;
	}

	/**
	 * Converts comma-separated string into a Cereal object
	 */
	public static Cereal parse(String line) {
		String[] values = line.split(",");
		// Order defined in file:
		int index = 0;
		String name = values[index++];
		int calories = getInt(values[index++]);

		double fat = getDouble(values[index++]);
		double carbs = getDouble(values[index++]);
		double fiber = getDouble(values[index++]);
		double sugar = getDouble(values[index++]);
		double protein = getDouble(values[index++]);
		double sodium = getDouble(values[index++]);

		int potasium = 0;
		double iron = 0;
		if (index < values.length)
			potasium = getInt(values[index++]); // need to check for n/a in csv file
		if (index < values.length)
			iron = getDouble(values[index++]);
		return new Cereal(name, calories, fat, carbs, fiber, sugar, protein, sodium, potasium, iron);
	}

	private static double getDouble(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		} else {
			try {
				return Double.parseDouble(str);
			} catch (NumberFormatException e) {
				return 0;
			}
		}
	}

	private static int getInt(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		} else {
			try {
				return Integer.parseInt(str);
			} catch (NumberFormatException e) {
				return 0;
			}
		}
	}

	/**
	 * Convert cereal object into a comma-separated string
	 */
	public String csvformat() {
		// TODO code here
		
		
		
		
		
		
		return "";
	}

}