package dailycoding.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 * leetcode #451
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        SortCharactersByFrequency test = new SortCharactersByFrequency();
        System.out.println("should be eert or eetr : " + test.frequencySort("tree"));
        System.out.println("should be aaaccc or cccaaa : " + test.frequencySort("cccaaa"));
        System.out.println("should be bbAa or bbaA : " + test.frequencySort("Aabb"));
    }

    public String frequencySort(String s) {
        int[] arr = new int[128];
        for(char c : s.toCharArray()){
            arr[c]++;
        }
        Queue<Pair> queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.val, p1.val));
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                queue.offer(new Pair(i, arr[i]));
            }
        }
        System.out.println(queue);

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int idx = queue.poll().idx;
            for(int i = 0; i < arr[idx]; i++){
                sb.append((char) idx);
            }
        }
        return sb.toString();
    }

    class Pair{
        int idx;
        int val;
        public Pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + (char) idx + "(" + val +")";
        }
    }
}
