package ourstudy.kakaotest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jw on 2017-07-02.
 */
public class SecondProblem {
    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[] decimals = new int[total];
        int[] binaryCardinarity = new int[total];
        for(int i = 0; i < total; i++){
            int input = sc.nextInt();
            decimals[i] = input;
            binaryCardinarity[i] = Integer.toBinaryString(input).replaceAll("0", "").length();
        }
        sc.close();
       // int[] sortedArray = quicksort(decimals, binaryCardinarity, 0, binaryCardinarity.length-1);
       // System.out.println(Arrays.asList(sortedArray));
    }

  /*  public static void quicksort(int[] decimals, int[] binaryCardinarity, int i, int j) {
        if(i < j){
            int pivot = binaryCardinarity[i];
            int decimalPivot = decimals[i];
            int left = i;
            int right = j;

            while(left < right){
                while(binaryCardinarity[right] > pivot) right--;
                while(left < right && binaryCardinarity[left] < pivot) left++;
                if(binaryCardinarity[left] == pivot){
                    if(decimals[left] > decimalPivot){
                        changePosition(decimals, binaryCardinarity, left, right);
                    }
                }
                changePosition(binaryCardinarity, left, right);
            }

            binaryCardinarity[i] = binaryCardinarity[right];
            binaryCardinarity[right] = pivot;

            quicksort(binaryCardinarity, i, right - 1);
            quicksort(binaryCardinarity, right + 1, j);

        }
    }*/

    private static void changePosition(int[] binaryCardinarity, int left, int right) {
        int temp = binaryCardinarity[left];
        binaryCardinarity[left] = binaryCardinarity[right];
        binaryCardinarity[right] = temp;
    }
}
