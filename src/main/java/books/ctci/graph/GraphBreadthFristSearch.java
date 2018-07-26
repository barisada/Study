package books.ctci.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBreadthFristSearch {
    Graph graph;
    boolean[] visit;

    public GraphBreadthFristSearch(Graph graph) {
        this.graph = graph;
        visit = new boolean[graph.getNumberOfVertices()];
    }

    public void bfs(Vertex root){
        Queue<Vertex> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Vertex v = q.poll();
            if(v != null){
                doVisit(v);
                for(Vertex adjV : graph.getAdjList().get(v.getVal())){
                    if(!visit[adjV.getVal()]) {
                        q.add(adjV);
                    }
                }
            }
        }
    }

    private void doVisit(Vertex v) {
        if(!visit[v.getVal()]) {
            visit[v.getVal()] = true;
            System.out.println("visited : " + v.getVal());
        }
    }

}
