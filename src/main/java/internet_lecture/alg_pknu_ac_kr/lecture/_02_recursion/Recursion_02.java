package internet_lecture.alg_pknu_ac_kr.lecture._02_recursion;

import java.util.Arrays;
import java.util.Stack;

/**
 * Recursive Thinking
 * 순환적 사고
 */
public class Recursion_02 {
    public static void main(String[] args) {
        String str = "abcdef";
        int length = stringLength(str);
        System.out.println(str + " length = " + length);

        int length2 = stringLengthUsingStack(str);
        System.out.println(str + " length (using stack) = " + length2);

        System.out.print(str + "을 출력한다 : "); printChars(str);
        System.out.print(str + " 을 역으로 출력한다: ");printCharsReverse(str);
        System.out.println();

        int n = 7;
        System.out.print(n + "을 바이너리로 출력한다."); printBinary(n);
        System.out.println();

        int[] data = {1,2,3,4,5};
        System.out.println(Arrays.toString(data) + "의 합을 출력한다. : " + sum(data.length, data));
    }

    /**
     * 스트링 길이를 구하는 메소드.
     * string length = n 일때
     * n = n -1
     * @param str
     * @return
     */
    private static int stringLength(String str) {
        if(str.equals("")){
            return 0;
        }
        return 1 + stringLength(str.substring(1));
    }

    private static int stringLengthUsingStack(String str) {
        Stack<Integer> stack = new Stack<>();
        while(!str.equals("")){
            stack.push(1);
            str = str.substring(1);
        }

        int count = 0;
        while(!stack.isEmpty()){
            count += stack.pop();
        }

        return count;
    }

    /**
     * 주어진 스트링을 출력하는 메소드
     * recursion방식으로...
     * @param str
     */
    private static void printChars(String str) {
        if(stringLength(str) == 0) {
            System.out.println();
            return;
        }
        System.out.print(str.charAt(0));
        printChars(str.substring(1));
    }

    /**
     * 주어진 스트링을 거꾸로 출력하는 메소드
     * @param str
     */
    private static void printCharsReverse(String str) {
        if(stringLength(str) == 0) {
            return;
        }
        printCharsReverse(str.substring(1));
        System.out.print(str.charAt(0));
    }

    /**
     * 양수 숫자 n을 이진수로 출력한다.
     * @param n
     */
    private static void printBinary(int n) {
        if(n < 2){
            System.out.print(n);
        } else {
            printBinary(n / 2);
            System.out.print( n % 2);
        }
    }

    /**
     * data[0]에서 data[n - 1] 까지의 합을 구하는 메소드
     * @param n
     * @param data
     */
    private static int sum(int n, int[] data){
        if(n == 0) return 0;
        return data[n - 1] + sum(n - 1, data);

    }

}
