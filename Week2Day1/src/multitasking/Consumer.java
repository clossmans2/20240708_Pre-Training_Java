package multitasking;

public class Consumer extends Thread {
	Company company;
	
	public Consumer(Company company) {
		this.company = company;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				company.consume();
				System.out.println("Queue state after consumption: " + company.queue);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
