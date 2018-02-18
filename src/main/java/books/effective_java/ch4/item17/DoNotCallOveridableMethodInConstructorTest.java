package books.effective_java.ch4.item17;

public class DoNotCallOveridableMethodInConstructorTest {
    public static void main(String[] args) {
        //super class call method before sub class is initiated. So there will be null.
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
