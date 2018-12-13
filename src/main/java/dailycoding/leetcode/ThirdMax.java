package dailycoding.leetcode;

/**
 * 414
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMax {
    public static void main(String[] args) {
        ThirdMax test = new ThirdMax();
        int[] test1 = {3,2,1};
        int[] test2 = {2,1};
        int[] test3 = {2,2,3,1};

        System.out.println("test 1 :  " + test.thirdMax(test1));
        System.out.println("test 2 : " + test.thirdMax(test2));
        System.out.println("test 3 : " + test.thirdMax(test3));
    }

    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if(first < cur){
                third = second;
                second = first;
                first = cur;
            } else if(first > cur && second < cur){
                third = second;
                second = cur;
            } else if(second > cur && third < cur){
                third = cur;
            }
        }
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}
