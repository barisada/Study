package interviewPrep.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class _006_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int idx = 0;
        boolean down = true;
        for (char c : s.toCharArray()) {
            if(down){
                StringBuilder row = list.get(idx);
                row.append(c);
                idx++;
            } else {
                StringBuilder row = list.get(idx);
                row.append(c);
                idx--;
            }
            if(idx == numRows){
                idx = idx - 2;
                down = false;
            }
            if(idx == 0) down = true;
        }
        String str = list.stream().reduce(StringBuilder::append).get().toString();
        return str;
    }

    public static void main(String[] args) {
        _006_ZigZag_Conversion conversion = new _006_ZigZag_Conversion();
        System.out.println(conversion.convert("PAYPALISHIRING", 3));
    }
}
