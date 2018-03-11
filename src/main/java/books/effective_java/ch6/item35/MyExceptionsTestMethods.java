package books.effective_java.ch6.item35;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwlee1 on 2018. 3. 11..
 */
public class MyExceptionsTestMethods {
	@MyExceptionsTest({IndexOutOfBoundsException.class, NullPointerException.class})
	public static void doublyBad(){
		List<String> list = new ArrayList<>();
		list.addAll(5, null);
	}

	@MyExceptionsTest(RuntimeException.class)
	public static void test1(){
		throw new RuntimeException("runtime");
	}
}
