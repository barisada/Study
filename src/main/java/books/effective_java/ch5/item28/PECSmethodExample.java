package books.effective_java.ch5.item28;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class PECSmethodExample {

    public static <T extends Comparable<? super T>> T max(List<? extends T> list){
        Iterator<? extends T> it = list.iterator();
        T result = it.next();
        while(it.hasNext()){
            T t = it.next();
            if(t.compareTo(result) > 0) result = t;
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<ScheduledFuture<?>> list = new ArrayList<>();
        ScheduledExecutorService service1 = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> sf1 = service1.schedule(() -> "schedule1", 10, TimeUnit.MILLISECONDS);
        ScheduledFuture<?> sf2 = service1.schedule(() -> "schedule2", 5, TimeUnit.MILLISECONDS);
        ScheduledFuture<?> sf3 = service1.schedule(() -> "schedule3", 100, TimeUnit.MILLISECONDS);
        list.add(sf1);
        list.add(sf2);
        list.add(sf3);
        service1.shutdown();

        ScheduledFuture<?> max = max(list);
        System.out.println("max deplay schedule: " + max.get());
    }

}
