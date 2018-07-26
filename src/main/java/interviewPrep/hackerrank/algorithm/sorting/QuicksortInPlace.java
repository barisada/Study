package interviewPrep.hackerrank.algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jwlee1 on 2017. 8. 14..
 */
public class QuicksortInPlace {
	private static List<String> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] array = IntStream.range(0, size).map(i -> sc.nextInt()).toArray();
		quicksort(array, 0, size -1);
		list.forEach(System.out::println);
	}

	private static void quicksort(int[] array, int left, int right) {
		if(left < right){
			int p = partition(array, left, right);
			list.add(Arrays.stream(array).boxed().map(String::valueOf).collect(Collectors.joining(" ")));
			quicksort(array, left, p - 1);
			quicksort(array, p + 1, right);
		}
	}

	private static int partition(int[] array, int left, int right) {
		int pivot = array[right];
		int i = left;
		for(; left < right; left++){
			if(array[left] <= pivot){
				swap(array, left, i);
				i++;
			}
		}
		swap(array, right, i);
		return i;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
