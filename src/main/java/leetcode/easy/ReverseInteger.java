package leetcode.easy;

public class ReverseInteger {
    public int reverse(int x) {
        long mul = 10;
        long ans = 0;
        int temp = x;

        if(x / 10 == 0){
            return x;
        }

        while (temp != 0) {
            long  rem = temp % 10;
            temp = temp / 10;
            ans *= mul;
            ans += rem;
        }
        return (long) Integer.MIN_VALUE < ans && ans < (long) Integer.MAX_VALUE
                ? (int) ans : 0;
    }
}
