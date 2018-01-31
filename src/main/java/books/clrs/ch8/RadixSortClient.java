package books.clrs.ch8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jwlee1 on 2017. 8. 7..
 */
public class RadixSortClient {
	public static void main(String[] args) {
		int[] array = {329,457,657,839,436,720,355};
		RadixSort rs = new RadixSort();
		int[] sorted = rs.sort(array);
		List<Integer> list = Arrays.stream(sorted).boxed().collect(Collectors.toList());
		System.out.println(list);

	}
}
