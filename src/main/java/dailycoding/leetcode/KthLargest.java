package dailycoding.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargest {

    public static void main(String[] args) {
        KthLargest test = new KthLargest();

        int[] test1 = {3,2,1,5,6,4};
        int[] test2 = {3,2,3,1,2,4,5,5,6};
        int[] test3 = {2234,5234,523,523,1,1,2,3,4,2,5,6,6,16,612,6123,7,43,8453,9,4756,90580,23,123,123,123,4123,5,7};

        System.out.println(test.findKthLargest(test1,2));
        System.out.println(test.findKthLargest(test2,4));
        System.out.println(test.findKthLargest(test3,6));

        System.out.println("-=-=============================");

        System.out.println(test.findKthLargestUsingSort(test1,2));
        System.out.println(test.findKthLargestUsingSort(test2,4));
        System.out.println(test.findKthLargestUsingSort(test3,6));
    }

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i : nums){
            queue.offer(i);
            if(queue.size() > k) queue.poll();
        }
        return queue.peek();
    }

    public int findKthLargestUsingSort(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length- k];
    }
}
