package hackerrank.algorithm.DynamicProgramming;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by jw on 2017-08-06.
 */
public class TheMaximumSubarray {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        IntStream.range(0, size).forEach(round -> {
            int length = sc.nextInt();
            int[] arr = new int[length];
            IntStream.range(0, length).forEach(i -> arr[i] = sc.nextInt());
            MaximumSubarray ms = new MaximumSubarray();
            Indices max = ms.findMaxSubArray(arr, 0, arr.length -1);
            int coutigunousMxSum = IntStream.rangeClosed(max.getStart(), max.getEnd()).map(i -> arr[i]).sum();
            int nonCoutigunousMxSum = IntStream.range(0, length).filter(i -> arr[i] > 0).count() == 0L
                    ? IntStream.range(0, length).map(i -> arr[i]).max().getAsInt() : IntStream.range(0, length).filter(i -> arr[i] > 0).map(i -> arr[i]).sum();
            System.out.println(coutigunousMxSum + " " + nonCoutigunousMxSum);
        });
    }
}
class MaximumSubarray {

    /**
     * precondition : array.length >= 1
     * @param array
     * @param left
     * @param right
     * @return
     */
    public Indices findMaxSubArray(int[] array, int left, int right){
        if(left == right){
            return new Indices(left, right);
        } else {
            int mid= (left + right) / 2;
            Indices leftMax = findMaxSubArray(array, left, mid);
            Indices rightMax = findMaxSubArray(array, mid + 1, right);
            Indices crossMax = findCrossMaxSubArray(array, left, mid, right);

            return getMaxIndices(array, leftMax, rightMax, crossMax);
        }
    }


    private Indices findCrossMaxSubArray(int[] array, int left, int mid, int right) {
        int leftMaxSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;
        for(int i = mid; i >= left; i--){
            sum = sum + array[i];
            if(sum > leftMaxSum){
                leftMaxSum = sum;
                maxLeft = i;
            }
        }
        Indices maxL = new Indices(maxLeft, mid);

        int rightMaxSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = mid + 1;
        for(int i = mid+1; i <=right; i++){
            sum = sum + array[i];
            if(sum > rightMaxSum){
                rightMaxSum = sum;
                maxRight = i;
            }
        }
        Indices maxR = new Indices(mid+1, maxRight);
        Indices maxBoth = maxL.add(maxR);

        return maxBoth;

    }

    private Indices getMaxIndices(int[] array, Indices maxL, Indices maxR, Indices maxBoth) {
        if(maxL.sum(array) >= maxR.sum(array) && maxL.sum(array) >= maxBoth.sum(array)){
            return maxL;
        } else if(maxR.sum(array) >= maxL.sum(array) && maxR.sum(array) >= maxBoth.sum(array)){
            return maxR;
        } else {
            return maxBoth;
        }
    }
}

class Indices{
    int start;
    int end;

    public Indices(){
        start = 0;
        end = 0;
    }
    public Indices(int s, int e){
        this.start = s;
        this.end = e;
    }


    public int sum(int[] array){
        return IntStream.rangeClosed(start, end).map(i -> array[i]).sum();
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Indices add(Indices other){
        int s = this.start <= other.start ? this.start : other.start;
        int e = this.end >= other.end ? this.end : other.end;
        return new Indices(s, e);
    }

    @Override public String toString() {
        return "MaximumSubarrayIndices{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
