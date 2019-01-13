package dailycoding;

import java.util.Arrays;
import java.util.List;

/**
 * 보드 상하반전하는 알고리즘을 만들어라
 * x는 보더를 나타냄.
 * w는 화이트
 * b는 블랙
 * 모든게 화이트 보드면 input : w, output : w
 * 모든게 블랙 보드면 input : b, output : b
 * 보드를 4등분하여 topleft가 화이트 나머지 블랙: input : xwbbb , output : xbbwb
 */
public class Sb_Problem_01 {
    public static void main(String[] args) {
        String test = "xwbbb";
        String result = reverse(test);
        System.out.println("should be xbbwb : " + result + " ("  + "xbbwb".equals(result) + " )");

        test = "xxwbbbbwb";
        result = reverse(test);
        System.out.println("should be xwbxbbwbb : " + result + " ("  + "xwbxbbwbb".equals(result) + " )");

        test = result;
        result = reverse(test);
        System.out.println("should be xxwbbbbwb : " + result + " ("  + "xxwbbbbwb".equals(result) + " )");

        List<String> testcases = Arrays.asList("w", "xbwwb", "xbwxwbbwb", "xxwwwbxwxwbbbwwxxxwwbbbwwwwbb");
        List<String> results = Arrays.asList("w", "xwbbw", "xxbwwbbbw", "xxwbxwwxbbwwbwbxwbwwxwwwxbbwb");
        for(int i = 0; i < testcases.size(); i++){
            result = reverse(testcases.get(i));
            System.out.println(i + " : " + result.equals(results.get(i)));
        }

    }

    public static String reverse(String input){
        if(input.startsWith("x")){
            return "x" + helper(input.substring(1));
        }

        return input;
    }

    private static String helper(String str) {
        String[] arr = new String[4];
        int strIdx = 0;
        for(int i = 0; i < arr.length; i++){
            char cur = str.charAt(strIdx);
            if(cur == 'x'){
                arr[i] = "x" + helper(str.substring(strIdx + 1));
                strIdx += arr[i].length();
            } else {
                arr[i] = String.valueOf(cur);
                strIdx++;
            }
        }
        swap(arr, 0, 2);
        swap(arr, 1, 3);
        StringBuilder sb = new StringBuilder();
        for(String s : arr) sb.append(s);
        return sb.toString();
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
