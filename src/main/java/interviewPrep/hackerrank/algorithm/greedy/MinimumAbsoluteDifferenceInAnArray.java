package interviewPrep.hackerrank.algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jw on 2017-09-18.
 */
public class MinimumAbsoluteDifferenceInAnArray {

    static int minimumAbsoluteDifference(int n, int[] arr) {
        // Complete this function
        arr = Arrays.stream(arr).sorted().toArray();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++){
            int temp = Math.abs(arr[i] - arr[i + 1]);
            if(temp == 0) return 0;
            else if(min > temp) min = temp;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = minimumAbsoluteDifference(n, arr);
        System.out.println(result);
        in.close();
    }
}
