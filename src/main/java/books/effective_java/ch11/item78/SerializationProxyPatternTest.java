package books.effective_java.ch11.item78;

import java.io.*;

/**
 * Created on 2018-05-13.
 */
public class SerializationProxyPatternTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FailedSerializationExmaple failedEx = new FailedSerializationExmaple(1,1, "failed");
        SerializationProxyPatternExample proxyPatternEx = new SerializationProxyPatternExample(1,1,"proxyPattern");
        try {
            testSerialization(failedEx);
        } catch (Exception e){
            e.printStackTrace();
        }

        testSerialization(proxyPatternEx);
    }

    private static <T> void testSerialization(T ex1) throws IOException, ClassNotFoundException {
        byte[] serialized = serialize(ex1);
        T ex2 = deserialize(serialized, ex1.getClass());

        System.out.println(ex2.toString());
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
