package sedgewick_algorithm.union_find;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jw on 2017-04-09.
 */
public class UnionFindClient {

    public static void main(String[] args) {
        int size = 10;
        QuickFindUF uf = new QuickFindUF(size);

        List<Integer> list = Arrays.asList(4,3,6,9,2,8,5,7,6,1,6);
        List<Integer> list2 = Arrays.asList(3,8,5,4,1,9,0,2,1,0,7);
        for(int i = 0; i < list.size();i++){
            int p = list.get(i);
            int q= list2.get(i);
            if(!uf.connencted(p,q)){
                uf.union(p,q);
                System.out.println(p + " " + q);
            }
        }

        System.out.println(uf.count());
        System.out.print(uf.toString());


    }
}
