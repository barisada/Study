package hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jw on 2017-08-07.
 */
public class TheFullCountingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Integer[] index = new Integer[size];
        String[] str = new String[size];
        for(int i = 0; i < size; i ++){
            index[i] = sc.nextInt();
            str[i] = sc.next();
            if(i < size / 2){
                str[i] = "-";
            }
        }

        int max = Arrays.stream(index).max(Integer::compare).get();
        Integer[] count = new Integer[max + 1];
        Arrays.fill(count, 0);
        for(int i : index){
            count[i]++;
        }

        //누적 카운트
        IntStream.range(1, count.length).forEach(i -> count[i] = count[i - 1] + count[i]);

        Integer[] sorted = new Integer[size];
        String[] sortedStr = new String[size];
        for(int i = index.length - 1; i >= 0; i--){
            int pos = index[i];
            if(count[pos] > 0){
                int pos2 = count[pos] - 1;
                sorted[pos2] = index[i];
                sortedStr[pos2] = str[i];
                count[pos]--;
            }
        }
        //System.out.println(Arrays.asList(sorted));
        //System.out.println(Arrays.asList(sortedStr));
        System.out.println(Arrays.stream(sortedStr).map(s -> s).collect(Collectors.joining(" ")));

    }
}
