package java_interview_exposed.ch04.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {


    public static void main(String...args){
        int[] arr = {1,2,5,6,3,4};
        quicksort(arr, 0, arr.length-1);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public static void quicksort(int[] arr, int i, int j) {
        if(i < j){
            int pivot = arr[i];
            int left = i;
            int right = j;

            while(left < right){
                while(arr[right] > pivot) right--;
                while(left < right && arr[left] <= pivot) left++;

                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                System.out.println("inside loop : "  + Arrays.stream(arr).boxed().collect(Collectors.toList()));
            }

            arr[i] = arr[right];
            arr[right] = pivot;

            System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));

            quicksort(arr, i, right - 1);
            quicksort(arr, right + 1, j);

        }
    }
}
