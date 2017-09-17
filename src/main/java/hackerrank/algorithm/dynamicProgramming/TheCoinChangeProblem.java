package hackerrank.algorithm.dynamicProgramming;

import java.util.*;

/**
 * Created by jw on 2017-09-05.
 */
public class TheCoinChangeProblem {

    static long getWays(long n, long[] c){
        long[][] solution = new long[c.length + 1][(int) (n + 1)];

        // if amount=0 then just return empty set to make the change
        for (int i = 0; i <= c.length; i++) {
            solution[i][0] = 1;
        }

        // if no coins given, 0 ways to change the amount
        for (int i = 1; i <= n; i++) {
            solution[0][i] = 0;
        }

        // now fill rest of the matrix.

        for (int i = 1; i <= c.length; i++) {
            for (int j = 1; j <= n; j++) {
                // check if the coin value is less than the amount needed
                if (c[i - 1] <= j) {
                    // reduce the amount by coin value and
                    // use the subproblem solution (amount-v[i]) and
                    // add the solution from the top to it
                    solution[i][j] = solution[i - 1][j]
                            + solution[i][(int) (j - c[i - 1])];
                } else {
                    // just copy the value from the top
                    solution[i][j] = solution[i - 1][j];
                }
            }
            System.out.println(c[i-1]);
            for(long[] ar : solution){
                System.out.println(Arrays.toString(ar));
            }
        }
        return solution[c.length][(int) n];
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
