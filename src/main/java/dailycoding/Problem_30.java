package dailycoding;

/**
 * You are given an array of non-negative integers that represents a two-dimensional elevation map
 * where each element is unit-width wall and the integer is the height.
 * Suppose it will rain and all spots between two walls get filled up.
 *
 * Compute how many units of water remain trapped on the map in O(N) time and O(1) space.
 *
 * For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.
 *
 * Given the input [3, 0, 1, 3, 0, 5],
 * we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index
 * (we cannot hold 5 since it would run off to the left),
 * so we can trap 8 units of water.
 *
 */
public class Problem_30 {

    public static void main(String[] args) {
        Problem_30 test = new Problem_30();
        System.out.println("should be 8 : " + test.trap(new int[]{3,0,1,3,0,5}));
        System.out.println("should be 6 : " + test.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public int trap(int[] arr) {
        int lo = 0, hi = arr.length - 1, water = 0, minHeight = 0;
        while(lo <= hi){
            minHeight = Math.max(minHeight, Math.min(arr[lo], arr[hi]));
            if(arr[lo] <= arr[hi]){
                water += minHeight - arr[lo++];
            } else {
                water += minHeight - arr[hi--];
            }
        }
        return water;
    }
}
