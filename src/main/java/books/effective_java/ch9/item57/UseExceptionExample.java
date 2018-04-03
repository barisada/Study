package books.effective_java.ch9.item57;

import java.util.*;

/**
 * Created on 2018-04-04.
 */
public class UseExceptionExample {

    public static void badExceptionCase(){
        int[] arr = new int[5];
        int i = 0;
        try{
            while(true){
                arr[i++] = i;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("bad exception use case");
            e.printStackTrace();
        }
    }

    public static void goodExceptionCase(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Iterator<Integer> it = list.iterator();
        try {
            while (true) {
                it.next();
            }
        } catch (NoSuchElementException e){
            System.out.println("good exception use case");
            e.printStackTrace();
        }
    }
}
