package interviewPrep.hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jwlee1 on 2017. 8. 14..
 */
public class Quicksort1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] array = new int[size];
		IntStream.range(0, size).forEach(i -> array[i] = sc.nextInt());

		partition(array, 0, size - 1);
		String result = Arrays.stream(array).boxed().map(String::valueOf).collect(Collectors.joining(" "));
		System.out.println(result);
	}

	private static void partition(int[] array, int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;

		int pivot = array[right];
		int i = left;

		for(; left < right; left++){
			if(array[left] <= pivot){
				temp = array[left];
				array[left] = array[i];
				array[i] = temp;
				i++;
			}
		}
		temp = array[right];
		array[right] = array[i];
		array[i] = temp;
	}
}
