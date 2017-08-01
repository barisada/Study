package ourstudy.skt.test.answers;

import java.util.*;

/**
 * Created by jwlee1 on 2017. 7. 14..
 * http://blog.naver.com/yubhh21/220867303992
 * 마나처 알고리듬 설명
 */
@SuppressWarnings("Duplicates")
public class _Third_CountPalindrome2 {
    public int[]  p;  // p[i] = length of longest palindromic substring of t, centered at i
    public String s;  // original string
    public char[] t;  // transformed string

    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        List<Integer> count = new ArrayList<>();
        for(int i = 0; i < total;i++){
            int length = sc.nextInt();
            String text = sc.next();
            _Third_CountPalindrome2 third = new _Third_CountPalindrome2();
            third.manacher(text);
            for(int temp : third.p){
                System.out.print(temp + ", ");
            }
            System.out.println();
        }

        sc.close();
    }
    private void manacher(String s) {
        this.s = s;
        preprocess();
        p = new int[t.length];

        int center = 0, right = 0;
        for (int i = 1; i < t.length-1; i++) {
            int mirror = 2*center - i;

            if (right > i)
                p[i] = Math.min(right - i, p[mirror]);

            // attempt to expand palindrome centered at i
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) {
                p[i]++;
            }
            // if palindrome centered at i expands past right,
            // adjust center based on expanded palindrome.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
    }

    // Transform s into t.
    // For example, if s = "abba", then t = "$#a#b#b#a#@"
    // the # are interleaved to avoid even/odd-length palindromes uniformly
    // $ and @ are prepended and appended to each end to avoid bounds checking
    private void preprocess() {
        t = new char[s.length()*2 + 3];
        t[0] = '$';
        t[s.length()*2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2*i + 1] = '#';
            t[2*i + 2] = s.charAt(i);
        }
        t[s.length()*2 + 1] = '#';
    }
}
