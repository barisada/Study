package ourstudy.IntroductionToAlgorithms.ch7;

import java.util.Random;

/**
 * Created by jwlee1 on 2017. 8. 13..
 */
public class DefaultPartitioner implements Partitioner{
	@Override public int partition(int[] array, int left, int right) {
		int index = left;
		int pivot = array[right];

		for(; left < right;left++){
			if(array[left] <= pivot) {
				swap(array, index, left);
				index++;
			}
		}
		swap(array, right, index);

		return index;
	}

	@Override
	public int randomPartition(int[] array, int left, int right){
		int index = left;
		int rand = new Random().nextInt(right);
		swap(array, rand, right);
		int pivot = array[right];

		for(; left < right;left++){
			if(array[left] <= pivot) {
				swap(array, index, left);
				index++;
			}
		}
		swap(array, right, index);

		return index;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
