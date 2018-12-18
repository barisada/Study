package dailycoding.leetcode;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * leetcode #34
 */
public class SearchScan {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int[] arr2 = {};
        int[] arr3 = {2,2};
        SearchScan test = new SearchScan();
        System.out.println(Arrays.toString(test.searchRange(arr, 8)));
        System.out.println(Arrays.toString(test.searchRange(arr, 6)));
        System.out.println(Arrays.toString(test.searchRange(arr2, 6)));
        System.out.println(Arrays.toString(test.searchRange(arr3, 1)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums.length == 0) return result;
        int lo = 0, hi = nums.length - 1;
        while(lo  < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target){
                result[0] = mid;
                hi = mid - 1;
            } else if( nums[mid] > target){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if(lo < nums.length && nums[lo] == target) result[0] = lo;

        lo = 0; hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target){
                result[1] = mid;
                lo = mid + 1;
            } else if( nums[mid] > target){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if(hi >= 0 && nums[hi] == target) result[1] = hi;
        return result;
    }
}
