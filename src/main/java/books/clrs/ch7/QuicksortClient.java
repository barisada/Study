package books.clrs.ch7;

import org.springframework.util.StopWatch;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by jwlee1 on 2017. 8. 13..
 */
public class QuicksortClient {

	public static void main(String[] args) {
		Partitioner p = new LomutoPartitioner();
		Quicksort quicksort = new Quicksort(p);

		int size = 10_000;
		int[] array = new int[size];
		int[] array2 = new int[size];
		IntStream.range(0, size).forEach(i ->{
			int rand = new Random().nextInt(size);
			array[size -1 - i] = rand;
			array2[size -1 - i] = i;
		});
		StopWatch sw = new StopWatch("quick sort timer");
		sw.start("default");
		quicksort.quicksort(array, 0, array.length-1);
		sw.stop();
		//System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()) + " quicksort : " + sw.getLastTaskTimeMillis());
		System.out.println("default quicksort : " + sw.getLastTaskTimeMillis());


		RandomQuicksort randomQuicksort = new RandomQuicksort(p);
		sw.start("random quicksort");
		randomQuicksort.randomQuicksort(array2, 0, array2.length-1);
		sw.stop();
		//System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()) + " rand quicksort : " + sw.getLastTaskTimeMillis());
		System.out.println("random quicksort : " + sw.getLastTaskTimeMillis());

		System.out.println(sw.prettyPrint());
	}
}
