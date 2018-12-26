package dailycoding;

import java.util.*;

/**
 * Given an array of integers and a number k, where 1 <= k <= length of the array,
 * compute the maximum values of each subarray of length k.
 *
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
 *
 * 10 = max(10, 5, 2)
 * 7 = max(5, 2, 7)
 * 8 = max(2, 7, 8)
 * 8 = max(7, 8, 7)
 * Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
 *
 * leetcode #239. Sliding Window Maximum
 */
public class Problem_17 {
    public static void main(String[] args) {
        Problem_17 test =new Problem_17();
        int[] test1 = {10,5,2,7,8,7};
        int[] test2 = {1,3,-1,-3,5,3,6,7};
        int[] test3 = {1,5,4,3,2,1,0};

        System.out.println("should be [10,7,8,8] : " + Arrays.toString(test.getMaximumOfKWindow(test1, 3)));
        System.out.println("should be [3,3,5,5,6,7] : " + Arrays.toString(test.getMaximumOfKWindow(test2, 3)));
        System.out.println("should be : " + Arrays.toString(test.getMaximumOfKWindow(test3, 3)));

    }

    public int[] getMaximumOfKWindow(int[] nums, int k){
        if(nums.length == 0) return nums;

        int[] result = new int[nums.length - k + 1];
        int resultIdx = 0;
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            //remove every number smaller than current
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }

            //remove number which out of range k
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.pollFirst();

            deque.addLast(i);
            if(i >= k - 1) result[resultIdx++] = nums[deque.peekFirst()];
        }

        return result;

    }


}
