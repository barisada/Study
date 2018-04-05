package books.effective_java.ch9.item60;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created on 2018-04-06.
 */
public class UseStandardExceptionExample {

    public static void illegalArgumentException(int i){
        if(i == 0) throw new IllegalArgumentException("i : " + i);
    }

    public static void illegalStateException(SomeObject obj){
        if(!obj.isReady()) throw new IllegalStateException("obj : " + obj);
    }

    public static void nullPointerException(Object obj){
        if(obj == null) throw new NullPointerException("obj : " + obj);
    }

    public static void indexOutOfBoundsException(int i){
        i = Math.abs(i) + 1;
        int[] arr = new int[0];
        arr[i] = i;
    }

    public static void concurrentModificationException(){
        Map map = new HashMap(10);
        map.put(null, null);
        map.forEach((k,v) -> {
            map.put(k, v);
            map.remove(k);
        });
        System.out.println(map);

    }

    public static void unsupportedoperationException(){
        List<Integer> list = Arrays.asList(1,2,3);
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            list.remove(it.next());
        }
        System.out.println("list : " + list);
    }

}

class SomeObject {
    private boolean isReady = false;
    SomeObject(){}
    SomeObject(boolean isReady){
        this.isReady = isReady;
    }

    public boolean isReady(){
        return isReady;
    }
}