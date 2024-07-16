package multitasking;

public class SharingDemo {

	public static void main(String[] args) {
		SharedResource share = new SharedResource();
		
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println("----- Thread1 -------");
				share.increment();
			}
		});
		
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println("----- Thread2 -------");
				share.increment();
			}
		});
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join(2000);
			thread2.join();
			throw new InterruptedException();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("The program has exited");
		}
	}

}

class SharedResource {
	private int counter = 0;
	
	public synchronized void increment() {
		counter++;
		System.out.println("The counter value is now " + counter);
	}
}
