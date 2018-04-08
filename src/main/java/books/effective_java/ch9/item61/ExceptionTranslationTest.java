package books.effective_java.ch9.item61;

/**
 * Created on 2018-04-09.
 */
public class ExceptionTranslationTest {

    public static void main(String[] args) {
        ExceptionTranslationExample ex = new ExceptionTranslationExample();
        try {
            ex.exceptionTranslation();
        } catch (HigherLevelException e) {
            e.printStackTrace();
        }
        System.err.println("=================================================");
        try {
            ex.exceptionChaining();
        } catch (HigherLevelException e) {
            e.printStackTrace();
        }
    }
}
