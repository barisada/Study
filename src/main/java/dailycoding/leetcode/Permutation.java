package dailycoding.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(stringPermutation("abc"));

        int[] test1 = {1,2,3,4};
        System.out.println(integerPermutation(test1));

    }

    public static List<List<Integer>> integerPermutation(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        integerPermutation(arr, result, 0);
        return result;
    }

    public static void integerPermutation(int[] arr, List<List<Integer>> result, int level){
        if(level == arr.length){
            List<Integer> list = new ArrayList<>();
            for(int i :  arr) list.add(i);
            result.add(list);
        } else {
            for(int i = level; i < arr.length; i++){
                swap(arr, level, i);
                integerPermutation(arr, result, level + 1);
                swap(arr, level, i);
            }
        }
    }

    private static void swap(int[] arr, int level, int i) {
        int temp = arr[level];
        arr[level] = arr[i];
        arr[i] = temp;
    }


    public static List<String> stringPermutation(String str) {
        List<String> result = new ArrayList<>();
        stringPermutation("", str, result);
        return result;
    }

    private static void stringPermutation(String prefix, String str, List<String> result) {
        if(str.length() == 0) result.add(prefix);
        else {
            for(int i = 0; i < str.length(); i++){
                stringPermutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), result);
            }
        }
    }
}
