package interviewPrep.hackerrank.algorithm.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by jw on 2017-09-18.
 */
public class LargestPermutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ar = new int[n];
        int[] index = new int[n + 1];

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
            index[ar[i]] = i;
        }

        for(int i = 0; i < n && k > 0; i++) {
            if(ar[i] == n - i){
                continue;
            }
            int temp = ar[i];
            int pos = index[n - i];
            ar[pos] = temp;
            index[temp] = pos;
            ar[i] = n - i;
            index[n - i] = i;
            k--;
        }
        System.out.println(Arrays.stream(ar).boxed().map(String::valueOf).collect(Collectors.joining(" ")));
    }


}
