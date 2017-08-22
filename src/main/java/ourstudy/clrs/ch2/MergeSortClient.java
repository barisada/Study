package ourstudy.clrs.ch2;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by jw on 2017-08-11.
 */
public class MergeSortClient {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = {1,1,1,2,2};
        mergeSort.mergeSort(array, 0, array.length -1);
        System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));
    }
}
