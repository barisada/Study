package books.effective_java.ch10.item67;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.concurrent.*;

/**
 * Created on 2018-04-11.
 */
public class AvoidExcessiveSyncTest {
    public static void main(String[] args) {
        simpleObserverTest();
        concurrentModificationErrorTest();
        deadLockTest(observer);

        fixedConcurrentModificationErrorTest();
        fixedDeadLockTest(observer);

    }
    private static void fixedDeadLockTest(SetObserver<Integer> observer) {
        FixedObservableSet<Integer> set = new FixedObservableSet<>(new HashSet());
        runObserver(set, observer, "fixedDeadLockTest");
    }

    private static void fixedConcurrentModificationErrorTest() {
        FixedObservableSet<Integer> set = new FixedObservableSet<>(new HashSet());
        SetObserver<Integer> observer = new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element + " added");
                if(element == 23) set.removeObserver(this);
            }
        };
        runObserver(set, observer, "fixedConcurrentModificationErrorTest");
    }

    private static void deadLockTest(SetObserver<Integer> observer) {
        ObservableSet<Integer> set3 = new ObservableSet<>(new HashSet());
        runObserver(set3, observer, "deadLockTest");
    }

    private static void concurrentModificationErrorTest() {
        ObservableSet<Integer> set2 = new ObservableSet<>(new HashSet());
        SetObserver<Integer> observer2 = new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element + " added");
                if(element == 23) set.removeObserver(this);
            }
        };
        runObserver(set2, observer2, "concurrentModificationErrorTest");
    }

    private static void simpleObserverTest() {
        ObservableSet<Integer> set1 = new ObservableSet<>(new HashSet());
        SetObserver<Integer> observer1 = (observable, e) -> System.out.println(e + " added");
        runObserver(set1, observer1, "simpleObserverTest");
    }

    private static void runObserver(ObservableSet<Integer> set1, SetObserver<Integer> observer1, String name) {
        set1.addObserver(observer1);
        try{
            for(int i = 0 ; i < 100; i++){
                set1.add(i);
            }
        } catch (ConcurrentModificationException e){
            e.printStackTrace();
        }
        System.out.println("============ " + name  + " F I N I S H E D================");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static SetObserver<Integer> observer = new SetObserver<Integer>() {
        @Override
        public void added(ObservableSet<Integer> s, Integer e) {
            System.out.println(e + " added");
            if(e == 24){
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                final SetObserver<Integer> observer = this;
                try{
                    executorService.submit(() -> s.removeObserver(observer)).get(1, TimeUnit.SECONDS);
                } catch (ExecutionException | InterruptedException | TimeoutException e1 ) {
                    e1.printStackTrace();
                    System.out.println("time out for deadlock example");
                } finally {
                    executorService.shutdown();
                }
            }
        }
    };
}
