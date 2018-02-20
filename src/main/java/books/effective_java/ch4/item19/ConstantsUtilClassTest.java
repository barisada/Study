package books.effective_java.ch4.item19;

public class ConstantsUtilClassTest {
    public static final double SOME_CONSTATNS = 1234.1234;

    public static void main(String[] args) {
        System.out.println("good constants");
        System.out.println(SOME_CONSTATNS);
        System.out.println("bad constatns");
        System.out.println(DoNotUseInterfaceForConstants.BAD_CONSTANTS1);
        System.out.println(DoNotUseInterfaceForConstants.BAD_CONSTANTS2);
        System.out.println(DoNotUseInterfaceForConstants.BAD_CONSTANTS3);
    }
}
