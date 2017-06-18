package sedgewick_algorithm.a2.datastructure;

        import edu.princeton.cs.algs4.StdIn;
        import edu.princeton.cs.algs4.StdRandom;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by jw on 2017-06-01.
 */
public class Permutation {
    public static void main(String[] args){
        int k = Integer.parseInt("8");
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        StringBuilder sb = new StringBuilder();
        while(!StdIn.isEmpty()) {
            sb.append(StdIn.readString() + " ");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
        String[] inputs = sb.toString().split(" ");
        while(rq.size() < k){
            int index = StdRandom.uniform(inputs.length);
            System.out.println(index);
            System.out.println(inputs[index]);

            if(inputs[index].length() > 0) {
                rq.enqueue(inputs[index]);
            }
            inputs[index] = "";
        }

        List list = new ArrayList();
        rq.iterator().forEachRemaining(list::add);
        System.out.println(list);
        for(int i = 0; i < k; i++){
            System.out.println(rq.dequeue());
        }

    }
}
