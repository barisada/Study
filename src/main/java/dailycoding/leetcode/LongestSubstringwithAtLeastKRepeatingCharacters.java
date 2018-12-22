package dailycoding.leetcode;

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 *
 * Example 1:
 *
 * Input:
 * s = "aaabb", k = 3
 *
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 *
 * Input:
 * s = "ababbc", k = 2
 *
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringwithAtLeastKRepeatingCharacters test = new LongestSubstringwithAtLeastKRepeatingCharacters();
        System.out.println("should be 3 : " +test.longestSubstring("bbaaacbd",3));
        System.out.println("should be 6 : " +test.longestSubstring("aaabbb",3));
        System.out.println("should be 3 : " +test.longestSubstring("baaabcb",3));
        System.out.println("should be 0 : " +test.longestSubstring("ababacb", 3));
    }

    public int longestSubstring(String s, int k) {
        if(s.length() < k) return 0;

        int[] arr = new int[26];
        for(char c : s.toCharArray()) arr[c - 'a']++;

        boolean allValid  = true;
        for(int i : arr){
            if(i > 0 && i < k)  allValid = false;
        }

        if(allValid) return s.length();

        int lo = 0, hi = 0, max = 0;
        while(hi < s.length()){
            int cur = s.charAt(hi) - 'a';
            if(arr[cur] < k){
                String sub = s.substring(lo, hi);
                max = Math.max(max, longestSubstring(sub, k));
                lo = hi + 1;
            }
            hi++;
        }

        String sub = s.substring(lo, hi);
        max = Math.max(max, longestSubstring(sub, k));
        return max;

    }
}
