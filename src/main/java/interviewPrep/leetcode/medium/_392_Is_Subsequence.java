package interviewPrep.leetcode.medium;

public class _392_Is_Subsequence {
    public boolean isSubsequence(String s, String t) {

        while(s.length() > 0 && t.length() > 0){
            char c = s.charAt(0);
            s = s.substring(1, s.length());
            int pos = t.indexOf(c);
            if(pos == -1) return false;
            else t = t.substring(pos + 1, t.length());
        }

        return s.length() == 0;

    }
}
