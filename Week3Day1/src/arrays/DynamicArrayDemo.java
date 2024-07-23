package arrays;

import java.util.Arrays;

public class DynamicArrayDemo {

	public static void main(String[] args) {
		DynamicArray dA = new DynamicArray();
		dA.add(1);
		System.out.println("Size: " + dA.size());
		System.out.println("Capacity: " + dA.capacity());
		dA.add(2);
		System.out.println("Size: " + dA.size());
		System.out.println("Capacity: " + dA.capacity());
		dA.add(13);
		System.out.println("Size: " + dA.size());
		System.out.println("Capacity: " + dA.capacity());
		dA.add(3);
		System.out.println("Size: " + dA.size());
		System.out.println("Capacity: " + dA.capacity());
		dA.add(4);
		System.out.println("Size: " + dA.size());
		System.out.println("Capacity: " + dA.capacity());
		dA.add(5);
		System.out.println("Size: " + dA.size());
		System.out.println("Capacity: " + dA.capacity());
		dA.add(6);
		System.out.println("Size: " + dA.size());
		System.out.println("Capacity: " + dA.capacity());
		dA.add(7);
		System.out.println("Size: " + dA.size());
		System.out.println("Capacity: " + dA.capacity());
		dA.add(11);
		
		System.out.println("Size: " + dA.size());
		System.out.println("Capacity: " + dA.capacity());
		for (int i = 0; i < dA.size(); i++) {
			System.out.println(dA.get(i) + " ");
		}
		
		dA.remove(dA.size() - 1);
		dA.remove(dA.size() - 1);
		dA.remove(dA.size() - 1);
		dA.remove(dA.size() - 1);
		dA.remove(dA.size() - 1);
		dA.remove(dA.size() - 1);
		dA.remove(dA.size() - 1);
		for (int i = 0; i < dA.size(); i++) {
			System.out.println(dA.get(i) + " ");
		}
	}

}

class DynamicArray {
	private int[] array;
	private int size;
	private int capacity;
	
	public DynamicArray() {
		array = new int[2];
		size = 0;
		capacity = 2;
	}
	
	public void add(int element) {
		if (size == capacity) {
			resize();
			System.out.println("Array increased in capacity");
		}
		array[size++] = element;
	}
	
	private void resize() {
		capacity *= 2;
		array = Arrays.copyOf(array, capacity);
	}
	
	public int get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index is out of bounds for the array.");
		}
		return array[index];
	}
	
	public void remove(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index is out of bounds for the array.");
		}
		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		size--;
		if (size <= capacity / 4) {
			downsize();
			System.out.println("Array decreased in capacity");
		}
	}
	
	private void downsize() {
		capacity /= 2;
		array = Arrays.copyOf(array, capacity);
	}
	
	public int size() {
		return size;
	}
	public int capacity() {
		return capacity;
	}
}









