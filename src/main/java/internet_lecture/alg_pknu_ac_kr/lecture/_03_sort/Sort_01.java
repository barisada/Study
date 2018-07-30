package internet_lecture.alg_pknu_ac_kr.lecture._03_sort;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Random;

public class Sort_01 {
    public static void main(String[] args) {
        Random rand = new Random();
        int size = 10_000;
        int[] data = new int[size];
        for(int i = 0; i < size; i++){
            data[i] = rand.nextInt(size);
        }

        StopWatch sw = new StopWatch("sorting performance");

        int[] data1 = Arrays.copyOf(data, size);
        sw.start("selection sort");
        selectionSort(data1);
        System.out.println("selection sort : " + Arrays.toString(data1));
        sw.stop();

        int[] data2 = Arrays.copyOf(data, size);
        sw.start("bubble sort");
        bubbleSort(data2);
        System.out.println("bubble sort    : " + Arrays.toString(data2));
        sw.stop();

        int[] data3 = Arrays.copyOf(data, size);
        sw.start("insertion sort");
        insertionSort(data3);
        System.out.println("insertion sort : " + Arrays.toString(data3));
        sw.stop();

        int[] data4 = Arrays.copyOf(data, size);
        sw.start("merge sort");
        Sort_02_Merge_Sort.mergeSort(data4);
        System.out.println("merge sort     : " + Arrays.toString(data4));
        sw.stop();

        int[] data5 = Arrays.copyOf(data, size);
        sw.start("quick sort");
        Sort_03_QuickSort.quickSort(data5);
        System.out.println("quick sort     : " + Arrays.toString(data5));
        sw.stop();

        System.out.println(sw.prettyPrint());
    }

    /**
     * selection sort
     * 가장 큰 값을 배열 맨 뒤로 보냄.
     * 그담 큰값음 맨뒤 -1보냄..
     * 반복..
     * 끗.
     * @param data
     */
    private static void selectionSort

    (int[] data) {
        for(int i = data.length - 1; i >= 0; i--){
            int pos = 0;
            for(int j = 1; j <= i; j++){
                if( data[pos] < data[j]) pos = j;
            }
            int temp = data[pos];
            data[pos] = data[i];
            data[i] = temp;
        }
    }

    /**
     * 처음 값과 그다음 값을 비교해서 큰것을 뒤로 둔다.
     * 끝까지해서 마지막자리에 젤 큰값을 넣는다.
     * 다시 그짓을 반복함.
     * 끗.
     * @param data
     */
    private static void bubbleSort(int[] data) {
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data.length - 1 - i; j ++){
                if(data[j] > data[j + 1]){
                    int temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    /**
     * 첫 자리는 정렬되어있다고 생각함.
     * 두번쨰꺼가 첫번째보다 뒤로갈지 앞으로갈지 정함.
     * 1,2번은 정렬되었고 3번이 어디로갈지정함.
     * 그럼 1,2,3 번 정렬 완성.
     * 그리고 배열끝까지 반복 하면 정렬.
     * @param data
     */
    private static void insertionSort(int[] data) {
        for(int i = 1; i < data.length; i++){
            for(int j = i - 1; j >= 0 && data[j] > data[j + 1]; j--){
                int temp = data[j];
                data[j] = data[j + 1];
                data[j + 1] = temp;
            }
        }
    }

}
