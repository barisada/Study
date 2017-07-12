package sedgewick_algorithm.bigraph;

import edu.princeton.cs.algs4.Digraph;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by jw on 2017-07-12.
 */
public class Bigraph {
    private int v;      // # of vertices
    private List<List<Integer>> adjancencyList;

    public Bigraph(int v){
        this.v = v;
        this.adjancencyList = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adjancencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w){
        adjancencyList.get(v).add(w);
    }

    public List<Integer> adj(int v){
        return adjancencyList.get(v);
    }

    public int getV(){
        return v;
    }

    public int getE(){
        return (int) adjancencyList.stream().map(List::size).count();
    }

    public Digraph reverse(){
        return null;
    }

    public String toString(){
        StringJoiner sj = new StringJoiner(System.getProperty("line.separator"));
        for(int i = 0; i < adjancencyList.size(); i++){
            for(int v : adjancencyList.get(i)){
                sj.add(i + " -> " + v);
            }
        }
        return sj.toString();
    }
}
