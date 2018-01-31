package books.clrs.ch7;

/**
 * Created by jwlee1 on 2017. 8. 13..
 */
public interface Partitioner {

	public int partition(int[] array, int left, int right);
	public int randomPartition(int[] array, int left, int right);
}
