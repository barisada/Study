package dailycoding.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * leetcode #3
 */
public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeating test = new LongestSubstringWithoutRepeating();
        String test1 = "abcabbbcad";
        String test2 = "pwwkew";
        String test3 = "bpfbhmipx";
        String test4 = " ";

        System.out.println("should be 4 : " + test.longestSubstring(test1));
        System.out.println("should be 3 : " + test.longestSubstring(test2));
        System.out.println("should be 7 : " + test.longestSubstring(test3));
        System.out.println("should be 1 : " + test.longestSubstring(test4));
        System.out.println("============== below is proto solution ==================");
        System.out.println("should be 4 : " + test.longest(test1));
        System.out.println("should be 3 : " + test.longest(test2));
        System.out.println("should be 7 : " + test.longest(test3));
        System.out.println("should be 1 : " + test.longest(test4));

    }

    public int longestSubstring(String s){
        int n = s.length();
        int[] arr = new int[128];

        int max = 0;
        int start = 0, cur = 0;
        while(start < n && cur < n){
            char c = s.charAt(cur);
            if(arr[c] == 0){
                arr[c]++;
                max = Math.max(max, ++cur - start);
            }
            else arr[s.charAt(start++)]--;
        }
        return max;
    }

    //proto version : time = O(n), space = O(n)
    public int longest(String str){
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                max = Math.max(max, map.size());
                int end = map.get(str.charAt(i));
                for(int j = start; j <= end; j++){
                    map.remove(str.charAt(j));
                }
                start = end + 1;
            }
            map.put(str.charAt(i), i);
        }
        max = Math.max(max, map.size());
        return max;
    }


}
