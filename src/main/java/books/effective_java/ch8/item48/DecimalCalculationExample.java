package books.effective_java.ch8.item48;

import java.math.BigDecimal;

/**
 * Created on 2018-03-29.
 */
public final class DecimalCalculationExample {

    public static double unsafeMinus(double a, double b){
        return a - b;
    }

    public static double unsafeMultiply(double a, double b){
        return a * b;
    }

    public static BigDecimal safeMinus(BigDecimal a, BigDecimal b){
        return a.subtract(b);
    }

    public static BigDecimal safeMultiply(BigDecimal a, BigDecimal b){
        return a.multiply(b);
    }
}
