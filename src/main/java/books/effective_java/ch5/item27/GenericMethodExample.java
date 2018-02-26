package books.effective_java.ch5.item27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GenericMethodExample {

    public static <E> Set<E> union(Set<E> s1, Set<E> s2){
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<String> guys = new HashSet<>(Arrays.asList("Tom", "Dick", "Harray"));
        Set<String> stooges = new HashSet<>(Arrays.asList("Larry", "Moe", "Curly"));
        Set<String> afCio = union(guys, stooges);
        System.out.println(afCio);
    }
}
