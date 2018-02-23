package books.effective_java.ch5.item25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListWithGenericExmapleTest {
    public static void main(String[] args) throws InterruptedException {
        List list = new ArrayList(Arrays.asList(1,2,3,4,5,6));
        Object obj1 = null;
        try {
            obj1 = ListWithGenericExample.reduceWithoutGenericAndConcurrencySupport(
                    list,
                    (o1, o2) -> Integer.valueOf(o1.toString()) + Integer.valueOf(o2.toString()),
                    0
            );
        } catch (Exception e){
            e.printStackTrace();

        }
        Thread.sleep(5);
        System.out.println("obj1 : " + obj1);

        System.out.println("============================");
        List list2 = new ArrayList(Arrays.asList(1,2,3,4,5,6));
        Object obj2 = ListWithGenericExample.reduceWithoutGeneric(
                list2,
                (o1, o2) -> Integer.valueOf(o1.toString()) + Integer.valueOf(o2.toString()),
                0
        );
        System.out.println("obj2 : " + obj2);

        System.out.println("============================");
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Object obj3 = ListWithGenericExample.reduce(
                list3,
                (o1, o2) -> Integer.valueOf(o1.toString()) + Integer.valueOf(o2.toString()),
                0
        );
        System.out.println("obj3 : " + obj3);
    }
}
