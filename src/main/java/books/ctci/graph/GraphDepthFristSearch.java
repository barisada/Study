package books.ctci.graph;

public class GraphDepthFristSearch {
    Graph graph;
    boolean[] visit;

    public GraphDepthFristSearch(Graph graph) {
        this.graph = graph;
        visit = new boolean[graph.getNumberOfVertices()];
    }

    public void dfs(Vertex root){
        if(root == null) return;

        doVisit(root);

        for(Vertex v : graph.getAdjList().get(root.getVal())){
            if(!visit[v.getVal()]){
                dfs(v);
            }
        }
    }

    private void doVisit(Vertex v) {
        visit[v.getVal()] = true;
        System.out.println("visited : " +  v.getVal());
    }
}
