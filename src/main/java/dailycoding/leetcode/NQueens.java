package dailycoding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 * leetcode #51
 */
public class NQueens {
    public static void main(String[] args) {
        NQueens test = new NQueens();
        System.out.println(test.solveNQueens(4).size());
        System.out.println(test.solveNQueens(5).size());
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(n, -1, new int[n], result);
        return result;
    }

    public void dfs(int n, int level, int[] cols, List<List<String>> result){
        if(!promising(level, cols)){
            return;
        } else if (level == cols.length - 1){
            List<String> list = new ArrayList<>();
            for(int i : cols){
                char[] arr = new char[n];
                Arrays.fill(arr, '.');
                arr[i] = 'Q';
                list.add(new String(arr));
            }
            result.add(list);
        } else {
            for(int i = 0; i < cols.length; i++){
                cols[level + 1] = i;
                dfs(n, level + 1, cols, result);
            }
        }
    }

    private static boolean promising(int level, int[] cols) {
        for(int i = 0; i < level; i++){
            if(cols[i] == cols[level] || level - i == Math.abs(cols[level] - cols[i])){
                return false;
            }
        }
        return true;
    }
}
