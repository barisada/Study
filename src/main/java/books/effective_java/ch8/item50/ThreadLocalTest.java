package books.effective_java.ch8.item50;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2018. 4. 1..
 */
public class ThreadLocalTest {

	public static void main(String[] args) {
		ThreadLocalExample ex = new ThreadLocalExample();
		ExecutorService executor = Executors.newFixedThreadPool(10, new CustomizableThreadFactory("myThread-"));
		CompletableFuture.runAsync(() -> ex.useThreadLocal("t1", 0).run(), executor);
		CompletableFuture.runAsync(() -> ex.useThreadLocal("t2", 100).run(), executor);
		executor.shutdown();
	}
}
