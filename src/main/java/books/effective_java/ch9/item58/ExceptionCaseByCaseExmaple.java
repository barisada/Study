package books.effective_java.ch9.item58;

import java.util.Random;

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

    public static void calcChanges(double itemPrice) throws NotEnoughMoney{
        double remain = new Random().nextInt(1) / 1.0;
        if(itemPrice > remain) throw new NotEnoughMoney("not enough money : $" + (itemPrice - remain));
    }

    public static void uncheckedError(){
        throw new StupidRuntimeException("So Stupid");
    }

}

class StupidException extends Exception{
}

class NotEnoughMoney extends Exception{
    public NotEnoughMoney() {
        super();
    }

    public NotEnoughMoney(String message) {
        super(message);
    }
}

class StupidRuntimeException extends RuntimeException{
    public StupidRuntimeException(String message) {
        super(message);
    }
}
