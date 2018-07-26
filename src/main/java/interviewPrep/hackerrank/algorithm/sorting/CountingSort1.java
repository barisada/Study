package interviewPrep.hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jw on 2017-08-07.
 */
public class CountingSort1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Long[] count = new Long[100];
        IntStream.range(0, count.length).forEach(i -> count[i] = 0L);

        for(int i = 0; i < size; i++){
            int e = sc.nextInt();
            count[e]++;
        }
        String result = Arrays.asList(count).stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }
}


