package ch04.search;

import java.util.Arrays;
import java.util.stream.Collectors;

import static ch04.sort.QuickSort.quicksort;

/**
 * Created by jwlee1 on 2017. 3. 27..
 */
public class BinarySearch {

	public static void main(String...args){
		int[] arr = {2,6,7,100000001,8,1,3,4,5,100000000};
		quicksort(arr, 0, arr.length-1);
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		int target = 100000000;
		boolean exist = binarySearch(arr, target, 0, arr.length - 1);
		System.out.println("target(" + target + ") : " + exist);
	}

	private static boolean binarySearch(int[] arr, int target, int left, int right) {
		if(left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == target) {
				return true;
			} else if (arr[mid] > target) {
				return binarySearch(arr, target, left, mid - 1);
			} else {
				return binarySearch(arr, target, mid + 1, right);
			}
		} else {
			return false;
		}

	}

}
