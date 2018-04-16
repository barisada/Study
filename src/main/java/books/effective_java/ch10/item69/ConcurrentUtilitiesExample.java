package books.effective_java.ch10.item69;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * Created on 2018-04-17.
 */
public class ConcurrentUtilitiesExample {
    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public static String intern(String s){
        String prev = map.putIfAbsent(s, s);
        return prev == null ? s : prev;
    }

    public static String fasterIntern(String s){
        String result = map.get(s);
        if(result == null){
            result = map.putIfAbsent(s, s);
            if(result == null) return s;
        }
        return result;
    }

    public static long time(Executor executor, int concurrency, final Runnable action) throws InterruptedException {
        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown(); // Tell timer we're ready
                try {
                    start.await(); // Wait till peers are ready
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown(); // Tell timer we're done
                }
            });
        }
        ready.await(); // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        start.countDown(); // And they're off!
        done.await(); // Wait for all workers to finish
        return System.nanoTime() - startNanos;
    }
}
