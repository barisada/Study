package ch04.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {
	
	
	public static void main(String...args){
		int[] arr = {2,6,7,8,1,3,4,5};
		quicksort(arr, 0, arr.length-1);
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
	}

	private static void quicksort(int[] arr, int i, int j) {
		if(i < j){
			int pivot = arr[i];
			int left = i;
			int right = j;
			
			while(left < right){
				while(arr[right] > pivot) right--;
				while(left < right && arr[left] <= pivot) left++;
				
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
			
			arr[i] = arr[right];
			arr[right] = pivot;
			
			quicksort(arr, i, right - 1);
			quicksort(arr, right + 1, j);
			
		}
	}
}
