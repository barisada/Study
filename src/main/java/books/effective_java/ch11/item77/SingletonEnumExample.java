package books.effective_java.ch11.item77;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2018-05-12.
 */
// Enum singleton - the preferred approach
public enum SingletonEnumExample {
    INSTANCE;
    private List<String> doList = Arrays.asList("do1", "do2");
    public void doSomething(){
        System.out.println(doList);
    }
}
