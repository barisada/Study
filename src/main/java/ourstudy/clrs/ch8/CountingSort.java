package ourstudy.clrs.ch8;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by jw on 2017-08-07.
 * visualizing counting sort: http://www.cs.miami.edu/home/burt/learning/Csc517.091/workbook/countingsort.html
 */
public class CountingSort {

    public int[] sort(int...array) {
        int max = Arrays.stream(array).max().getAsInt();
        int[] count = new int[max + 1];
        int[] sorted = new int[array.length];
        //init
        IntStream.range(0, count.length).forEach(i -> count[i] = 0);
        IntStream.range(0, sorted.length).forEach(i -> sorted[i] = 0);

        //array의 원소값이 나타난 횟수 카운트
        IntStream.range(0, array.length).forEach(i -> count[array[i]]++);

        //count배열을 누적카운트배열로 바꿈.
        IntStream.range(1, count.length).forEach(i -> {
            count[i] = count[i - 1] + count[i];
        });

        //System.out.println("array : " + Arrays.stream(array).boxed().collect(Collectors.toList()));
        //System.out.println("count : " + Arrays.stream(count).boxed().collect(Collectors.toList()));
        for(int i = array.length - 1; i >=0; i--){
            int countPos = array[i];
            int sortedPos = count[countPos] - 1;
            sorted[sortedPos] = array[i];
            count[countPos]--;
        }

        return sorted;
    }
}
