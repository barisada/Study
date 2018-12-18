package dailycoding;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
 */
public class Problem_10 {
    JobScheduler scheduler = new JobScheduler();
    public static void main(String[] args) {
        Problem_10 test = new Problem_10();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            String name = "Thread-" + i;
            threads.add(new Thread(() -> System.out.println(name), name));
        }

        ExecutorService executors = Executors.newFixedThreadPool(5);

        CompletableFuture[] completableFutures = new CompletableFuture[5];
        for(int i = 0; i < 5; i++){
            int factor = i;
            CompletableFuture temp = CompletableFuture.runAsync(() -> {
                try {
                    StopWatch sw = new StopWatch("task schedule");
                    sw.start(threads.get(factor).getName());
                    test.scheduler.runTaskAftterNmilliseconds(threads.get(factor), 1000 - (factor * 100));
                    sw.stop();
                    System.out.println(sw.getLastTaskTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, executors);
            completableFutures[i] = temp;
        }

        CompletableFuture.allOf(completableFutures).join();
        executors.shutdown();
    }

    private class JobScheduler{
        public void runTaskAftterNmilliseconds(Thread thread, long n) throws InterruptedException {
            new ScheduledThread(thread).run(n);
        }
    }

    private class ScheduledThread {
        private Thread thread;
        public ScheduledThread(Thread thread){
            this.thread = thread;
        }

        public void run(long n) throws InterruptedException {
            Thread.sleep(n);
            thread.run();
        }
    }

}
