package dailycoding.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 * leetcode #32
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses test = new LongestValidParentheses();
        String str1 = "(()";
        String str2 = ")()())";
        String str3 = "(((()()))()(((((((((((((((()()())";
        System.out.println("should be 2 : " + test.longestValidParentheses(str1));
        System.out.println("should be 4 : " + test.longestValidParentheses(str2));
        System.out.println("should be 10 : " + test.longestValidParentheses(str3));
    }

    //dp
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char prev = s.charAt(i - 1);
            if (cur == ')') {
                if (prev  == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    //using stack
    public int longestValidParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);

        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(i);
            else {
                stack.pop();
                if(!stack.isEmpty()){
                    max = Math.max(max, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return max ;
    }
}
