package books.effective_java.ch9.item61;

/**
 * Created on 2018-04-09.
 */
public class ExceptionTranslationExample {

    public void exceptionTranslation() throws HigherLevelException {
        try {
            throw new LowerLevelException();
        } catch (LowerLevelException e) {
            throw new HigherLevelException();
        }
    }

    public void exceptionChaining() throws HigherLevelException {
        try {
            throw new LowerLevelException();
        } catch (LowerLevelException cause){
            throw new HigherLevelException(cause);
        }
    }
}

class LowerLevelException extends Exception{

}

class HigherLevelException extends Exception{
    public HigherLevelException(){
        super();
    }

    public HigherLevelException(Throwable e){
        super(e);
    }

}
