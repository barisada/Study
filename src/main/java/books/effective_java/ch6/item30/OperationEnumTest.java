package books.effective_java.ch6.item30;

public class OperationEnumTest {
    public static void main(String[] args) {
        double x = 2;
        double y = 4;
        for(OperationEnumExample op : OperationEnumExample.values()){
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
