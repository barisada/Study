package books.effective_java.ch10.item68;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created on 2018-04-12.
 */
public class ExecutorsExample {

    @PrintMethodName
    public void singleThreadExample(){
        ExecutorService executor = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("single thread-"));
        executor.execute(() -> System.out.println(Thread.currentThread().getName() + " is running"));
        executor.shutdown();
    }

    @PrintMethodName
    public void threadPoolExample() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3, new CustomizableThreadFactory("fixed-"));
        for(int i = 0 ; i < 9; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
                try {
                    Thread.sleep(new Random().nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(10);
        executor.shutdown();
    }

    @PrintMethodName
    public void cachedThreadPoolExample() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(new CustomizableThreadFactory("cached-"));
        for(int i = 0 ; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
                try {
                    Thread.sleep(new Random().nextInt(20));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(20);
        executorService.shutdown();
    }

    @PrintMethodName
    public void callableExample() throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4, new CustomizableThreadFactory("scheduled-"));

        List<Future<Integer>> list = new ArrayList<>();

        final int[] arr = new int[1];
        arr[0] = 1;

        for(int i = 0; i < 10; i++) {
            list.add(executorService.schedule(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
                return ++arr[0];
            }, 1, TimeUnit.SECONDS));
        }

        for(Future<Integer> future : list){
            System.out.println(future.get());
        }
        Thread.sleep(20);
        executorService.shutdown();
    }
}
