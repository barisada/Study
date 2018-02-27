package books.effective_java.ch5.item28;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ExplicitTypeParameterExample {

    static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2){
        Set<E> result = new LinkedHashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Double> s2 = new HashSet<>(Arrays.asList(4.0, 5.0, 6.0));

        //explicit type parameter is not necessary in modern java...
        Set<Number> union = ExplicitTypeParameterExample.<Number>union(s1, s2);
        System.out.println(union);
    }
}
