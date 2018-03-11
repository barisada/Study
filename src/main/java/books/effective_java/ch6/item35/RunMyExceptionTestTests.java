package books.effective_java.ch6.item35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jwlee1 on 2018. 3. 11..
 */
public class RunMyExceptionTestTests {

	public static void main(String[] args) {
		int tests = 0;
		int passed = 0;
		Class testClass = MyExceptionTestMethods.class;

		for(Method m : testClass.getMethods()){
			if(m.isAnnotationPresent(MyExceptionTest.class)){
				tests++;
				try{
					m.invoke(null);
					System.out.printf("Test %s failed : no exception%n", m);
				} catch (InvocationTargetException e){
					Throwable throwable = e.getCause();
					Class<? extends  Exception> type = m.getAnnotation(MyExceptionTest.class).value();
					if(type.isInstance(throwable)){
						passed++;
					} else {
						System.out.printf("Test %s failed: expected %s, got %s%n", m, type.getName(), throwable);
					}
				} catch (Exception e){
					System.out.println(m + "INVALID @MyExceptionTest " + e);
				}
			}
		}
		System.out.printf("Passed : %d Failed : %d%n", passed, tests - passed);
	}
}
