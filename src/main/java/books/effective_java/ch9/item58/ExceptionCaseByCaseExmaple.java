package books.effective_java.ch9.item58;

/**
 * Created on 2018-04-05.
 */
public class ExceptionCaseByCaseExmaple {

    public static void checkedError(){
        try {
            throw new StupidException();
        } catch (StupidException e) {
            System.out.println("always stupid");
            e.printStackTrace();
        }
    }

    public static void uncheckedError(){
        throw new StupidRuntimeException("So Stupid");
    }
}

class StupidException extends Exception{
}

class StupidRuntimeException extends RuntimeException{
    public StupidRuntimeException(String message) {
        super(message);
    }
}