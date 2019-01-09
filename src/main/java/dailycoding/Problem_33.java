package dailycoding;

import java.util.*;

/**
 * Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.
 *
 * Recall that the median of an even-numbered list is the average of the two middle numbers.
 *
 * For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
 *
 * 2
 * 1.5
 * 2
 * 3.5
 * 2
 * 2
 * 2
 *
 * leetcode #295. Find Median from Data Stream
 */
public class Problem_33 {
    public static void main(String[] args) {
        Problem_33 test = new Problem_33();
        MedianFinder mf = test.createMedianFinder();
        List<Integer> list = Arrays.asList(2,1,5,7,2,0,5);
        list.forEach(i -> System.out.println(mf.add(i).getMedian()));
    }

    public MedianFinder createMedianFinder(){
        return new MedianFinder();
    }

    class MedianFinder{
        Queue<Integer> min = new PriorityQueue<>();;
        Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        public MedianFinder add(int num){
            min.add(num);
            max.add(min.poll());
            if(max.size() > min.size()){
                min.add(max.poll());
            }
            return this;
        }

        public double getMedian(){
            if(min.size() == max.size()) return (min.peek() + max.peek()) / 2.0;
            return min.peek();
        }

    }
}
