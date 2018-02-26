package books.effective_java.ch5.item27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RecursiveTypeBoundExample {
    public static <T extends Comparable<T>> T max(List<T> list){
        Iterator<T> it = list.iterator();
        T result = it.next();
        while(it.hasNext()){
            T t = it.next();
            if(t.compareTo(result) > 0) result = t;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "C", "d");
        System.out.println(max(list));

        List<Integer> list2 = Arrays.asList(12873, 123123, 8029837);
        System.out.println(max(list2));


        //Cannot use max method class does not impl Comparable class...
        List<RecursiveTypeBoundExample> list3 = new ArrayList<>(){
            {
                this.add(new RecursiveTypeBoundExample());
                this.add(new RecursiveTypeBoundExample());
                this.add(new RecursiveTypeBoundExample());
            }
        };

    }
}
