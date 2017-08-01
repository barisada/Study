package ourstudy.IntroductionToAlgorithms.ch6;

/**
 * Created by jw on 2017-08-01.
 */
public interface PriorityQueue {

    void insert(int[] array, int x);
    void max(int[] array);
    void removeMax(int[] array);
    void replaceValue(int[] array, int older, int newer);
}
