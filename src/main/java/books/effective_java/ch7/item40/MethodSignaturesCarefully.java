package books.effective_java.ch7.item40;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodSignaturesCarefully {

    @Print
    public void ChooseMethodNamesCarefully(){
        System.out.println("Choose method names carefully");
    }

    @Print
    public void DontGoOverboardInProvidingConvenienceMethods(){
        System.out.println("When in doubt, leave it out.");
    }

    @Print
    public void avoidLongParameterLists(){
        System.out.println("Long sequences of identically typed parameters are especially harmful");
    }

    @Print
    public void favorInterfacesOverClassesForParameterTypes(){
        System.out.println("use Map instead. " +
                "This lets you pass in a Hashtable, a HashMap, a TreeMap, a submap of a TreeMap");
    }

    @Print
    public void preferEnumTypes(){
        System.out.println("Prefer two-element enum types to boolean parameters");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        for(Method m : MethodSignaturesCarefully.class.getMethods()){
            if(m.isAnnotationPresent(Print.class)){
                m.invoke(new MethodSignaturesCarefully());
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    private @interface Print{

    }
}
