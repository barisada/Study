package ourstudy.IntroductionToAlgorithms.ch6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jw on 2017-08-03.
 */
public class MinPriorityQueue {
    List<Integer> heap;

    public MinPriorityQueue(){
        heap = new ArrayList<>();
    }

    public MinPriorityQueue(List<Integer> list){
        heap = list;
        buildHeap();
    }
    public MinPriorityQueue(Integer[] array){
        heap = new ArrayList<>(Arrays.asList(array));
        buildHeap();
    }

    private void buildHeap() {
        int n = heap.size();
        for(int i = (n / 2) - 1; i >= 0; i--){
            heapify(i);
        }
    }

    private void heapify(int i) {
        i++;
        int parentPos = i - 1;
        int leftPos = (i * 2)  - 1;
        int rightPos = (i * 2 );
        boolean hasRightPos = (i * 2) < heap.size();

        if(i <= (heap.size() / 2)) {
            int parent = heap.get(parentPos);
            int left = heap.get(leftPos);
            int right = hasRightPos ? heap.get(rightPos) : -1;

            if (left < parent || (hasRightPos && right < parent)) {
                if(!hasRightPos || left < right){
                    heap.set(parentPos, left);
                    heap.set(leftPos, parent);
                    heapify(leftPos);
                } else {
                    heap.set(parentPos, right);
                    heap.set(rightPos, parent);
                    heapify(rightPos);
                }
            }
        }
    }


    public void insert(int i){
        if(heap.size() == 0){
            heap.add(i);
        } else {
            heap.add(i);
            int temp = heap.get((heap.size() - 1) / 2);
            heap.set((heap.size() - 1) / 2, i);
            heap.set(heap.size() - 1, temp);
            heapify(heap.size() - 1 / 2);
        }

    }
    public int min(){
        return heap.get(0);
    }

    public int removeMin(){
        if(heap.size() == 0){
            return 0;
        } else if(heap.size() == 1){
            int min  = heap.get(0);
            heap.remove(0);
            return min;
        } else {
            int min = heap.get(0);
            int last = heap.get(heap.size() - 1);
            heap.set(0, last);
            heap.remove(heap.size() -1);
            heapify(0);
            return min;
        }
    }

    public void remove(int i){
        if(heap.contains(i)){
            heap.remove(heap.indexOf(i));
            buildHeap();
        } else {
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public String toString(){
        return heap.toString();
    }
}
