package ourstudy.clrs.ch2;

/**
 * Created by jw on 2017-08-11.
 */
public class MergeSort {
    /**
     *
     * @param array
     * @param left left index of array
     * @param right right index of array
     */
    public void mergeSort(int[] array, int left, int right){
        //System.out.println(left + " , " + right);
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
        //System.out.println("array : " + Arrays.stream(array).boxed().collect(Collectors.toList()));
    }

    private void merge(int[] array, int left, int mid, int right) {
        //System.out.println(left + " , " + mid + " , " + right);
        int l = left;
        int r = mid + 1;

        int[] leftSub = new int[mid - left + 1];
        int[] rightSub = new int[right - (mid + 1) + 1];

        for(int i = 0; i < leftSub.length; i++){
            leftSub[i] = array[l + i];
        }
        for(int i = 0; i < rightSub.length; i++){
            rightSub[i] = array[r + i];
        }

        int i , j;
        i = j = 0;
        while(i < leftSub.length && j < rightSub.length){
            if(leftSub[i] >= rightSub[j]){
                array[l] = rightSub[j];
                j++;
            } else {
                array[l] = leftSub[i];
                i++;
            }
            l++;
        }

        for(; i < leftSub.length; i++, l++){
            array[l] = leftSub[i];
        }
        for(; j < rightSub.length; j++, l++){
            array[l] = rightSub[j];
        }
    }

}
