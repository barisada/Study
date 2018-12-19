package dailycoding;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
 * Given N, write a function that returns the number of unique ways you can climb the staircase.
 * The order of the steps matters.
 *
 * For example, if N is 4, then there are 5 unique ways:
 *
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 * What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X?
 * For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
public class Problem_12 {

    public static void main(String[] args) {
        Problem_12 test = new Problem_12();
        int[] steps1 = {1,2};
        int[] steps2 = {1,3,5};

        runTest(test, steps1, 30);
        System.out.println("step2 ==================");
        runTest(test, steps2, 30);
    }

    private static void runTest(Problem_12 test, int[] steps, int n) {
        StopWatch sw = new StopWatch("stair ways");

        sw.start("recursive");
        System.out.println(test.stairWays(n, steps));
        sw.stop();

        sw.start("memoization");
        System.out.println(test.stairsWaysMemo(n, steps));
        sw.stop();

        sw.start("dynamic programing");
        System.out.println(test.stairWaysDP(n, steps));
        sw.stop();

        System.out.println(sw.prettyPrint());
    }

    public int stairWays(int n, int[] steps){
        if(n == 0) return 1;
        if(n < 0) return 0;
        int total = 0;
        for(int i : steps){
            total += stairWays(n - i, steps);
        }
        return total;
    }

    public int stairsWaysMemo(int n, int[] steps){
        int[] memo = new int[n + 1];
        return stairsWaysMemo(n, steps, memo);
    }

    private int stairsWaysMemo(int n, int[] steps, int[] memo) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(memo[n] > 0) return memo[n];
        for(int i : steps){
            memo[n] += stairsWaysMemo(n - i, steps, memo);
        }
        return memo[n];

    }

    private int stairWaysDP(int n, int[] steps){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n ; i++){
            for(int s : steps){
                if(i - s >= 0) dp[i] += dp[i - s];
            }
        }
        return dp[n];
    }

    public List<List<Integer>> stairWaysAsList(int n , int steps[]){
        List<List<Integer>> result = new ArrayList<>();
        stairWaysAsList(n, steps, new ArrayList<>(), result);
        return result;
    }

    private int stairWaysAsList(int n, int[] steps, List<Integer> cur, List<List<Integer>> result) {
        if(n == 0) {
            result.add(new ArrayList<>(cur));
            return 1;
        } else if (n < 0) {
            return 0;
        } else {
            int total = 0;
            for(int i : steps){
                cur.add(i);
                total += stairWaysAsList(n - i, steps, cur, result);
                cur.remove(cur.size() - 1);
            }
            return total;
        }
    }

}
