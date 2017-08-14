package hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jw on 2017-08-14.
 */
public class InsertionSort1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }

    public static void insertIntoSorted(int[] ar) {
        // Fill up this function
        for(int i = 1; i < ar.length; i++){
            int val = ar[i];
            for(int j = i - 1; j >= 0 && ar[j] > val; j--){
                ar[j + 1] = ar[j];
                printArray(ar);
                ar[j] = val;
            }
        }
        printArray(ar);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
