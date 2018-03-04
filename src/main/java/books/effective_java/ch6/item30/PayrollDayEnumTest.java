package books.effective_java.ch6.item30;

public class PayrollDayEnumTest {
    public static void main(String[] args) {
        double hrs = 9;
        double rate = 10;
        System.out.println("worked hours : " + hrs + ", pay rate : " + rate);
        for(PayrollDayEnumExample pay : PayrollDayEnumExample.values()){
            System.out.println(pay + " : " + pay.pay(hrs, rate));
        }
    }
}
