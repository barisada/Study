package dailycoding.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * leetcode : #22
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses test = new GenerateParentheses();
        System.out.println(test.generateParenthesis(3));
        System.out.println(test.generateParenthesis(5));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(n, 0, 0, result, "");
        return result;
    }

    private void backtracking(int n, int open, int close, List<String> result, String cur) {
        if(cur.length() == n * 2) result.add(cur);
        else {
            if(open < n) backtracking(n, open + 1, close, result, cur + "(");
            if(close< open) backtracking(n, open, close + 1, result,cur + ")");
        }
    }
}
