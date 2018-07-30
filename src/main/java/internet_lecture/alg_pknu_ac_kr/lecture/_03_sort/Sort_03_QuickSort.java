package internet_lecture.alg_pknu_ac_kr.lecture._03_sort;

import java.util.Arrays;

public class Sort_03_QuickSort {

    public static void main(String[] args) {
        int[] data = {8,5,2,3,1,4,7,6,9,10,11,12,13};

        quickSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private static void quickSort(int[] data, int begin, int end) {
        if(begin < end){
            int pivot = partition(data, begin, end);
            quickSort(data, begin, pivot -1);
            quickSort(data, pivot + 1,  end);

        }
    }

    private static int partition(int[] data, int begin, int end) {
        int pivot = data[end];
        int beforePivot = begin - 1;

        for(int i = begin; i < end; i++){
            if(data[i] < pivot){
                beforePivot++;
                int temp = data[beforePivot];
                data[beforePivot] = data[i];
                data[i] = temp;
            }
        }
        int temp = data[beforePivot + 1];
        data[beforePivot + 1] = data[end];
        data[end] = temp;

        return beforePivot + 1;
    }
}
