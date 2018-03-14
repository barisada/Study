package books.effective_java.ch7.item38;

public class CheckParamValidityTest {
    public static void main(String[] args) {
        CheckParameterValidityExample ex = new CheckParameterValidityExample();
        try{
            System.out.println("test divideByParameter method");
            ex.divideByParameter(0);
        } catch (ArithmeticException e){
            e.printStackTrace();
        }

        try{
            System.out.println("test callPrivateMethod method");
            ex.callPrivateMethod(null);
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(CheckParameterValidityExample.class.getName() + " test finished");
    }
}
