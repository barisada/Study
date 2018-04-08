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
    public static void documentedCheckedException() throws FeelSoBadException {
        throw new FeelSoBadException();
    }

    /**
     * this just throws NPE.
     * @throws NullPointerException
     */
    public static void documentedUncheckedException(){
        throw new NullPointerException();
    }

    public static void main(String[] args){
        try {
            documentedCheckedException();
        } catch (FeelSoBadException e) {
           e.printStackTrace();
        }
        documentedUncheckedException();
    }
}

class FeelSoBadException extends Exception{

}

