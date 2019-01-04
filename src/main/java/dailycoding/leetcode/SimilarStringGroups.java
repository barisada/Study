package dailycoding.leetcode;

import java.util.*;

/**
 * Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
 *
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".
 *
 * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
 *
 * We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?
 *
 * Example 1:
 *
 * Input: ["tars","rats","arts","star"]
 * Output: 2
 * Note:
 *
 * A.length <= 2000
 * A[i].length <= 1000
 * A.length * A[i].length <= 20000
 * All words in A consist of lowercase letters only.
 * All words in A have the same length and are anagrams of each other.
 * The judging time limit has been increased for this question.
 */
public class SimilarStringGroups {
    public static void main(String[] args)  {
        SimilarStringGroups test = new SimilarStringGroups();
        String[] arr = {"tars","rats","arts","star"};
        System.out.println("should be 2 : " + test.numSimilarGroups(arr));

        String[] arr2 = {"ajdidocuyh","djdyaohuic","ddjyhuicoa","djdhaoyuic","ddjoiuycha","ddhoiuycja","ajdydocuih","ddjiouycha","ajdydohuic","ddjyouicha"};
        System.out.println("should be 2 : " + test.numSimilarGroups(arr2));
    }

    public int numSimilarGroups(String[] A) {
        Map<String, Set<String>> map = new HashMap<>();
        for(String word : A) map.put(word, new HashSet<>());

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                String cur = A[i];
                String target = A[j];
                Set<String> set = map.get(cur);
                if(cur.equals(target) || cur.contains(target)) continue;
                if(isSimilar(cur, target)){
                    set.add(target);
                    map.get(target).add(cur);
                }
            }
        }

        int id = 0;
        Set<String> visit = new HashSet<>();
        Map<String, Integer> group = new HashMap<>();
        for(String word : map.keySet()){
            Queue<String> queue = new LinkedList<>();
            queue.add(word);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    String key = queue.poll();
                    if(!visit.contains(key)) {
                        visit.add(key);
                        group.put(key, id);
                        Set<String> set = map.get(key);
                        queue.addAll(set);
                    }
                }
            }
            id++;
        }
        return (int) group.values().stream().distinct().count();
    }

    private boolean isSimilar(String s, String t){
        int diff = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)) diff++;
        }
        return diff == 2;
    }
}
