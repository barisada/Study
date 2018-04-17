package books.effective_java.ch10.item70;

import java.util.List;

/**
 * Created on 2018-04-17.
 */
public class PrivateLockExample {
    private final Object lock = new Object();

    /**
     * Thread safe add
     * @param list
     * @param t
     * @param <T>
     */
    public <T> void safeAdd(List<T> list, T t){
        synchronized (lock){
            list.add(t);
        }
    }

    /**
     * Thread not safe add
     * @param list
     * @param i
     * @param <T>
     */
    public <T> void unSafeAdd(List<T> list, T i){
        list.add(i);
    }

}
