package ourstudy.clrs.ch7;

/**
 * Created by jwlee1 on 2017. 8. 13..
 */
public class Quicksort {
	Partitioner partitioner;

	public Quicksort(Partitioner p){
		this.partitioner = p;
	}

	public void quicksort(int[] array, int left, int right){
		if(left < right) {
			int pivot = partitioner.partition(array, left, right);
			//System.out.println(left + ", " + right);
			//System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));
			//System.out.println("pivot : " + pivot);
			quicksort(array, left, pivot - 1);
			quicksort(array, pivot + 1, right);
		}
	}
}
