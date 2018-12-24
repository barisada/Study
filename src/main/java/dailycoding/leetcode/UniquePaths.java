package dailycoding.leetcode;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths test = new UniquePaths();
        System.out.println("should be 3 : " + test.uniquePaths(3, 2));
        System.out.println("should be 3 : " + test.uniquePaths(7, 3));
        System.out.println("should be 100 : " + test.uniquePaths(100, 2));
        System.out.println("should be 1101716330 : " + test.uniquePaths(10, 38));
    }


    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for(int row = 0; row < m; row++) grid[row][n - 1] = 1;
        for(int col = 0; col < n; col++) grid[m - 1][col] = 1;

        for(int row = m - 2; row >= 0; row--){
            for(int col = n - 2; col >= 0; col--){
                grid[row][col] = grid[row + 1][col] + grid[row][col + 1];
            }
        }
        return grid[0][0];
    }
}
