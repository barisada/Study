package books.effective_java.ch4.item16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CompositionTest {

    public static void main(String[] args) {
        WrapperSetForCompositionEx<Integer> ex = new WrapperSetForCompositionEx<>(new HashSet<>());
        ex.add(1);
        ex.add(1);
        ex.add(2);
        System.out.println(ex.getAddCount() + " : " + ex);

        Set<Integer> set = new HashSet<>(Arrays.asList(3,4,5));
        ex.addAll(set);
        System.out.println(ex.getAddCount() + " : " + ex);

        Set<Integer> set2 = new HashSet<>(Arrays.asList(4,5,6));
        ex.addAll(set2);
        System.out.println(ex.getAddCount() + " : " + ex);

    }
}
