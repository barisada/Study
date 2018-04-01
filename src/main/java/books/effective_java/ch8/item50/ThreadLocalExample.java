package books.effective_java.ch8.item50;

import java.util.Random;

/**
 * Created on 2018. 4. 1..
 */
public class ThreadLocalExample {
	ThreadLocal<String> threadLocal = new ThreadLocal<>();
	ThreadLocal<Integer> sharedCount = new ThreadLocal<>();

	public Thread useThreadLocal(String name, int bound) {
		Thread t = new Thread(() -> {
			threadLocal.set(name + " thread");
			int i = new Random().nextInt(10) + bound;

			for (int j = 0; j < 10; j++) {
				try {
					Thread.sleep(new Random().nextInt(100));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sharedCount.set(++i);
				System.out.println(Thread.currentThread().getName() + "] " +
						threadLocal.get() + " : " + sharedCount.get());
			}
		});
		return t;
	}

}
