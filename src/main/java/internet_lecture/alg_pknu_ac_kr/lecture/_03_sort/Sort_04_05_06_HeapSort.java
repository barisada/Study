package internet_lecture.alg_pknu_ac_kr.lecture._03_sort;

import java.util.Arrays;

public class Sort_04_05_06_HeapSort {
    public static void main(String[] args) {
        int[] arr = {2,8,6,1,10,15,3,12,11};

        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int length = arr.length;
        //자식이 있는 노드중 가장 마지막 노드 부터 시작.
        // Build heap (rearrange array)
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(arr, length, i);
        //System.out.println(Arrays.toString(arr));

        while(length > 0){
            int temp = arr[length - 1];
            arr[length - 1] = arr[0];
            arr[0] = temp;
            heapify(arr, --length, 0);
        }
    }

    private static void heapify(int arr[], int length, int i)
    {
        int node = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < length && arr[l] > arr[node])
            node = l;

        // If right child is larger than largest so far
        if (r < length && arr[r] > arr[node])
            node = r;

        // If largest is not root
        if (node != i)
        {
            int swap = arr[i];
            arr[i] = arr[node];
            arr[node] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, length, node);
        }
    }
}
