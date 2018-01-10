package leetcode.medium;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        if(s.length() == 1) return 1;

        int max = 0;
        String sub = String.valueOf(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            String next = String.valueOf(s.charAt(i));
            if(!sub.contains(next)){
                sub = sub + next;
            } else {
                if(sub.length() > max) max = sub.length();

                int pos = sub.indexOf(next);
                sub = sub.substring(pos + 1) + next;
            }
        }
        return sub.length() > max ? sub.length() : max;
    }
}
