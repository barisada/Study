package books.effective_java.ch10.item72;

import org.springframework.util.StopWatch;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2018-04-27.
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        int num = 2000;
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        StopWatch sw = new StopWatch("compare countDownLatch");

        awfulCountDownLatch(num, executorService, sw);
        normalCountLatchDown(num, executorService, sw);

        System.out.println(sw.prettyPrint());
    }

    private static void normalCountLatchDown(int num, ExecutorService executorService, StopWatch sw) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(num);
        Thread t2 = new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + "] end");
            countDownLatch.countDown();
        });
        sw.start("better countDownLatch");
        for(int i = 0; i < num; i++) {
            executorService.execute(t2);
        }
        countDownLatch.await();
        sw.stop();
        executorService.shutdown();
    }

    private static void awfulCountDownLatch(int num, ExecutorService executorService, StopWatch sw) {
        AwfulCountDownLatchExample ex = new AwfulCountDownLatchExample(num);
        Thread t1 = new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + "] end");
            ex.countDown();
        });

        sw.start("awful countDownLatch");
        for(int i = 0; i < num; i++) {
            executorService.execute(t1);
        }
        ex.await();
        sw.stop();
    }
}
