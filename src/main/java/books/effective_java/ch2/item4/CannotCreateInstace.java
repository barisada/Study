package books.effective_java.ch2.item4;

public class CannotCreateInstace {
    private CannotCreateInstace(){
        throw new AssertionError();
    }
}
