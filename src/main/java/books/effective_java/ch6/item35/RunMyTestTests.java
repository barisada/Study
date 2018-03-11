package books.effective_java.ch6.item35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 */
public class RunMyTestTests {

	public static void main(String[] args) {
		int tests = 0;
		int passed = 0;
		Class testClass = MyTestAnnotationMethods.class;

		for(Method m : testClass.getMethods()){
			if(m.isAnnotationPresent(MyTest.class)){
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException e) {
					Throwable throwable = e.getCause();
					System.out.println(m + " failed : " + throwable);
				} catch (Exception e) {
					System.out.println(m + "INVALID @MyTest " + e);
				}

			}
		}
		System.out.printf("Passed : %d Failed : %d%n", passed, tests - passed);


	}
}
