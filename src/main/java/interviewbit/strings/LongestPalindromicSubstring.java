package interviewbit.strings;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String A) {
        Set<String> parindromes = new LinkedHashSet<>();

        int max = 0;
        for(int i = 0; i < A.length() && A.length() - i >= max; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < A.length(); j++){
                sb.append(A.charAt(j));
                if(isPalindrome(sb.toString())){
                    parindromes.add(sb.toString());
                    max = Math.max(max, sb.length());
                }
            }
        }

        return parindromes.stream().max(Comparator.comparingInt(String::length)).orElse("");
    }

    public boolean isPalindrome(String str){
        if(str == null || str.length() <= 0) return false;
        if(str.length() == 1) return true;
        if(str.length() == 2) return str.charAt(0) == str.charAt(1);

        if(str.length() % 2 != 0) {
            int mid = str.length() / 2;
            String first = str.substring(0, mid);
            String second = new StringBuilder(str.substring(mid + 1, str.length())).reverse().toString();
            return first.equals(second);
        } else {
            int mid = str.length() / 2;
            String first = str.substring(0, mid);
            String second = new StringBuilder(str.substring(mid, str.length())).reverse().toString();
            return first.equals(second);
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome("cacaccbabcabbbaacbbbbcaaaccaacbabcaccbccaacccaacbbaaabbbabcaaabc"));
        System.out.println(lps.isPalindrome("abba"));
    }
}
