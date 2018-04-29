package books.effective_java.ch11.item75;

import java.io.*;
import java.util.Arrays;

/**
 * Created on 2018. 4. 29..
 */
public class SerializedTest {

	public static void main(String[] args) {
		DefaultSerializedExample defaultEx = new DefaultSerializedExample();
		defaultEx.setFirstName("first");
		defaultEx.setLastName("last");

		serializedTest(defaultEx, DefaultSerializedExample.class);


		CustomSerializedExample customEx = new CustomSerializedExample();
		customEx.setName("John");
		customEx.setNumOfFriends(6);
		customEx.setFriends(Arrays.asList("Sam", "Smith", "Marry", "Kevin"));
		serializedTest(customEx, CustomSerializedExample.class);
	}

	private static <T> void serializedTest(Object obj, Class<T> clazz) {
		byte[] serialized = serialized(obj);
		Object deserialized = deserialized(serialized, clazz);

		T deserializedEx = clazz.cast(deserialized);
		System.out.println( clazz.getSimpleName() + " : " + deserializedEx);

	}

	private static <T> Object deserialized(byte[] serialized, Class<T> clazz) {
		ByteArrayInputStream bais = new ByteArrayInputStream(serialized);
		T obj;
		try {
			ObjectInputStream ois = new ObjectInputStream(bais);
			obj = clazz.cast(ois.readObject());
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return obj;
	}

	private static byte[] serialized(Object obj){
		byte[] serialized;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			serialized = baos.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return serialized;
	}
}
