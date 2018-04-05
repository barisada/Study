package books.effective_java.ch9.item59;

/**
 * Created on 2018-04-06.
 */
public class AvoidUnnecessaryCheckedExceptionTest {
    public static void main(String[] args) {
        AvoidUnnecessaryCheckedExceptionExample.doNotDoThis(null);
        AvoidUnnecessaryCheckedExceptionExample.betterDoLikeThis(null);
    }
}
