package books.effective_java.ch2.item3;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        System.out.println("singleton1 : " + singleton1.toString());

        Singleton singleton2 = Singleton.getInstance();
        System.out.println("singleton2 : " + singleton2.toString());

        System.out.println("enum is always singleton");
        Elvis elvis1 = Elvis.INSTANCE;
        Elvis elvis2 = Elvis.INSTANCE;
        System.out.println(elvis1.toString() + " == " + elvis2.toString() + "(" + (elvis1 == elvis2 && elvis1.equals(elvis2)) + ")");
    }
}
