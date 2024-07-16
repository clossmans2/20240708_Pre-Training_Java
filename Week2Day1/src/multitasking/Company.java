package multitasking;

import java.util.LinkedList;
import java.util.Queue;

public class Company {
	Queue<Integer> queue;
	int size;
	boolean producer = true;
	
	public Company(int size) {
		this.queue = new LinkedList<>();
		this.size = size;
	}
	
	public synchronized void produce(int number) throws InterruptedException {
		while (!producer || this.queue.size() > this.size) {
			System.out.println("Waiting " + Thread.currentThread().getName());
			wait();
		}		
		queue.add(number);
		producer = false;
		System.out.println("Produced: " + number);
		notifyAll();		
	}
	
	 public synchronized int consume() throws InterruptedException {
		while (producer || this.queue.isEmpty()) { 
			System.out.println("Waiting " + Thread.currentThread().getName());
			wait();
		}
		System.out.println("Consumer: " + Thread.currentThread().getName() + " consuming");
		System.out.println("Consumed: " + queue.peek());
		producer = true;
		notifyAll();
		return queue.remove();
	}

}
