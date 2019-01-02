package dailycoding;

import java.util.*;

/**
 * Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
 *
 * For example, given the string "([])[]({})", you should return true.
 *
 * Given the string "([)]" or "((()", you should return false.
 *
 * leetcode #20
 */
public class Problem_27 {
    public static void main(String[] args) {
        Problem_27 test = new Problem_27();
        System.out.println("should be true : " + test.isBalancedBrackets("([])[]({})"));
        System.out.println("should be false : " + test.isBalancedBrackets("([)]"));
        System.out.println("should be false : " + test.isBalancedBrackets("((()"));
    }

    public boolean isBalancedBrackets(String str){
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();

        for(char bracket : str.toCharArray()){
            if(map.containsKey(bracket)) stack.add(bracket);
            else {
                if(stack.isEmpty()) return false;
                if(map.get(stack.pop()) != bracket) return false;
            }
        }
        return stack.isEmpty();
    }
}
