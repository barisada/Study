package books.effective_java.ch11.item74;

import java.io.*;
import java.util.Base64;

/**
 * Created on 2018. 4. 29..
 */
public class FooTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Foo foo = new Foo(1,2);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(foo);

		String base64Foo = Base64.getEncoder().encodeToString(baos.toByteArray());
		System.out.println("base64Foo : " + base64Foo);

		byte[] serializedFoo = Base64.getDecoder().decode(base64Foo);
		ByteArrayInputStream bais = new ByteArrayInputStream(serializedFoo);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object objectFoo = ois.readObject();
		Foo deserializedFoo = (Foo) objectFoo;
		System.out.println("deserialized foo : " + deserializedFoo);


	}

}
