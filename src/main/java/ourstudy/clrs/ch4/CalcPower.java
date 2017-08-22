package ourstudy.clrs.ch4;

/**
 * Created by jw on 2017-08-09.
 */
public class CalcPower {

    public int power(int x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n % 2 == 0){
            int half = power(x, n / 2);
            return half * half;
        } else {
            int half = power(x, (n - 1) / 2);
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        CalcPower calcPower = new CalcPower();
        System.out.println(calcPower.power(2,5));
        System.out.println(calcPower.power(2,10));
        System.out.println(calcPower.power(2,30));
    }
}
