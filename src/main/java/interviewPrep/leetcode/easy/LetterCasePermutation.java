package interviewPrep.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        transform(S, 0, result);
        return result;
    }

    public void transform(String str, int pos, List<String> result){
        int begin = (int) 'A';
        int end = (int) 'z';

        if(pos == str.length()) {
            result.add(str);
            return;
        }

        char c = str.charAt(pos);
        if(c <= end && c >= begin){
            transform(str, pos + 1, result);

            String up = 'Z' < c ? String.valueOf(c).toUpperCase() : String.valueOf(c).toLowerCase();
            up = str.substring(0, pos) + up + str.substring(pos + 1, str.length());
            transform(up, pos + 1, result);

        } else {
            transform(str, pos + 1, result);
        }

    }
}
