package video.alg_pknu_ac_kr.lecture._01_recursion;

public class Recursion_01 {
    public static void main(String[] args) {
        int i = 4;
        func(i);
        int result = func2(4);
        System.out.println(result);

        int factorialResult = factorial(4);
        System.out.println(factorialResult);

        double power = power(4.0, 4);
        System.out.println(power);

        int fibonacci = fibonacci(4);
        System.out.println(fibonacci);

        int gcd = gcd(15, 35);
        System.out.println(gcd);

        int gcd2 = enhancedGcd(15, 35);
        System.out.println(gcd2);
    }

    private static void func(int i) {
        if(i <= 0){
            /**
             * base case - 적어도 하나의 recursion에 빠지지 않는 case가 존재해야한다.
             */
            return;
        } else {
            /**
             * recursion  case - recursion을 반복하다보면 결국 base case로 수렴해야 한다.
             */
            System.out.println("hello...");
            func(i - 1);
        }
    }

    /**
     * 0 ~ n 까지 합을 구하는 메소드.
     * @param n
     * @return
     */
    private static int func2(int n) {
        if(n == 0) return 0;
        else {
            return n + func2(n - 1);
        }
    }

    /**
     * n! 을 구하는 함수
     *  - 0! = 1
     *  - n! = n * (n - 1)
     * @param n
     * @return
     */
    private static int factorial(int n) {
        if(n == 0 ) return 1;
        else {
            return n * factorial(n - 1);
        }
    }

    /**
     * x^n을 구하는 함수
     *  - x^0 = 1
     *  - x^n = x * (x^(n-1)) , if n > 0
     * @param x
     * @param n
     * @return
     */
    private static double power(double x, int n) {
        if(n == 0) return 1;
        else {
            return x * power(x, n - 1);
        }
    }

    /**
     * fibonacci 구하는 메소드
     *  - f0 = 0
     *  - f1 = 1
     *  - fn = fn-1 + fn - 2 , n > 1
     * @param n
     * @return
     */
    private static int fibonacci(int n) {
        if(n > 2) return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Euclid Method
     * gcd(m, n) , if m >= n
     *  - n * 2 = m 이면 gcd(m,n) = n
     *  - gcd(m, n) = gcd(n, m % n)
     * @param m
     * @param n
     * @return
     */
    private static int gcd(int m, int n) {
        if(m < n){
            //swap
            int temp = m;
            m = n;
            n = temp;
        }
        if(m % n == 0){
            return n;
        } else {
            return gcd(n, m % n);
        }
    }

    /**
     * gcd(p, q)
     *  - if q = 0, gcd(p, q) = p
     *  - gcd(p,q) = gcd(q, p%q), otherwise
     * @param p
     * @param q
     * @return
     */
    private static int enhancedGcd(int p, int q) {
        if(q == 0) return p;
        else {
            return enhancedGcd(q, p % q);
        }

    }
}
