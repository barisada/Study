package books.effective_java.ch2.item6;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        Map<Object, Object> weakMap = new WeakHashMap<>();
        Object key = new Object();
        String value = "value";

        weakMap.put(key, value);
        System.out.println(weakMap);
        key = null;
        System.out.println(weakMap.size());
        System.gc();
        while(weakMap.size() > 0){}
        System.out.println("weakMap is gone : " + weakMap);

    }
}
