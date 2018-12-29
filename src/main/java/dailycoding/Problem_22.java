package dailycoding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list.
 * If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
 *
 * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
 * you should return ['the', 'quick', 'brown', 'fox'].
 *
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
 * return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 *
 * leetcode #139
 */
public class Problem_22 {
    public static void main(String[] args) {
        Problem_22 test = new Problem_22();
        List<String> list = Arrays.asList("quick", "brown", "the", "fox");
        System.out.println("should be true : " + test.wordBreak("thequickbrownfox", list));

        List<String> list2 = Arrays.asList("bed", "bath", "bedbath", "and", "beyond");
        System.out.println("should be true : " + test.wordBreak("bedbathandbeyond", list2));

        List<String> list3 = Arrays.asList("aaaa", "aaa");
        System.out.println("should be true : " + test.wordBreak("aaaaaaa", list3));

        List<String> list4 = Arrays.asList("go", "goal", "goals", "special");
        System.out.println("should be true : " + test.wordBreak("goalspecial", list4));

        List<String> list5 = Arrays.asList("aa", "bb", "cc");
        System.out.println("should be false : " + test.wordBreak("aabbccdaabbccd", list5));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String sub = s.substring(j, i);
                if(dp[j] && wordDict.contains(sub)){
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
