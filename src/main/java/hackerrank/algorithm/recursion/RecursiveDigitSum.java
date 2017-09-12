package hackerrank.algorithm.recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jw on 2017-09-12.
 */
public class RecursiveDigitSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int k = sc.nextInt();

        int sd = superDigit(n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k; i++){
            sb.append(sd);
        }
        int answer = superDigit(sb.toString());
        System.out.println(answer);
    }

    private static int superDigit(String s) {
        if(s.length() == 1){
            return Integer.valueOf(s);
        } else {
            return superDigit(String.valueOf(Arrays.stream(s.split("")).map(Integer::valueOf).mapToInt(i -> i).sum()));
        }
    }
}
