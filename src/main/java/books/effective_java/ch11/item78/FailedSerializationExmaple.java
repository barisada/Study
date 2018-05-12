package books.effective_java.ch11.item78;

import java.io.Serializable;

/**
 * Created on 2018-05-13.
 */
public class FailedSerializationExmaple extends SomeClass implements Serializable {
    public FailedSerializationExmaple(int x, int y, String name) {
        super(x, y, name);
    }
}
