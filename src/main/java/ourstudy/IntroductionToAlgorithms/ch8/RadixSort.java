package ourstudy.IntroductionToAlgorithms.ch8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jwlee1 on 2017. 8. 7..
 */
public class RadixSort {

	public int[] sort(int[] array){
		int k = String.valueOf(Arrays.stream(array).max().getAsInt()).length();
		Queue q = new LinkedList<>();

		for(int i = 0, exp = 1; i < k; i++, exp *= 10) {
			int[] count = new int[10];
			for (int j : array) {
				count[j / exp % 10]++;
			}
			//count배열을 누적카운트배열로 바꿈.
			IntStream.range(1, count.length).forEach(j -> {
				count[j] = count[j - 1] + count[j];
			});
			System.out.println("array : " + Arrays.stream(array).boxed().collect(Collectors.toList()));
			System.out.println("count : " + Arrays.stream(count).boxed().collect(Collectors.toList()));

			int[] sorted = new int[array.length];
			//TODO // FIXME: 2017. 8. 7. 
			for (int j = array.length - 1; j >=0; j--) {
				int pos = array[j] / exp % 10;
				sorted[count[pos] - 1] = j;
				count[pos]--;
			}
			array = sorted;
		}

		return array;
	}
}
