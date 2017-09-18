package hackerrank.algorithm.search;


import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by jw on 2017-09-18.
 */
public class MissingNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int ar1[] = new int[first];
        for(int i = 0; i < first; i++){
            ar1[i] = sc.nextInt();
        }

        int second = sc.nextInt();
        int ar2[] = new int[second];
        for(int i = 0; i < second; i++){
            ar2[i] = sc.nextInt();
        }
        StopWatch sw = new StopWatch();
        sw.start("missing number");
        getMissingNumber(ar1, ar2);
        sw.stop();

        sw.start("fast missing number");
        getFastMissingNumber(ar1, ar2);
        sw.stop();
        System.out.println(sw.prettyPrint());
    }

    private static void getFastMissingNumber(int[] ar1, int[] ar2) {
        int min = Arrays.stream(ar2).min().getAsInt();
        int[] aux = new int[ar2.length];
        for(int i = 0; i < aux.length; i++){
            aux[ar2[i] - min]++;
        }
        for(int i = 0; i < ar1.length; i++){
            aux[ar1[i] - min]--;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < aux.length; i++){
            if(aux[i] > 0){
                list.add(i + min);
            }
        }
        System.out.println(list.stream().map(String::valueOf).distinct().collect(Collectors.joining(" ")));
    }

    private static void getMissingNumber(int[] ar1, int[] ar2) {
        ar1 = Arrays.stream(ar1).sorted().toArray();
        ar2 = Arrays.stream(ar2).sorted().toArray();

        List<Integer> list = new ArrayList<>();
        int shift = 0;
        for(int i = 0; i < ar2.length; i++){
            if((i + shift) >= ar1.length){
                list.add(ar2[i]);
            } else if(ar1[i + shift] != ar2[i]){
                list.add(ar2[i]);
                shift--;
            }
        }

        System.out.println(list.stream().map(String::valueOf).distinct().collect(Collectors.joining(" ")));
    }

}
