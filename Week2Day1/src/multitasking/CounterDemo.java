package multitasking;

public class CounterDemo {
	public static void main(String[] args) {
		CounterDemo cd = new CounterDemo();
	}
	
	private int storedValue = 0;
	
	public synchronized void increment() {
		storedValue++;
	}
	
	public synchronized void decrement() {
		storedValue--;
	}
	
	public synchronized int getStoredValue() {
		return storedValue;
	}
}
