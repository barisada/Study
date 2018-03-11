package books.effective_java.ch6.item35;

import java.sql.SQLDataException;

/**
 * Created by jwlee1 on 2018. 3. 11..
 */
public class MyExceptionTestMethods {
	@MyExceptionTest(ArithmeticException.class)
	public static void m1(){
		int i = 0;
		i  = i / i;
	}

	@MyExceptionTest(ArithmeticException.class)
	public static void  m2(){
		int[] a = new int[0];
		int i = a[1];
	}

	@MyExceptionTest(ArithmeticException.class)
	public static void m3(){}

	@MyExceptionTest(SQLDataException.class)
	public static void m4(){
		throw new IllegalArgumentException("POWER Exception!");
	}
}
