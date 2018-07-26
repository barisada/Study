package books.design_pattern._06_Prototype.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2018-05-28.
 */
public class Manager {
    private Map<String, Product> showcase = new HashMap<>();

    public void register(String name, Product proto){
        showcase.put(name, proto);
    }

    public Product create(String protoName){
        Product p = showcase.get(protoName);
        return p.createClone();
    }
}
