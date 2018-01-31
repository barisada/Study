package books.clrs.ch6;

/**
 * Created by jw on 2017-08-02.
 */
public class PriorityQueueClient {
    public static void main(String[] args) {
        Integer[] array = {7,9,3,2,4,1,16,14,10,8};
        MinPriorityQueue pq = new MinPriorityQueue(array);
        System.out.println(pq);
        while(true){
            int max = pq.removeMin();
            if(max == 0) break;
            System.out.println(max);
        }
        System.out.println(pq);
    }
}
