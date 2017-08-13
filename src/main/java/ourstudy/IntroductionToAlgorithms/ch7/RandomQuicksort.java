package ourstudy.IntroductionToAlgorithms.ch7;

/**
 * Created by jwlee1 on 2017. 8. 13..
 */
public class RandomQuicksort {
	Partitioner p;

	RandomQuicksort(Partitioner p){
		this.p = p;
	}

	public void randomQuicksort(int[] array, int left, int right){
		if(left < right){
			int pivot = p.randomPartition(array, left, right);
			randomQuicksort(array, left, pivot-1);
		}
	}
}
