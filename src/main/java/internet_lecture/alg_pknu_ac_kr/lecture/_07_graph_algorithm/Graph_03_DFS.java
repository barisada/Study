package internet_lecture.alg_pknu_ac_kr.lecture._07_graph_algorithm;

import java.util.List;
import java.util.Stack;

public class Graph_03_DFS {

    /**
     * recursive
     * @param g
     * @param start
     * @param visit
     */
    void dfs(Graph g, int start, boolean[] visit){
        List<Integer> adjList = g.getAdjList().get(start);

        System.out.println("dfs recursive: " + start);
        visit[start] = true;
        for(int v : adjList){
            if(!visit[v]){
                dfs(g, v, visit);
            }
        }
    }

    //use stack
     void dfs(Graph g, int start){
        List<List<Integer>> adjList = g.getAdjList();
        boolean[] visit = new boolean[adjList.size()];

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        System.out.print("dfs stack : ");
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!visit[node]){
                System.out.print(node + " ");
                visit[node] = true;
                for(int v : adjList.get(node)){
                    stack.push(v);
                }
            }
        }
        System.out.println();
     }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(1,3);
        g.addEdge(1,2);
        g.addEdge(2,4);
        g.addEdge(3,7);
        g.addEdge(3,5);
        g.addEdge(3,8);
        g.addEdge(4,5);
        g.addEdge(5,6);
        g.addEdge(7,8);

        Graph_03_DFS dfs = new Graph_03_DFS();
        boolean[] visit = new boolean[g.getAdjList().size()];
        dfs.dfs(g, 1, visit);
        dfs.dfs(g, 1);
    }
}
