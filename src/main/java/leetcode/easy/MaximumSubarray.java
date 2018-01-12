package leetcode.easy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = nums[0];
        for(int i = 1; i < nums.length; i++){
            cur = Math.max(nums[i] + cur, nums[i]);
            max = Math.max(cur, max);
        }
        return max;
    }
}
