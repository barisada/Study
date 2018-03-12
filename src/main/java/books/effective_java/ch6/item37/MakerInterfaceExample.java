package books.effective_java.ch6.item37;

import java.io.*;
import java.util.Arrays;

public class MakerInterfaceExample implements Serializable {
    String name;

    MakerInterfaceExample(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "MakerInterfaceExample{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        MakerInterfaceExample ex = new MakerInterfaceExample("Hello World");
        NotSupportSerialize ex2 = new NotSupportSerialize();
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(ex);
            System.out.println(Arrays.toString(baos.toByteArray()));

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            MakerInterfaceExample deserializedEx = (MakerInterfaceExample) ois.readObject();
            System.out.println(deserializedEx);

            //non serialize test
            oos.writeObject(ex2);
            System.out.println("should not print this");

        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }
    }

    static class NotSupportSerialize{
    }
}
