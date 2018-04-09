package books.effective_java.ch9.item64;

import java.util.*;

/**
 * Created on 2018-04-09.
 */
public class FailureAtomicExample {

    public List<Integer> failureAtomicError(List<Integer> list){
        List<Integer> copied = new ArrayList<>(list);
        copied.add(new Random().nextInt());
        if(list.size() >  0) {
            try {
                throw new Exception("not empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }
        return copied;
    }

    public static void main(String[] args) {
        FailureAtomicExample ex = new FailureAtomicExample();
        List<Integer> list1 = Arrays.asList(1,2,3,4);
        List<Integer> list2 = ex.failureAtomicError(list1);
        System.out.println(list1 + " vs " + list2 + " same? " + list1.equals(list2));

        List<Integer> list3 = Collections.emptyList();
        List<Integer> list4 = ex.failureAtomicError(list3);
        System.out.println(list3 + " vs " + list4 + " same? " + list3.equals(list4));
    }
}
