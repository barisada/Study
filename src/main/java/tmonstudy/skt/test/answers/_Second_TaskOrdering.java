package tmonstudy.skt.test.answers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jw on 2017-07-08.
 * https://algospot.com/judge/problem/read/ORDERING
 */

/*
TEST CASE
4
4 0
4 2
AB
CB
4 1
DC
4 4
DA
BD
CA
CD
 */
public class _Second_TaskOrdering {
    private static int offset = 65;
    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        int testNum = Integer.valueOf(sc.nextLine());
        for(int i = 0; i < testNum; i++){
            String[] firstLine = sc.nextLine().split(" ");
            int verticeSize = Integer.valueOf(firstLine[0]);
            int edgeSize = Integer.valueOf(firstLine[1]);

            LinkedList<String> list = new LinkedList<>();
            for(int j = 0; j < verticeSize; j++){
                list.add(String.valueOf((char) (j + offset)));
            }
            for(int j = 0; j < edgeSize; j++){
                String[] pair = sc.nextLine().split("");
                String first = pair[0];
                String second = pair[1];
                if(first.compareTo(second) > 0) {
                    int deletepos = list.indexOf(second);
                    list.remove(deletepos);
                    //System.out.println("after delete : " + list);
                    int insertpos = list.indexOf(first) + 1;
                    list.add(insertpos, second);
                    //System.out.println("after insert : " + list);
                }
            }
            System.out.println(list.stream().collect(Collectors.joining("")));
        }
    }
}


