package dailycoding;

import java.util.Arrays;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 *
 * Bonus: Can you do this in one pass?
 */
public class Problem_01 {
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        System.out.println(findValue(arr, 13));
    }

    static boolean findValue(int[] arr, int val){
        Arrays.sort(arr);
        int lo = 0, hi = arr.length - 1;
        while(lo < hi){
            int sum = arr[lo] + arr[hi];
            if(sum == val){
                return true;
            } else if(sum > val){
                hi--;
            } else {
                lo++;
            }
        }
        return false;
    }
}
