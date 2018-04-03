package books.effective_java.ch8.item54;

/**
 * Created on 2018-04-03.
 */
public class NativeMethodExample {

    public native void fastFileCopy(String src, String dest);

    public static void main(String[] args) {
        NativeMethodExample ex = new NativeMethodExample();
        ex.fastFileCopy("be careful", "to use native method");
    }
}
