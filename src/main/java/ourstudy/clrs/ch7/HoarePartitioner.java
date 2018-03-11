package ourstudy.clrs.ch7;

/**
 * Created by jw on 2017-08-14.
 */
public class HoarePartitioner implements Partitioner{
    @Override
    public int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left;
        int j = array[right];

        while(true){
            while(array[j] <= pivot) j--;
            while(array[i] >= pivot) i++;
            if(i < j) swap(array, i, j);
            else return j;
        }
    }

    @Override
    public int randomPartition(int[] array, int left, int right) {
        return 0;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
