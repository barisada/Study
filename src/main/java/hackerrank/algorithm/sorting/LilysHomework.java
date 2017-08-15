package hackerrank.algorithm.sorting;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jw on 2017-08-15.
 */
public class LilysHomework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] before = IntStream.range(0, size).map(i -> sc.nextInt()).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++){
            map.put(before[i], i);
        }

        int[] asc = Arrays.stream(before).sorted().toArray();
        int[] desc = Arrays.stream(before).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();

        int count1 = getSwapCount(new HashMap<>(map), Arrays.copyOf(before, size), asc);
        int count2 = getSwapCount(map, Arrays.copyOf(before, size), desc);
        System.out.println(count1 > count2 ? count2 : count1);

    }

    private static int getSwapCount(Map<Integer, Integer> map, int[] before, int[] sorted) {
        int count = 0;
        for(int i = 0; i < before.length; i++){
            if(sorted[i] != before[i]){
                int index = map.get(sorted[i]);
                int temp = before[i];
                before[i] = before[index];
                before[index] = temp;
                map.put(before[i], i);
                map.put(before[index], index);
                count++;
            }
        }
        return count;
    }

}
