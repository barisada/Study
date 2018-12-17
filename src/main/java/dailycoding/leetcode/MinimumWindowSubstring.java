package dailycoding.leetcode;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * leetcode #76
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        System.out.println("should be BANC : " + test.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("should be a : " + test.minWindow("a", "a"));
        System.out.println("should be a : " + test.minWindow("ab", "a"));
        System.out.println("should be b : " + test.minWindow("ab", "b"));
        System.out.println("should be ba : " + test.minWindow("bbba", "ba"));
    }

    public String minWindow(String s, String t) {
        int[] arr = new int[128];
        for(char c : t.toCharArray()) arr[c]++;

        int from = 0, to = 0, minFrom = 0, minTo = 0, min = Integer.MAX_VALUE;
        int counter = t.length();

        while(to < s.length()){
            char curr = s.charAt(to++);
            if(arr[curr] > 0 ) counter--;

            arr[curr]--;

            while(counter == 0){
                if(min > (to - from)){
                    minFrom = from;
                    minTo = to;
                    min = (to - from);
                }
                char removed = s.charAt(from++);
                if(arr[removed] == 0) counter++;
                arr[removed]++;
            }
        }
        return minFrom == minTo ? "" : s.substring(minFrom, minTo);
    }
}
