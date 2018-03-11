package hackerrank.algorithm.sorting;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by jw on 2017-08-14.
 */
public class InsertionSortAdvancedAnalysis {
    static int shiftCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        IntStream.range(0, total).forEach(loop -> {
            int size = sc.nextInt();
            int[] ar = IntStream.range(0, size).map(i -> sc.nextInt()).toArray();
            insertionSort(ar);
            System.out.println(shiftCount);
            shiftCount = 0;
        });
    }

    public static void insertionSort(int[] ar)
    {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
        for(int i = 1; i < ar.length; i++){
            int val = ar[i];
            for(int j = i - 1; j >= 0 && ar[j] > val; j--){
                ar[j + 1] = ar[j];
                ar[j] = val;
                shiftCount++;
            }
        }
    }
}
