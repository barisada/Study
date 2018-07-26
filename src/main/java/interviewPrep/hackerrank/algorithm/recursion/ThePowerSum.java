package interviewPrep.hackerrank.algorithm.recursion;

import java.util.Scanner;

/**
 * Created by jw on 2017-09-12.
 */
public class ThePowerSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int exp = sc.nextInt();

        int answer = findNumberOfWay(target, exp, 1, 0);
        System.out.println(answer);
    }

    private static int findNumberOfWay(int target, int exp, int base, int sum) {
        int val = (int) Math.pow(base, exp);
        if((val + sum)  == target){
            return 1;
        } else if(val > target || (val + sum) > target){
            return 0;
        } else {
            return findNumberOfWay(target, exp, base+1, (val + sum)) + findNumberOfWay(target, exp, base+1, sum);
        }
    }

}
