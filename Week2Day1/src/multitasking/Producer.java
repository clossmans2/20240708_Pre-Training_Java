package multitasking;

public class Producer extends Thread {
	Company company;
	
	public Producer(Company company) {
		this.company = company;
	}
	
	@Override
	public void run() {
		int i = 1;
		
		while(true) {
			try {
				company.produce(i);
				System.out.println("Queue state: " + company.queue);
				i++;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
