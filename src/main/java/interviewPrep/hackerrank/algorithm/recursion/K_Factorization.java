package interviewPrep.hackerrank.algorithm.recursion;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jw on 2017-09-12.
 */
public class K_Factorization {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int k = sc.nextInt();
        int[] ar = new int[k];
        for(int i = 0; i < k; i++){
            ar[i] = sc.nextInt();
        }
        ar = Arrays.stream(ar).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        factorization(target, ar, 0, list, 0);
        //System.out.println(list);

        List<Integer> answer = list.stream()
                .filter(sub -> !sub.isEmpty())
                .sorted((sub1, sub2) -> {
                    int i = sub1.size();
                    int j = sub2.size();
                    if(i < j ){
                        return -1;
                    } else if( i == j){
                        int com = 0;
                        for(int l = 0; l < sub1.size(); l++){
                            com = Integer.compare(sub1.get(l), sub2.get(l));
                            if(com != 0) return com;
                        }
                        return com;
                    } else {
                        return 1;
                    }
                })
                .findFirst().orElse(new ArrayList<>());
        if(answer.size() > 0){
            answer.add(1);
            StringBuilder sb = new StringBuilder();
            int val = 1;
            for(int i : answer.stream().sorted().collect(Collectors.toList())){
                val *= i;
                sb.append(val);
                sb.append(" ");
            }
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }

    }

    private static void factorization(int target, int[] ar, int base, List<List<Integer>> list, int pos) {
        if(base >= ar.length){
            if(target != 1){
                list.set(pos, new ArrayList<>());
            }
            return;
        }

        int cur = ar[base];
        int rem = target % cur;
        int div = rem == 0 ? target / cur : -1;
        if(div == 1){
            list.get(pos).add(cur);
        } else if(div == -1){
            factorization(target, ar, base + 1, list, pos);
        } else {
            list.get(pos).add(cur);
            List<Integer> copy = new ArrayList<>(list.get(pos));
            factorization(div, ar, base + 1, list, pos);
            pos++;
            list.add(pos, copy);
            factorization(div, ar, base, list,pos);
        }
    }
}
