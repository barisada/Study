package interviewPrep.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        transform(S, 0, result);
        if(result.size() == 0) result.add(S);
        return result;
    }

    public void transform(String str, int pos, List<String> result){
        int begin = (int) 'A';
        int end = (int) 'z';

        if(pos == str.length()) return;

        char c = str.charAt(pos);
        if(c <= end && c >= begin){
            if(!result.contains(str)) result.add(str);
            transform(str, pos + 1, result);

            String up = 'Z' < c ? String.valueOf(c).toUpperCase() : String.valueOf(c).toLowerCase();
            up = str.substring(0, pos) + up + str.substring(pos + 1, str.length());
            if(!result.contains(up)) result.add(up);
            transform(up, pos + 1, result);

        } else {
            transform(str, pos + 1, result);
        }

    }
}
