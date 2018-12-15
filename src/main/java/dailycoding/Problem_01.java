package dailycoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        int[] test2 = {2,3,4,5,7};
        System.out.println(findValue(arr, 13));
        System.out.println(findValue2(test2, 6));
    }

    // o (n log n)
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
    //time : O(n), space : o(n)
    static boolean findValue2(int[] arr, int val){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int target = val - arr[i];
            if(map.containsKey(target) && map.get(target) != i){
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }
}
