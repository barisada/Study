package books.effective_java.ch7.item41;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ConfusingOverloadedMethodExample {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i = -3; i < 3; i++){
            set.add(i);
            list.add(i);
            list2.add(i);
        }

        //suppose to remove positive number
        for(int i = 0; i < 3; i++){
            set.remove(i);
            list.remove(i); //this remove(int i) not works as intended. it delete its position.
            list2.remove((Integer) i);  // this remove(Object o) works as intended.
        }

        System.out.println(set + " " + list + " " + list2);

    }
}
