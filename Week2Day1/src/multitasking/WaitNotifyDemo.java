package multitasking;

public class WaitNotifyDemo {
	private static final Object lock = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			synchronized (lock) {
				try {
					System.out.println("Thread 1 is waiting.");
					lock.wait();
					System.out.println("Thread 1 resumed");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			synchronized (lock) {
				System.out.println("Thread 2 notifying");
				lock.notify();
			}
		});
		
		t1.start();
		Thread.sleep(2000);
		t2.start();
		
		t1.join();
		t2.join();		
	}

}
