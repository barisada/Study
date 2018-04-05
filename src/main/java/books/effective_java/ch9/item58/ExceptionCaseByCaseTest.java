package books.effective_java.ch9.item58;

/**
 * Created on 2018-04-05.
 */
public class ExceptionCaseByCaseTest {
    public static void main(String[] args) throws NotEnoughMoney {
        ExceptionCaseByCaseExmaple.checkedError();
        ExceptionCaseByCaseExmaple.calcChanges(Math.random());
        ExceptionCaseByCaseExmaple.uncheckedError();
    }
}
