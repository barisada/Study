package dailycoding;

import java.util.Arrays;

/**
 * The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other.
 * For example, the edit distance between “kitten” and “sitting” is three:
 *      substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.
 *
 * Given two strings, compute the edit distance between them.
 */
public class Problem_31 {

    public static void main(String[] args) {
        Problem_31 test = new Problem_31();
        System.out.println("should be 3 : " + test.editDistance("kitten", "sitting"));
        System.out.println("should be 1 : " + test.editDistance("abcde", "zabcde"));
        System.out.println("should be 6 : " + test.editDistance("gd", "abcdefg"));
    }

    public int editDistance(String s, String t){
        int[][] dp  = init(s, t);
        for(int row = 1; row < dp.length; row++){
            for(int col = 1; col < dp[row].length; col++){
                if(s.charAt(row - 1) == t.charAt(col - 1)){
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    dp[row][col] = 1 + min(dp[row - 1][col], dp[row][col - 1], dp[row - 1][col - 1]);
                }
            }
        }
        return dp[s.length()][t.length()];

    }

    private int min(int i, int j, int k) {
        int min = Math.min(i, j);
        return Math.min(min, k);
    }

    private int[][] init(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int col = 0; col < dp[0].length; col++){
            dp[0][col] = col;
        }
        for(int row = 0; row < dp.length; row++){
            dp[row][0] = row;
        }
        return dp;
    }
}
