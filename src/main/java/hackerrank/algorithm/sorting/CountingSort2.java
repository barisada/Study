package hackerrank.algorithm.sorting;

import ourstudy.clrs.ch8.CountingSort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by jw on 2017-08-07.
 */
public class CountingSort2 {
    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] input = new int[size];
        for(int i = 0; i < size; i++){
            input[i] = sc.nextInt();
        }
        int[] sorted = countingSort.sort(input);
        String result = Arrays.stream(sorted).boxed().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }
}

