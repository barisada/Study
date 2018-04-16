package books.effective_java.ch10.item69;

import org.springframework.util.StopWatch;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2018-04-17.
 */
public class ConcurrentUtilitiesTest {
    public static void main(String[] args) throws InterruptedException {
        compareIntern();
        System.out.println("=======================");
        time();
    }

    private static void time() throws InterruptedException {
        long time = ConcurrentUtilitiesExample.time(
                Executors.newFixedThreadPool(5),
                5,
                () -> System.out.println(Thread.currentThread().getName() + " is running"));
        System.out.println(time + " nanoTime");
    }

    private static void compareIntern() {
        int loop = 1000000;
        StopWatch sw = new StopWatch("compare intern method");
        sw.start("String.intern");
        for(int i = 0; i < loop; i++){
            String.valueOf(i).intern();
        }
        for(int i = 0; i < loop; i++){
            String.valueOf(i).intern();
        }
        sw.stop();

        sw.start("concurrent intern");
        for(int i = 0; i < loop; i++){
            ConcurrentUtilitiesExample.intern(String.valueOf(i));
        }
        for(int i = 0; i < loop; i++){
            ConcurrentUtilitiesExample.intern(String.valueOf(i));
        }
        sw.stop();

        sw.start("concurrent faster intern");
        for(int i = 0; i < loop; i++){
            ConcurrentUtilitiesExample.fasterIntern(String.valueOf(i));
        }
        for(int i = 0; i < loop; i++){
            ConcurrentUtilitiesExample.fasterIntern(String.valueOf(i));
        }
        sw.stop();
        System.out.println(sw.prettyPrint());
    }

}
