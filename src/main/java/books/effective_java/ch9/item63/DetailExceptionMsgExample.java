package books.effective_java.ch9.item63;

/**
 * Created on 2018-04-09.
 */
public class DetailExceptionMsgExample {

    public static void method1(){
        throw new BetterIndexOutOfBoundsException(0, 10, 11);
    }

    public static void main(String[] args) {
        method1();
    }
}

class BetterIndexOutOfBoundsException extends RuntimeException{
    int lowerBound;
    int upperBound;
    int index;
    /**
     * Construct an IndexOutOfBoundsException.
     *
     * @param lowerBound the lowest legal index value.
     * @param upperBound the highest legal index value plus one.
     * @param index      the actual index value.
     */
    public BetterIndexOutOfBoundsException(int lowerBound, int upperBound, int index) {
        // Generate a detail message that captures the failure
        super("Lower bound: " + lowerBound +
                ", Upper bound: " + upperBound +
                ", Index: " + index);
        // Save failure information for programmatic access
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }
}
