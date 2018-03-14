package books.effective_java.ch7.item38;

import org.springframework.util.Assert;

public class CheckParameterValidityExample {

    /**
     *
     * @param i is dividor
     * @return i / i
     * @throws ArithmeticException if i is 0;
     */
    public int divideByParameter(int i){
        if(i == 0){
            throw new ArithmeticException(("Given parameter must not be zero."));
        }
        return i / i;
    }

    public void callPrivateMethod(Object obj){
        privateMethod(obj);
    }

    //private method would use assert for parameter validity
    private void privateMethod(Object obj) {
        Assert.notNull(obj, "must not be null");
        System.out.println(obj);

    }
}
