package dailycoding.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 *
 */
public class MaxiumSubarray {
    public static void main(String[] args) {
        MaxiumSubarray test = new MaxiumSubarray();

        int[] test1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("should be 6 : " + test.maxSubArray(test1));
        System.out.println("should be 6 : " + test.maxSubArrayAsList(test1));

    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;

        int max = nums[0];
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++){
            prev = prev >= 0 ? prev + nums[i] : nums[i];
            max = Math.max(max, prev);
        }
        return max;
    }

    public List<Integer> maxSubArrayAsList(int[] nums){
        if(nums.length == 0) return Collections.emptyList();

        int max = nums[0];
        int prev = nums[0];
        int start = 0, end = 0;
        List<Integer> result = null;
        for(int i = 1; i < nums.length; i++){
            if(prev >= 0){
                prev += nums[i];
                end = i;
            } else {
                prev = nums[i];
                start = i;
                end = i;
            }
            prev = prev >= 0 ? prev + nums[i] : nums[i];
            if(prev > max){
                max = prev;
                result = new ArrayList<>();
                for(int j = start; j <= end; j++){
                    result.add(nums[j]);
                }
            }
        }
        return result;
    }
}
