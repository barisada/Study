package books.ctci.recursion.quetion;

import org.springframework.util.StopWatch;

import java.util.Arrays;

public class _8_1_TripleStep {

    public static int countWays(int remain){
        if( remain == 0) {
            return 1;
        } else if (remain < 0){
            return 0;
        } else {
            return countWays(remain - 1)
                    + countWays(remain - 2)
                    + countWays(remain - 3);
        }

    }

    public static int countWaysWithMemo(int remain){
        int[] memo = new int[remain + 1];
        Arrays.fill(memo, -1);
        return countWaysWithMemo(remain, memo);
    }

    private static int countWaysWithMemo(int remain, int[] memo) {
        if(remain == 0) {
            return 1;
        } else if(remain < 0){
            return 0;
        } else if(memo[remain] > -1){
            return memo[remain];
        } else {
            memo[remain] = countWaysWithMemo(remain -1 , memo)
                    + countWaysWithMemo(remain -2 , memo)
                    + countWaysWithMemo(remain -3 , memo);
        }
        return memo[remain];
    }

    public static void main(String[] args) {
        StopWatch sw = new StopWatch("compare");
        sw.start("recursion");
        System.out.println(countWays(32));
        sw.stop();

        sw.start("memoization");
        System.out.println(countWaysWithMemo(32));
        sw.stop();

        System.out.println(sw.prettyPrint());
    }
}
