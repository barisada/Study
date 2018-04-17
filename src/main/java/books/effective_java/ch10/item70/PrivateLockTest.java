package books.effective_java.ch10.item70;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created on 2018-04-17.
 */
public class PrivateLockTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PrivateLockExample ex = new PrivateLockExample();

        List<Integer> safe = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            ex.safeAdd(safe, i);
        }

        System.out.println("safe : " + safe);

    }
}
