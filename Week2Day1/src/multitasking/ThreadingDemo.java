package multitasking;

// Thread States
// NEW -> not started yet
// RUNNABLE -> thread executing in the JVM
// BLOCKED -> thread blocked waiting for a monitor lock
// WAITING -> waiting indefinitely for another thread to perform a specific action
// TIMED_WAITING -> waiting for another thread up to specific wait time
// TERMINATED -> thread that has exited

public class ThreadingDemo {

	public static void main(String[] args) throws InterruptedException {
//		MyThread thread1 = new MyThread();
//		thread1.start();
//		Thread thread2 = new Thread(new MyRunnable());
//		thread2.start();
//		Thread.sleep(5000);
		
		String importantInfo[] = {
	            "Mares eat oats",
	            "Does eat oats",
	            "Little lambs eat ivy",
	            "A kid will eat ivy too"
	        };
		
		for (int i = 0; i < importantInfo.length; i++) {
			// Pause for 5 seconds
			Thread.sleep(5000);
			
			System.out.println(importantInfo[i]);
		}
	}

}

class MyThread extends Thread {
	public void run() {
		System.out.println("MyThread is running.");
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("MyRunnable class instance is running.");		
	}

}