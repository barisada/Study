package books.effective_java.ch10.item66;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2018-04-10.
 */
public class SharedMutableDataTest {
    public static void main(String[] args) throws InterruptedException {
        SharedMutableDataExample ex = new SharedMutableDataExample();
        //ex.livenessFailure();     //run forever
        ex.fixedLivenessFailure();  //run for 1 second

        ExecutorService executor = Executors.newFixedThreadPool(2, new CustomizableThreadFactory("serialNumberSafetyFailure-"));
        Set<Long> container = new HashSet<>();
        for(int i = 0 ; i < 999999; i++) {
            CompletableFuture.runAsync(() -> {
                long serialNumber = ex.serialNumberSafetyFailure();
                checkAndAdd(container, serialNumber);
            }, executor);
        }

        ExecutorService executor2 = Executors.newFixedThreadPool(2, new CustomizableThreadFactory("fixedSerialNumberSafetyFailure-"));
        Set<Long> container2 = new HashSet<>();
        for(int i = 0 ; i < 999999; i++) {
            CompletableFuture.runAsync(() -> {
                long serialNumber = ex.fixedSerialNumberSafetyFailure();
                checkAndAdd(container2, serialNumber);
            }, executor2);
        }

        executor.shutdown();
        executor2.shutdown();
        System.out.println("done");
    }

    private static void checkAndAdd(Set<Long> container, long serialNumber) {
        if (container.contains(serialNumber)) {
            System.out.println(Thread.currentThread().getName() + "] serial number : "  + serialNumber);
            System.out.println("safety failure");
            throw new RuntimeException("safety failure");
        } else {
            container.add(serialNumber);
        }
    }
}
