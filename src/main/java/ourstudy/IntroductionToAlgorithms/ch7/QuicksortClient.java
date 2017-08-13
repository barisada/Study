package ourstudy.IntroductionToAlgorithms.ch7;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by jwlee1 on 2017. 8. 13..
 */
public class QuicksortClient {

	public static void main(String[] args) {
		Partitioner p = new DefaultPartitioner();
		Quicksort quicksort = new Quicksort(p);

		int[] array = {2,8,7,1,3,5,6,4};
		quicksort.quicksort(array, 0, array.length-1);
		System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()) + " quicksort");

		int[] array2 = {8,7,6,5,4,3,2,1};
		RandomQuicksort randomQuicksort = new RandomQuicksort(p);
		randomQuicksort.randomQuicksort(array2, 0, array2.length-1);
		System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()) + " rand quicksort");
	}
}
