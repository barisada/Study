package dailycoding.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  Longest Substring with At Most Two Distinct Characters
 *
 *  Given a string, find the longest substring that contains only k unique characters.
 *  For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
 *
 *  related to leetcode #340, #159
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        LongestSubstringwithAtMostKDistinctCharacters test = new LongestSubstringwithAtMostKDistinctCharacters();
        String test1 = "abcbbbbcccbdddadacb";
        String test2 = "qmb";
        System.out.println("should be bcbbbbcccb : "   + test.longestSubstring(test1, 2));
        System.out.println("should be qmb : "   + test.longestSubstring(test2, 6));
    }

    private String longestSubstring(String str, int k) {
        String longest = "";
        int max = 0;
        int len = str.length();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;

        while(start < len && end < len){
            if(map.containsKey(str.charAt(end)) || map.size() < k){
                char cur = str.charAt(end++);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                if(max < (end - start)){
                    longest = str.substring(start, end);
                    max = end - start;
                }
            } else {
                char first = str.charAt(start++);
                if(map.get(first) == 1) map.remove(first);
                else map.put(first, map.get(first) - 1);
            }
        }
        return longest;
    }
}
