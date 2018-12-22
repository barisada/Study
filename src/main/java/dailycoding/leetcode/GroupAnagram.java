package dailycoding.leetcode;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagram {
    public static void main(String[] args) {
        String[] test1 = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagram test = new GroupAnagram();
        System.out.println(test.groupAnagrams(test1));
        System.out.println(test.groupAnagrams2(test1));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return Collections.emptyList();

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] arr = new int[26];
            for(char c : s.toCharArray()) arr[c -'a']++;

            StringBuilder sb = new StringBuilder();
            for(int i : arr) sb.append(i + "#");

            if(!map.containsKey(sb.toString())) map.put(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
