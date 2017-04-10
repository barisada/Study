package sedgewick_algorithm.union_find;

import java.util.StringJoiner;

/**
 * Created by jw on 2017-04-09.
 */
public class QuickFindUF implements UnionFind{
    private int[] id;
    private int count;

    /**
     * initialize union-find data structure with
     * N objects (0 to N – 1)
     * @param size
     */
    public QuickFindUF(int size){
        this.count = size;
        this.id = new int[size];
        for(int i = 0; i < size; i++){
            id[i] = i;
        }
    }

    /**
     * add connection between p and q
     * @param p
     * @param q
     */
    public void union(int p, int q){
        if(connected(p, q)){
           return;
        }

        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i++){
            if(id[i] == pid){
                id[i] = qid;
            }
        }
        count--;
    }

    /**
     * are p and q in the same component?
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    /**
     * component identifier for p (0 to N – 1)
     * @param p
     * @return
     */
    public int find(int p){
        return id[p];
    }

    /**
     * number of components
     * @return
     */
    public int count(){
        return this.count;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        StringJoiner sj = new StringJoiner(",");
        for(int i : id){
            sj.add(String.valueOf(i));
        }
        sb.append(sj);
        sb.append("]");
        return sb.toString();
    }
}
