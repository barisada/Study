package dailycoding.leetcode;

import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 *
 * leetcode #140
 */
public class WordBreakII {
    public static void main(String[] args) {
        WordBreakII test = new WordBreakII();
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> dict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(test.wordBreak("catsanddog", dict));
        System.out.println(test.wordBreak("catsandog", dict));
        System.out.println(test.wordBreak("pineapplepenapple", dict2));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }

    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if(map.containsKey(s)){
            return map.get(s);
        }
        List<String> result = new ArrayList<>();
        for(String word : wordDict){
            if(s.startsWith(word)){
                String sub = s.substring(word.length());
                if(sub.isEmpty()){
                    result.add(word);
                } else {
                    List<String> subResult = dfs(sub, wordDict, map);
                    for(String str : subResult){
                        result.add(word + " " + str);
                    }
                }
            }
        }
        map.put(s, result);
        return result;

    }
}
