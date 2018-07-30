package interviewPrep.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class _17_Letter_Combinations_of_a_Phone_Number {
    static Map<Character, String> digitToAlphaMap = new HashMap<>();
    static {

        digitToAlphaMap.put('0', "");
        digitToAlphaMap.put('1', "");
        digitToAlphaMap.put('2', "abc");
        digitToAlphaMap.put('3', "def");
        digitToAlphaMap.put('4', "ghi");
        digitToAlphaMap.put('5', "jkl");
        digitToAlphaMap.put('6', "mno");
        digitToAlphaMap.put('7', "pqrs");
        digitToAlphaMap.put('8', "tuv");
        digitToAlphaMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits == null || digits.length() == 0) return list;
        getCombination(digits, list, new StringBuilder(), 0);
        return list;
    }

    private void getCombination(String digits, List<String> list, StringBuilder current, int level) {
        if(digits.length() == level){
            list.add(current.toString());
        } else {
            char digit = digits.charAt(level);
            String alphabet = digitToAlphaMap.get(digit);

            if(alphabet.length() == 0)  getCombination(digits, list, current, level + 1);

            for (int j = 0; j < alphabet.length(); j++) {
                current.append(alphabet.charAt(j));
                getCombination(digits, list, current, level + 1);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        _17_Letter_Combinations_of_a_Phone_Number comb = new _17_Letter_Combinations_of_a_Phone_Number();
        System.out.println(comb.letterCombinations("2"));
    }
}
