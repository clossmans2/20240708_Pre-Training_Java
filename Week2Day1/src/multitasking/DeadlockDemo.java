package multitasking;

public class DeadlockDemo {
	private static final Object lock1 = new Object();
	private static final Object lock2 = new Object();

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			synchronized (lock1) {
				System.out.println("Thread 1 is holding lock 1");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e){}
				
				synchronized (lock2) {
					System.out.println("Thread 1 is holding lock 2");
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			synchronized (lock2) {
				System.out.println("Thread 2 is holding lock 2");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e){}
				
				synchronized (lock1) {
					System.out.println("Thread 2 is holding lock 1");
				}
			}
		});
		
		t1.start();
		t2.start();
	}

}
