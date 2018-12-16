package dailycoding.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeating test = new LongestSubstringWithoutRepeating();
        String test1 = "abcabbbcad";
        String test2 = "pwwkew";
        String test3 = "bpfbhmipx";
        System.out.println("should be 4 : " + test.longest(test1));
        System.out.println("should be 3 : " + test.longest(test2));
        System.out.println("should be 7 : " + test.longest(test3));

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
