package multitasking;

import java.util.concurrent.ArrayBlockingQueue;

// ArrayBlockingQueue
// Bounded blocking queue backed by an array, thread-safe and uses locks to ensure consistency
public class ABQueue {

	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
		
		Runnable producer = () -> {
			try {
				for (int i = 1; i <= 5; i++) {
					queue.put(i);
					System.out.println("Produced: " + i);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		};
		
		Runnable consumer = () -> {
			try {
				while (true) {
					Integer item = queue.take();
					System.out.println("Consumed: " + item);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		};
		
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}
