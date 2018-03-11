package books.effective_java.ch6.item35;

/**
 */
public class MyTestAnnotationMethods {
	@MyTest
	public static void m1(){}

	public static void m2(){}

	@MyTest
	public static void m3(){
		throw new RuntimeException("BAAAM");
	}

	public static void m4(){}

	@MyTest
	public void m5(){}

	public static void m6(){}

	@MyTest
	public static void m7(){
		throw new RuntimeException("CRAAAAASH");
	}

	public static void m8(){}

	@MyTest
	public static void m9(Object obj){

	}

}
