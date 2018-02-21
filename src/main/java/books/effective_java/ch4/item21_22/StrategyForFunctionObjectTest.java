package books.effective_java.ch4.item21_22;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StrategyForFunctionObjectTest {
    public static void main(String[] args) {
        //concreate comparator example
        System.out.println("======== concrete comparator ex ====");
        String[] arr = {"b", "a", "ab", "abc", "bc"};;
        Arrays.sort(arr, ComparatorHostExmaple.STR_LENGTH_COMPARATOR);
        System.out.println("sort by length : " + Arrays.toString(arr));

        Arrays.sort(arr, ComparatorHostExmaple.STR_LENGTH_COMPARATOR.reversed());
        System.out.println("reverse sort by length : " + Arrays.toString(arr));


        //anonymous example
        System.out.println("======== anonymous comparator ex ====");
        List<String> list = Arrays.asList(arr);
        list.sort(Comparator.comparingInt(String::length));
        System.out.println("sort by length : " + list);

        list.sort(Collections.reverseOrder(Comparator.comparingInt(String::length)));
        System.out.println("reverse sort by length : " + list);


    }
}
