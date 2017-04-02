package ch04.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by 2017. 3. 27..
 */
public class MergeSort {

	public static void main(String...args){
		int[] arr = {10,9,2,6,7,8,1,3,4,5,15,14,13,11,12};
		mergesort(arr, 0, arr.length -1);
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
	}

	public static void mergesort(int[] arr, int left, int right) {

		if(left < right) {
			int mid = (left + right) / 2;

			mergesort(arr, left, mid);
			mergesort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int i = left;
		int j = mid+1;

		int[] temp = new int [right - left + 1];
		int idx = 0;
		for(; idx < temp.length && i <=mid && j<=right ;idx++){
			if(arr[i] > arr[j]) {
				temp[idx] = arr[j];
				j++;
			} else {
				temp[idx] = arr[i];
				i++;
			}
		}

		for(; i <= mid; i++){
			temp[idx] = arr[i];
			idx++;
		}

		for(; j <=right; j++){
			temp[idx] = arr[j];
			idx++;
		}

		for(int val : temp){
			arr[left] = val;
			left++;
		}


	}

}
