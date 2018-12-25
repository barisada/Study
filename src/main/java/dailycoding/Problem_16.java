package dailycoding;

import java.time.LocalDateTime;
import java.util.*;

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
        Log order = test.createRecords(10);

        Random random = new Random();
        for(int i = 0; i < 53; i++){
            order.record(test.createOrder(i, random.nextInt(1000), random.nextInt(10), "user" + i, LocalDateTime.now()));
        }
        System.out.println(order);
        System.out.println(order.getLast(2));

    }

    private Order createOrder(int id, int price, int qty, String userName, LocalDateTime now) {
        return new Order(id, price, qty, userName, now );
    }

    public Log createRecords(int n){
        return new Log(n);
    }

    class Log {
        List<Order> orderRecords = new LinkedList<>();
        Map<Integer, Order> orderMap = new HashMap<>();
        int recordMax;
        int idxOffset = 0;

        Log(int n){
            this.recordMax = n;
        }

        /**
         * Remove oldest and record new Order is O(1) since it is LinkedList and HashMap.
         * @param latestOrder
         */
        public void record(Order latestOrder){
            if(orderRecords.size() == recordMax){
                orderRecords.remove(0);
                orderMap.remove(idxOffset++);
            }
            orderRecords.add(latestOrder);
            orderMap.put(orderRecords.size() - 1 + idxOffset, latestOrder);
        }

        /**
         * get last ith order is O(1) since it uses hashmap
         * @param i
         * @return
         */
        public Order getLast(int i){
            return orderMap.get(orderRecords.size() - i + idxOffset);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(Order order: orderRecords) sb.append(order + System.lineSeparator());
            sb.append("===============================" + System.lineSeparator());
            for(Map.Entry<Integer, Order> entry : orderMap.entrySet()) sb.append(entry + System.lineSeparator());

            return sb.toString();
        }
    }

    class Order{
        int id;
        int price;
        int qty;
        String buyer;
        LocalDateTime lastOrderAt;

        public Order(int id, int price, int qty, String buyer, LocalDateTime lastOrderAt) {
            this.id = id;
            this.price = price;
            this.qty = qty;
            this.buyer = buyer;
            this.lastOrderAt = lastOrderAt;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "id=" + id +
                    ", price=" + price +
                    ", qty=" + qty +
                    ", buyer='" + buyer + '\'' +
                    ", lastOrderAt=" + lastOrderAt +
                    '}';
        }
    }
}
