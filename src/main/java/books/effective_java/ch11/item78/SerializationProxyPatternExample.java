package books.effective_java.ch11.item78;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Created on 2018-05-13.
 */
public class SerializationProxyPatternExample extends SomeClass implements Serializable {
    public SerializationProxyPatternExample(int x, int y, String name) {
        super(x, y, name);
    }

    private Object writeReplace(){
        return new SerializationProxy(this);
    }

    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("proxy required");
    }

    private static class SerializationProxy implements Serializable{
        private int x;
        private int y;
        private String name;

        public SerializationProxy(SerializationProxyPatternExample ex) {
            this.x = ex.getX();
            this.y = ex.getY();
            this.name = ex.getName();
        }

        private static final long serialVersionUID = 1;

        private Object readResolve(){
            return new SerializationProxyPatternExample(x, y, name);
        }
    }
}
