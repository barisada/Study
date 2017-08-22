package ourstudy.clrs.ch8;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by jw on 2017-08-07.
 */
public class CountingSortClient {
    public static void main(String[] args) {
        int[] input = {5,4,3,2,1,0,5,6,6,6,6,6,10,7};
        CountingSort cs = new CountingSort();
        int[] arr = cs.sort(input);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
