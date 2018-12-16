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
        if(s.length() < k ) return 0;
        int max = 0;
        int n = s.length();
        int[] arr = new int[26];

        for(char c : s.toCharArray()){
            arr[c - 'a']++;
        }

        boolean validString = true;
        for(int i : arr ){
            if(i < k && i > 0) validString = false;
        }

        if(validString) return n;

        int start = 0, end = 0;
        while(start < n && end < n){
            char cur = s.charAt(end);
            if(arr[cur - 'a'] < k){
                max = Math.max(max, longestSubstring(s.substring(start, end), k));
                start = end + 1;
            }
            end++;
        }
        max = Math.max(max, longestSubstring(s.substring(start, end), k));
        return max;

    }
}
