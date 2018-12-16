package dailycoding;

/**
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
 *
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 *
 * Follow-up: Can you do this in O(N) time and constant space?
 *
 * similar : leetcode #198. House Robber
 */
public class Problem_09 {
    public static void main(String[] args) {
        Problem_09 test = new Problem_09();
        int[] test1 = {2,4,6,2,5};
        int[] test2 = {5,1,1,5};
        int[] test3 = {5,1,1,4,3,-5,-6,7,20,10};
        int[] test4 = {5, 5, 10, 100, 10, 5};

        System.out.println("should be 13 : " + test.findSum(test1));
        System.out.println("should be 10 : " + test.findSum(test2));
        System.out.println("should be 29 : " + test.findSum(test3));
        System.out.println("should be 110 : " + test.findSum(test4));
    }

    private int findSum(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        int curMax = nums[0];
        int lastest = nums[1];
        for(int i = 2 ; i < len; i++){
            int cur = nums[i] >= 0 ? nums[i] + curMax : curMax;
            curMax = Math.max(curMax, lastest);
            lastest = cur;
        }
        return Math.max(curMax, lastest);
    }
}
