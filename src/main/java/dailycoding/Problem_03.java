package dailycoding;


import java.util.Arrays;

/**
 * Given an array of integers, return a new array such that each element
 * at index i of the new array is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 * A.K.A Leetcode #238.
 */
public class Problem_03 {
    public static void main(String[] args) {
        int[] smokeTest1 = {1,2,3,4,5};
        int[] smokeTest2 = {3,2,1};

        System.out.println("smoke test 1 :" + Arrays.toString(productArrayExceptSelf(smokeTest1)));
        System.out.println("smoke test 2 : " + Arrays.toString(productArrayExceptSelf(smokeTest2)));
    }

    private static int[] productArrayExceptSelf(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        result[0] = 1;
        for(int i = 1; i < len;i++){
            result[i] = result[i - 1] * arr[i -1];
        }

        int multiplier = 1;
        for(int i = len - 1; i >=0; i--){
            result[i] *= multiplier;
            multiplier *= arr[i];
        }

        return result;
    }

}
