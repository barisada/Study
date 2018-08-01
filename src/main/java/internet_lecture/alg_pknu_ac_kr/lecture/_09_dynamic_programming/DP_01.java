package internet_lecture.alg_pknu_ac_kr.lecture._09_dynamic_programming;

import org.springframework.util.StopWatch;

import java.util.Arrays;

public class DP_01 {
    public static void main(String[] args) {

        int n = 30;
        StopWatch sw = new StopWatch("fibonacci time");

        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        sw.start("fibonacci top-down");
        System.out.println(fibonacci(n - 1, cache));
        sw.stop();

        int[] cache2 = new int[n];
        Arrays.fill(cache2, -1);
        sw.start("fibonacci bottom up");
        System.out.println(fibonacciBottomUp(n - 1, cache2));
        sw.stop();

        System.out.println(sw.prettyPrint());

        n = 49;
        int k = 6;
        int binom[][] = new int[n + 1][k + 1];
        for(int[] binomRow : binom){
            Arrays.fill(binomRow, -1);
        }
        System.out.println("binomial coefficient top down  : " + binomialCoefficient(n, k, binom));

        int binom2[][] = new int[n + 1][k + 1];
        for(int[] binomRow : binom2){
            Arrays.fill(binomRow, -1);
        }
        System.out.println("binomial coefficient bottom up : " + binomialCoefficientBottomUp(n, k, binom2));

    }

    public static int fibonacci(int n, int[] cache) {
        if(n < 2){
            return 1;
        } else {
            if(cache[n] != -1){
                return cache[n];
            } else {
                cache[n] = fibonacci(n - 1, cache) + fibonacci(n -2, cache);
                return cache[n];
            }
        }
    }


    public static int fibonacciBottomUp(int n, int[] cache) {
        cache[0] = cache[1] = 1;

        for(int i = 2; i <= n; i++){
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    /**
     * nCk = binomial coefficient
     * n개중에서 k개를 선택하는 경우의 수
     *
     * For every n >= k,
     * n = 0 or  k =0 then nCk = 1;
     * otherwise nCk =  n-1Ck + n-1Ck-1
     * n개중에 a가 있다고 치고,
     * n개중에서  a를 포함해서 k개를 뽑는경우 n - 1 C k -1
     * n개중에서 a를 포함하지 않고 k개를 뽑는경우 n - 1 C k
     * 위 두가지를 더하면됨.
     * @param n
     * @param k
     * @param binom
     * @return
     */
    public static int binomialCoefficient(int n, int k, int[][] binom){
        if(n == k || k == 0) return 1;
        else if (binom[n][k] > -1){
            return binom[n][k];
        } else {
            binom[n][k] = binomialCoefficient(n - 1, k, binom) + binomialCoefficient(n -1, k - 1, binom);
            return binom[n][k];
        }
    }

    public static int binomialCoefficientBottomUp(int n, int k, int[][] binom){
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= k && j <= i; j++){
                if(i == 0 || j == 0 || j == i){
                    binom[i][j] = 1;
                } else {
                    binom[i][j] = binom[i - 1][j -1] + binom[i - 1][j];
                }
            }
        }
        return binom[n][k];
    }
}
