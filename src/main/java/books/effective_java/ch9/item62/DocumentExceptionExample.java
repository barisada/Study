package books.effective_java.ch9.item62;

/**
 * Created on 2018-04-09.
 */
public class DocumentExceptionExample {

    /**
     * Throw FeelSoBadException every time call this method
     * because it feels so bad every time.
     * <PRE>
     *     Call this method when you feel so bad.
     * </PRE>
     * @throws FeelSoBadException
     */
    public static void documentedException() throws FeelSoBadException {
        throw new FeelSoBadException();
    }

    public static void main(String[] args){
        try {
            documentedException();
        } catch (FeelSoBadException e) {
            throw new RuntimeException(e);
        }
    }
}

class FeelSoBadException extends Exception{

}
