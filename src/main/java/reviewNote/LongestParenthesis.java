package reviewNote;


import java.util.Stack;

/**
 * ))(())))(((()()()()(((((()))))()()()())))
 * find longest..parenthesis size
 */
public class LongestParenthesis {

    public int longestValidParentheses(String A) {
        int n = A.length();

        // Create a stack and push -1 as initial index to it.
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        // Initialize result
        int result = 0;

        // Traverse all characters of given string
        for (int i=0; i<n; i++)
        {
            // If opening bracket, push index of it
            if (A.charAt(i) == '(')
                stk.push(i);

            else // If closing bracket, i.e.,str[i] = ')'
            {
                // Pop the previous opening bracket's index
                stk.pop();

                // Check if this length formed with base of
                // current valid substring is more than max
                // so far
                if (!stk.empty())
                    result = Math.max(result, i - stk.peek());

                    // If stack is empty. push current index as
                    // base for next valid substring (if any)
                else stk.push(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestParenthesis longest = new LongestParenthesis();
        String str = ")()))(())((())))))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))(((";
        System.out.println(longest.longestValidParentheses(str));
    }
}
