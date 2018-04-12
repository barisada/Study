package books.effective_java.ch10.item68;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created on 2018-04-12.
 */
public class ExecutorsTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class target = ExecutorsExample.class;
        for(Method m : target.getMethods()){
            if(m.isAnnotationPresent(PrintMethodName.class)){
                try {
                    m.invoke(target.newInstance(), null);
                    Thread.sleep(10);
                    System.out.println("=============== " + m.getName() + " end ===============");
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
