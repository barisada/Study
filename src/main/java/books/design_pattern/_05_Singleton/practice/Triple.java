package books.design_pattern._05_Singleton.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2018-05-28.
 */
public class Triple {
    private static Map<Integer, Triple> instances = new HashMap<>();
    private int id;

    static {
        instances.put(0, new Triple(0));
        instances.put(1, new Triple(1));
        instances.put(2, new Triple(2));
    }

    private Triple(){}
    private Triple(int i){
        this.id  = i;
    }

    public static Triple getInstance(int i){
        return instances.get(i);
    }

    @Override
    public String toString() {
        return "Triple{" +
                "id=" + id +
                '}';
    }
}
