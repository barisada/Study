package internet_lecture.alg_pknu_ac_kr.lecture._03_sort;

import java.util.Arrays;

public class Sort_02_Merge_Sort {
    public static void main(String[] args) {
        int[] data = {2,5,1,4,3};
        mergeSort(data);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 배열을 반으로(왼쪽, 오른쪽) 리컬시브하게 나눠서
     * 한개만 남으면 정렬된 것으로 한다.
     * 정렬된 왼쪽, 오른쪽 배열을
     * 정렬순으로 만든다.
     * 위를 계속 반복한다.
     * @param data
     */
    public static void mergeSort(int[] data) {
        divide(data, 0, data.length -1);
    }

    private static void divide(int[] data, int begin, int end) {
        if(begin < end){
            int mid = (begin + end) / 2;
            divide(data, begin, mid);
            divide(data, mid + 1, end);
            merge(data, begin, end, mid);
        }
    }

    private static void merge(int[] data, int begin, int end, int mid) {
        int leftBegin = begin;
        int rightBegin = mid + 1;
        int pos = begin;
        int[] temp = new int[data.length];

        //왼쪽 배열과 오른쪽 배열중 작은 순으로 temp에 복사하기
        while(leftBegin <= mid && rightBegin <= end){
            if(data[leftBegin] < data[rightBegin]){
                temp[pos++] = data[leftBegin++];
            } else {
                temp[pos++] = data[rightBegin++];
            }
        }

        //왼쪽배열 or 오른쪽배열중에서 남은 값은 정렬된 temp배열 뒤에다 삽입.
        for(int i = pos; i <= end; i++){
            if(leftBegin > mid){
                temp[i] = data[rightBegin++];
            } else {
                temp[i] = data[leftBegin++];
            }
        }

        //정렬된 temp값을 data값에 복사
        for(int i = begin; i <=end; i++){
            data[i] = temp[i];
        }
    }
}
