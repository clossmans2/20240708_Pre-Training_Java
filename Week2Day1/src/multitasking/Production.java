package multitasking;

public class Production {

	public static void main(String[] args) {
		Company company = new Company(5);
		Producer producer = new Producer(company);
		Consumer consumer = new Consumer(company);
		Consumer consumer2 = new Consumer(company);
		
		producer.setName("Producer-Thread");
		producer.start();
		consumer.setName("Consumer-Thread1");
		consumer2.setName("Consumer-Thread2");
		consumer.start();
		consumer2.start();
		
	}

}
