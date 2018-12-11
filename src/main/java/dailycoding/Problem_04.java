package dailycoding;

import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 *
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place.
 */
public class Problem_04 {

    public static void main(String[] args) {
        int[] smokeTest1 = {3,4,-1,1};
        int[] smokeTest2 = {1,2,0};
        int[] smokeTest3 = {-2,-3,0};
        int[] smokeTest4 = {-2,-3,0,1,2,3,4,5,6,7,8,9,11,1,22,3,4,5,6,5,7,8,9,2,2,2,2,2,2,3,4,5,6,7};
        int[] smokeTest5 = {};
        int[] smokeTest6 = {0};
        int[] smokeTest7 = {2345,243,5245,24,5243,524,1,2,6,6,234,6234,7,42437};

        System.out.println(findLowestPositiveMissingInteger(smokeTest1));
        System.out.println(findLowestPositiveMissingInteger(smokeTest2));
        System.out.println(findLowestPositiveMissingInteger(smokeTest3));
        System.out.println(findLowestPositiveMissingInteger(smokeTest4));
        System.out.println(findLowestPositiveMissingInteger(smokeTest5));
        System.out.println(findLowestPositiveMissingInteger(smokeTest6));
        System.out.println(findLowestPositiveMissingInteger(smokeTest7));


        Assert.isTrue(2 == findLowestPositiveMissingInteger(smokeTest1), "failed to return 2");
        Assert.isTrue(3 == findLowestPositiveMissingInteger(smokeTest2), "failed to return 3");
        Assert.isTrue(1 == findLowestPositiveMissingInteger(smokeTest3), "failed to return 1");
        Assert.isTrue(10 == findLowestPositiveMissingInteger(smokeTest4), "failed to return 10");
        Assert.isTrue(1 == findLowestPositiveMissingInteger(smokeTest5), "failed to return 1");
        Assert.isTrue(1 == findLowestPositiveMissingInteger(smokeTest6), "failed to return 1");
        Assert.isTrue(3 == findLowestPositiveMissingInteger(smokeTest7), "failed to return 3");


    }

    // o(n) approach
    private static int findLowestPositiveMissingInteger(int[] arr) {
        if(arr==null || arr.length==0) return 1;
        int len = arr.length;
        for(int i = 0; i < len; i++){
            int cur = arr[i];
            while(cur > 0 && cur <= len && cur != arr[cur - 1]){
                swap(arr, i, cur - 1);
            }
        }
        for(int i = 0; i < len; i ++){
            if(arr[i] != i + 1) return i + 1;
        }
        return len + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // O(n log n) approach
    private static int findLowestPositiveMissingInteger2(int[] arr){
        Arrays.sort(arr);
        int expect = 1;
        for(int i : arr){
            if(i == expect) expect++;
        }
        return expect;
    }
}
