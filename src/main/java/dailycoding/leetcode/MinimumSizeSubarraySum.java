package dailycoding.leetcode;

/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *
 * leatcode #209
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        int[] arr = {2,3,1,2,4,3};
        int[] arr2 = {};
        int[] arr3 = {1};
        int[] arr4 = {234,62345,2435,6,3245,2345,243,324,7234,6324,523,4523,45,326,423,327,234,5324,536,2345,1,2,4};
        int[] arr5 = {1,2,3,4,5};
        System.out.println("should be 2 : " + test.minSubArrayLen(7, arr));
        System.out.println("should be 0 : " + test.minSubArrayLen(0, arr2));
        System.out.println("should be 0 : " + test.minSubArrayLen(0, arr3));
        System.out.println("should be 1 : " + test.minSubArrayLen(1, arr3));
        System.out.println("should be 1 : " + test.minSubArrayLen(6, arr4));
        System.out.println("should be 1 : " + test.minSubArrayLen(3, arr4));
        System.out.println("should be 0 : " + test.minSubArrayLen(32345234, arr4));
        System.out.println("should be 3 : " + test.minSubArrayLen(11, arr5));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0 || s == 0) return 0;
        int lo = 0, hi = 0, min = Integer.MAX_VALUE;
        while(hi < nums.length){
            s -= nums[hi++];
            while(s <= 0){
                min = Math.min(min, (hi - lo));
                s += nums[lo++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
