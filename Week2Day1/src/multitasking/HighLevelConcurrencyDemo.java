package multitasking;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Higher Level Abstractions on top of threads/runnables
// 1. Lock objects
// 2. Executor, ExecutorService, ScheduledExecutorService
// Executor -> execute()
public class HighLevelConcurrencyDemo {

	public static void main(String[] args) {
		
		final Friend seth = new Friend("Seth");
		final Friend james = new Friend("James");
		// executor.execute(new BowLoop(seth,james));
		new Thread(new BowLoop(seth, james)).start();
		new Thread(new BowLoop(james, seth)).start();
	}
	
	static class Friend {
		private final String name;
		private final Lock lock = new ReentrantLock();
		
		public Friend(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public boolean impendingBow(Friend bower) {
			Boolean myLock = false;
			Boolean yourLock = false;
			
			try {
				myLock = lock.tryLock();
				yourLock = bower.lock.tryLock();
			} finally {
				if ( ! (myLock && yourLock)) {
					if (myLock) {
						lock.unlock();
					}
					if (yourLock) {
						bower.lock.unlock();
					}
				}
			}
			return myLock && yourLock;
		}
		
		public void bow(Friend bower) {
			if (impendingBow(bower)) {
				try {
					System.out.format("%s: %s has" + 
										" bowed to me!%n",
										this.name, bower.getName());
					// Bow Back
					bower.bowBack(bower);
				} finally {
					lock.unlock();
					bower.lock.unlock();
				}
			} else {
				System.out.format("%s: %s started" + 
						" to bow to me, but saw that" +
						" I was already bowing to him.%n",
						this.name, bower.getName());
			}
		}
		
		public void bowBack(Friend bower) {
			System.out.format("%s: %s has" + 
					" bowed back to me!%n",
					this.name, bower.getName());
		}
	}
	
	static class BowLoop implements Runnable {
		private Friend bower;
		private Friend bowee;
		
		public BowLoop(Friend bower, Friend bowee) {
			this.bower = bower;
			this.bowee = bowee;
		}

		@Override
		public void run() {
			Random random = new Random();
			for (;;) {
				try {
					Thread.sleep(random.nextInt(10));
				} catch (InterruptedException e) {
					
				}
				bowee.bow(bower);
			}
		}		
	}
}











