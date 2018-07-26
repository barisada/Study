package books.ctci.graph;

public class GraphSearchClient {
    public static void main(String[] args) {
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        Graph g = new Graph(6);
        g.addEdge(v0, v1);
        g.addEdge(v0, v5);
        g.addEdge(v0, v4);
        g.addEdge(v1, v4);
        g.addEdge(v1, v2);
        g.addEdge(v1, v3);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);

        GraphDepthFristSearch dfs = new GraphDepthFristSearch(g);
        dfs.dfs(v0);
        System.out.println("========================================");
        GraphBreadthFristSearch bfs = new GraphBreadthFristSearch(g);
        bfs.bfs(v0);
    }
}
