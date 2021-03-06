package internet_lecture.coursera.sedgewick_algorithm.a1.union_find;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jw on 2017-04-09.
 */
public class UnionFindClient {
    static int size = 10;
    static List<Integer> list = Arrays.asList(4,3,6,9,2,5,7,6,7);
    static List<Integer> list2 = Arrays.asList(3,8,5,4,1,0,2,1,3);

    public static void main(String[] args) {
        //quickUnionTest();
        //wqupathcompressionTest();
        weightedQUTest();


    }

    public static void wqupathcompressionTest(){
        QuickUnionPathCompression quwpc = new QuickUnionPathCompression(size);
        create(quwpc, list, list2);
        System.out.println(quwpc.toString());
        System.out.println(quwpc.count());
    }

    public static void weightedQUTest(){
        QuickUnionWeighted quw = new QuickUnionWeighted(size);
        create(quw, list, list2);
        System.out.println(quw.toString());
        System.out.println(quw.count());
    }

    private static void quickUnionTest() {
        QuickUnionUF quickUnion = new QuickUnionUF(size);
        create(quickUnion, list, list2);
        System.out.println(quickUnion.toString());
        System.out.println(quickUnion.count());
    }

    private static void create(UnionFind uf, List<Integer> list, List<Integer> list2) {
        for(int i = 0; i < list.size();i++){
            int p = list.get(i);
            int q= list2.get(i);
            if(!uf.connected(p,q)){
                uf.union(p,q);
                System.out.println(p + " " + q);
                System.out.println(uf.toString());
            } else {
                System.out.println(p + " " + q + " same");
            }
        }
    }
}
