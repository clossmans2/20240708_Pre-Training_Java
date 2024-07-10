package utils;

import java.util.ArrayList;

// Generics provide a way to parameterize types

public class SethList<T> {
	private T data;
	
	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public static void main(String[] args) {
		SethList<String> stringInstance = new SethList<>();
		stringInstance.setData("I am a generic piece of data");
		System.out.println(stringInstance.getData());
		
		SethList<Integer> integerInstance = new SethList<>();
		integerInstance.setData(123);
		System.out.println(integerInstance.getData());
		
		ArrayList<SethList<String>> listOfSethLists = 
				new ArrayList<SethList<String>>();
	}
}











