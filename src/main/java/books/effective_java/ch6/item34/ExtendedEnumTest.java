package books.effective_java.ch6.item34;

import java.util.Arrays;
import java.util.Collection;

public class ExtendedEnumTest {
    public static void main(String[] args) {
        double x = Math.random();
        double y = Math.random();
        System.out.println("x : " + x + ", " + "y : " + y);

        test1(ExtendedOperation.class, x, y);
        test1(BasicOperation.class, x, y);
        System.out.println("===================");
        test2(Arrays.asList(ExtendedOperation.values()), x, y);
        test2(Arrays.asList(BasicOperation.values()), x, y);
    }

    //bounded type token (item29)
    private static <T extends Enum<T> & Operation> void test1(Class<T> opSet, double x, double y) {
        for(Operation op : opSet.getEnumConstants()){
            System.out.println("x " + op + " y = " + op.apply(x, y));
        }
    }

    //bounded wildcard type (item28)
    private static void test2(Collection<? extends Operation> opSet, double x, double y){
        for(Operation op : opSet){
            System.out.println("x " + op + " y = " + op.apply(x, y));
        }
    }
}
