package hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jwlee1 on 2017. 8. 14..
 */
public class ClosestNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		IntStream.range(0, size).forEach(i -> arr[i] = sc.nextInt());

		quicksort(arr, 0, size -1);
		int[] sum = new int[size-1];
		IntStream.range(0, size - 1).forEach(i -> sum[i] = Math.abs(arr[i] - arr[i + 1]));

		//System.out.println("arr : " + Arrays.stream(arr).boxed().collect(Collectors.toList()));
		//System.out.println("sum : " + Arrays.stream(sum).boxed().collect(Collectors.toList()));

		int min = Arrays.stream(sum).min().getAsInt();
		List<Integer> minList= IntStream.range(0, sum.length).filter(i ->  sum[i] == min).boxed().collect(Collectors.toList());
		String result = minList.stream().map(i -> {
			String str = arr[i] + " ";
			str += arr[i + 1] + " ";
			return str;
		}).collect(Collectors.joining());

		System.out.println(result);
	}

	private static void quicksort(int[] arr, int left , int right) {
		if(left < right){
			int p = partition(arr, left, right);
			quicksort(arr, left, p - 1);
			quicksort(arr, p + 1, right);
		}
	}

	private static int partition(int[] arr, int left, int right) {
		int p = arr[right];
		int i = left;

		for(; left < right; left++){
			if(arr[left] <= p){
				swap(arr, left , i);
				i++;
			}
		}
		swap(arr, right, i);
		return i;
	}

	private static void swap(int[] arr, int i , int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
