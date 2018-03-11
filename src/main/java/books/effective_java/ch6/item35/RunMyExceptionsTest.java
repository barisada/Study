package books.effective_java.ch6.item35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jwlee1 on 2018. 3. 11..
 */
public class RunMyExceptionsTest {
	public static void main(String[] args) {
		int tests = 0;
		int passed = 0;
		Class testCalss = MyExceptionsTestMethods.class;

		for(Method m : testCalss.getMethods()){
			if(m.isAnnotationPresent(MyExceptionsTest.class)){
				tests++;
				try{
					m.invoke(null);
					System.out.printf("Test %s failed : no exception%n", m);
				} catch (InvocationTargetException e){
					Throwable throwable = e.getCause();
					Class<? extends  Exception>[] types = m.getAnnotation(MyExceptionsTest.class).value();
					int oldPassed = passed;
					for(Class<? extends  Exception> type  : types){
						if(type.isInstance(throwable)){
							passed++;
							break;
						}
					}
					if(oldPassed == passed){
						System.out.printf("Test %s failed: %s %n", m, throwable);
					}
				} catch (Exception e){
					System.out.println(m + "INVALID @MyExceptionsTest " + e);
				}
			}
		}
		System.out.printf("Passed : %d Failed : %d%n", passed, tests - passed);

	}
}
