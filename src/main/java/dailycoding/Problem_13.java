package dailycoding;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
 *
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */
public class Problem_13 {

    public static void main(String[] args) {
        Problem_13 test = new Problem_13();
        String str1 = "abcdefgghijk";
        String str2 = "eceba";
        String str3 = "abcbbbbcccbdddadacb";
        String str4 = "qmb";
        System.out.println(test.longestDistinctSubstring(str1));
        System.out.println("should be ece : "  + test.longestSubstringWithDistinctCharacter(str2, 2));
        System.out.println("should be bcbbbbcccb : "   + test.longestSubstringWithDistinctCharacter(str3, 2));
        System.out.println("should be qmb : "   + test.longestSubstringWithDistinctCharacter(str4, 6));
    }

    public String longestSubstringWithDistinctCharacter(String str, int k){
        Map<Character, Integer> map = new HashMap<>();
        int lo = 0, hi = 0, max = 0;
        String test = "";
        while(hi < str.length()){
            char c = str.charAt(hi);
            if(map.containsKey(c) || map.size() < k){
                map.put(c, map.getOrDefault(c, 0) + 1);
                hi++;
                if (max < (hi - lo)) {
                    test = str.substring(lo, hi);
                    max = (hi - lo);
                }
            }else {
                char remove = str.charAt(lo++);
                if(map.get(remove) == 1) map.remove(remove);
                else map.put(remove, map.get(remove) - 1);
            }
        }
        return test;
    }

    public String longestDistinctSubstring(String str){
        int[] arr = new int[128];

        int lo = 0, hi = 0, max = 0;
        int maxFrom = 0, maxTo = 0;
        while(hi < str.length()){
            int curIdx = str.charAt(hi);
            if(arr[curIdx] == 0



            ){
                arr[curIdx]++;
                if(max < (hi - lo)){
                    max = (hi - lo);
                    maxFrom = lo;
                    maxTo = hi;
                }
                hi++;
            } else {
                arr[str.charAt(lo++)]--;
            }
        }
        return str.substring(maxFrom, maxTo + 1);
    }
}
