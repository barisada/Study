package sedgewick_algorithm.union_find;

import java.util.StringJoiner;

/**
 * Created by jw on 2017-04-10.
 */
public class QuickUnionUF implements UnionFind{
    private int[] id;
    private int count;

    public QuickUnionUF(int size){
        this.count = size;
        this.id = new int[size];
        for(int i = 0; i < size; i++){
            this.id[i] = i;
        }
    }

    public int root(int i){
        while(this.id[i] != i){
            i = this.id[i];
        }
        return i;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        if(connected(p,q)){
            return;
        }

        this.id[this.root(p)] = this.root(q);
        this.count--;
    }

    public int count(){
        return this.count;
    }

    public int find(int p) {
        return this.root(p);
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
