package internet_lecture.alg_pknu_ac_kr.lecture._09_dynamic_programming;

import java.util.Arrays;

public class DP_05_Longest_common_subsequence {
    public static void main(String[] args) {
        String s = "abcbdab";
        String t = "bdcaba";
        StringBuilder sb = new StringBuilder();
        int[][] lcs = new int[s.length()][t.length()];

        int longest = lcs(s, t, lcs);
        System.out.println(longest);
        for(int[] row : lcs){
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * "bcdb"는 "abcbdab"의 subsequence이다.
     * "bca"는 "abcbdab" 와 "bdcaba"의 common subsequence이다.
     *
     * common subsequence 중 가장 긴것을 찾으시오.
     * 위의경우 bcba 가 가장긴 커먼 서브시퀀스이다.
     * @param s
     * @param t
     * @param lcs
     */
    public static int lcs(String s, String t, int[][] lcs){
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    if(i - 1 >= 0 && j - 1 >= 0){
                        lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    } else {
                        lcs[i][j] = 1;
                    }
                } else {
                    if(i - 1 >= 0 && j - 1 >=0){
                        lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j -1]);
                    } else {
                        lcs[i][j] = 0;
                    }
                }
            }
        }
        return lcs[s.length()  -1 ][t.length() - 1];
    }


}
