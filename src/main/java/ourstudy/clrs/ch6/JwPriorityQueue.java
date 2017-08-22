package ourstudy.clrs.ch6;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jw on 2017-08-01.
 */
public class JwPriorityQueue {
    int[] heapArray;


    public JwPriorityQueue(int size){
        heapArray = new int[size];
        for(int i = 0; i < size; i++){
            heapArray[i] = 0;
        }
    }

    public JwPriorityQueue(int[] array){
        this.heapArray = array;
        buildHeap();
    }

    private void buildHeap() {
        int n = heapArray.length;
        for(int i = (n / 2) - 1; i >= 0; i--){
            heapify(i);
        }
    }

    private void heapify(int i) {
        i++;
        int parentPos = i - 1;
        int leftPos = (i * 2)  - 1;
        int rightPos = (i * 2 );
        boolean hasRightPos = (i * 2) < heapArray.length;

        if(i <= (heapArray.length / 2)) {
            int parent = heapArray[parentPos];
            int left = heapArray[leftPos];
            int right = hasRightPos ? heapArray[rightPos] : -1;

            if (left > parent || (hasRightPos && right > parent)) {
                if(!hasRightPos || left > right){
                    heapArray[parentPos] = left;
                    heapArray[leftPos] = parent;
                    heapify(leftPos);
                } else {
                    heapArray[parentPos] = right;
                    heapArray[rightPos] = parent;
                    heapify(rightPos);
                }
            }
        }
    }

    public void insert(int x)
    {
        int[] temp = new int[heapArray.length + 1];
        IntStream.range(0, heapArray.length).forEach(i -> temp[i] = heapArray[i]);
        temp[heapArray.length] = temp[0];
        temp[0] = x;
        heapArray = temp;
        heapify(0);
    }

    public int max() {
        return heapArray[0];
    }

    public int removeMax() {
        int max = 0;
        if(heapArray.length == 0) {
            return max;
        } else if(heapArray.length == 1){
            max = heapArray[0];
            heapArray = new int[0];
            return max;
        } else {
            max = heapArray[0];
            int[] temp = new int[heapArray.length - 1];
            temp[0] = heapArray[heapArray.length - 1];
            IntStream.range(1, temp.length).forEach(i -> temp[i] = heapArray[i]);
            heapArray = temp;
            heapify(0);
            return max;
        }
    }

    public void replaceValue(int older, int newer) {

    }

    @Override
    public String toString(){
        return Arrays.stream(heapArray).boxed().map(String::valueOf).collect(Collectors.joining(","));
    }
}
