package books.effective_java.ch11.item77;

import java.io.*;

/**
 * Created on 2018-05-12.
 */
public class SingletonSerializeTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SingletonExample ex1 = SingletonExample.INSTANCE;
        SingletonWithReadReadResolve readResolveEx = SingletonWithReadReadResolve.INSTANCE;
        SingletonEnumExample singletonEnumEx = SingletonEnumExample.INSTANCE;   //the most preferred approach.

        compareSingletonWithDeserialize(ex1);
        compareSingletonWithDeserialize(readResolveEx);
        compareSingletonWithDeserialize(singletonEnumEx);

    }

    private static <T> void compareSingletonWithDeserialize(T ex1) throws IOException, ClassNotFoundException {
        byte[] serialized = serialize(ex1);
        T ex2 = deserialize(serialized, ex1.getClass());

        System.out.println("ex1(" + ex1.hashCode() + ") vs ex2(" + ex2.hashCode() + ") = " + (ex1 == ex2));
    }

    private static <T> byte[] serialize(T obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);

        return baos.toByteArray();
    }
    private static <T> T deserialize(byte[] serialized, Class<?> clazz) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(serialized);
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (T) clazz.cast(ois.readObject());
    }
}
