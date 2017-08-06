package ourstudy.IntroductionToAlgorithms.ch4;

import java.util.stream.IntStream;

/**
 * Created by jwlee1 on 2017. 8. 6..
 */
public class MaximumSubarrayClient {
	public static void main(String[] args) {
		int[] arr = {-1,2,3,4, -5, 10};
		MaximumSubarray ms = new MaximumSubarray();
		MaximumSubarrayIndices max = ms.findMaxSubArray(arr, 0, arr.length -1);
		System.out.println(max);
		System.out.println(IntStream.rangeClosed(max.getStart(), max.getEnd()).map(i -> arr[i]).sum());

	}
}
