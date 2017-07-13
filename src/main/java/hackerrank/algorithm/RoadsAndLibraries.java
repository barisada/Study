package hackerrank.algorithm;

import java.util.*;

/**
 * Created by jw on 2017-07-13.
 * https://www.hackerrank.com/challenges/torque-and-development/problem
 */
public class RoadsAndLibraries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int cityNum = in.nextInt();
            int roadNum = in.nextInt();
            long libPrice = in.nextLong();
            long roadPrice = in.nextLong();

            Graph g = new Graph(cityNum);
            for(int a1 = 0; a1 < roadNum; a1++){
                int city1 = in.nextInt() - 1;
                int city2 = in.nextInt() - 1;
                g.addEdge(city1, city2);
            }
            /*
             *BFS and DFS derived same result.
             */
            BFS bfs = new BFS(g, roadPrice, libPrice);
            System.out.println(bfs.getTotal());

            DFS dfs = new DFS(g, roadPrice, libPrice);
            System.out.println(dfs.getTotal());
            in.close();
        }
    }
}
class Graph {
    int v;
    List<List<Integer>> adj;

    public Graph(int verticeSize){
        v = verticeSize;
        adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w){
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    public List<Integer> getAdj(int v){
        return adj.get(v);
    }

    public int getV(){
        return v;
    }

    public String toString(){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < v; i++){
            for(int v : adj.get(i)){
                list.add(i + "-" + v);
            }
        }
        return list.toString();
    }
}
class BFS{
    boolean[] marked;
    long total;
    long roadPrice;
    long libPrice;

    public BFS(Graph g, long roadPrice, long libPrice){
        total = 0;
        this.roadPrice = roadPrice;
        this.libPrice = libPrice;
        marked = new boolean[g.getV()];
        for(int i = 0; i < marked.length; i++){
            if(!marked[i]){
                bfs(g, i);
            }
        }
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;
        total += libPrice;  //init library
        while(!q.isEmpty()){
            List<Integer> adj = g.getAdj(q.poll());
            for(int v : adj) {
                if(!marked[v]) {
                    marked[v] = true;
                    total = roadPrice > libPrice ? (total + libPrice) : (total + roadPrice);
                    q.add(v);
                }
            }
        }
    }

    public long getTotal(){
        return total;
    }
}

class DFS{
    boolean[] marked;
    long total;
    long roadPrice;
    long libPrice;

    public DFS(Graph g, long roadPrice, long libPrice){
        total = 0;
        this.roadPrice = roadPrice;
        this.libPrice = libPrice;
        marked = new boolean[g.getV()];
        for(int i = 0; i < marked.length; i++){
            if(!marked[i]){
                dfs(g, i, false);
            }
        }
    }

    private void dfs(Graph g, int i, boolean isLib) {
        marked[i] = true;
        if(isLib){
            total = roadPrice > libPrice ? (total + libPrice) : (total + roadPrice);
        } else {
            total += libPrice;
            isLib = true;
        }
        for(int v : g.getAdj(i)){
            if(!marked[v]){
                dfs(g, v, isLib);
            }
        }
    }

    public long getTotal(){
        return total;
    }

}
/**
 Input:
 5
 9 2 91 84
 8 2
 2 9
 5 9 92 23
 2 1
 5 3
 5 1
 3 4
 3 1
 5 4
 4 1
 5 2
 4 2
 8 3 10 55
 6 4
 3 2
 7 1
 1 0 5 3
 2 0 102 1

 output :
 805
 184
 80
 5
 204

*/