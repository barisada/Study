package dailycoding;

import java.util.ArrayList;
import java.util.List;

/**
 * You run an e-commerce website and want to record the last N order ids in a log.
 * Implement a data structure to accomplish this, with the following API:
 *
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 * You should be as efficient with time and space as possible.
 */
public class Problem_16 {

    public static void main(String[] args) {
        Problem_16 test =new Problem_16();
        RecordLastNOrder order = test.createRecords(5);
        for(int i = 0; i < 99; i++){
            order.record(i + 100);
        }
        System.out.println(order);
        System.out.println(order.getLast(2));

    }

    public RecordLastNOrder createRecords(int n){
        return new RecordLastNOrder(n);
    }

    class RecordLastNOrder{
        List<Integer> records = new ArrayList<>();
        int recordMax;

        RecordLastNOrder(int n){
            this.recordMax = n;
        }
        public void record(int orderId){
            if(records.size() == recordMax) records.remove(0);
            records.add(orderId);
        }

        public int getLast(int i){
            return records.get(records.size() - i);
        }

        @Override
        public String toString() {
            return records.toString();
        }
    }
}
