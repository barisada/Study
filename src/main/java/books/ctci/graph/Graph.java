package books.ctci.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int numberOfVertices;
    private List<List<Vertex>> adjList;
    private List<List<Vertex>> adjMatrix;

    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjList = new ArrayList<>(numberOfVertices);
        adjMatrix = new ArrayList<>(numberOfVertices);

        for(int i = 0; i < numberOfVertices; i++){
            adjList.add(new ArrayList<>());
            adjMatrix.add(new ArrayList<>());
            for(int j = 0; j < numberOfVertices; j++){
                adjMatrix.get(i).add(new Vertex(-1));
            }
        }
    }

    public void addEdge(Vertex v1, Vertex v2){
        adjList.get(v1.getVal()).add(v2);
        adjList.get(v2.getVal()).add(v1);

        adjMatrix.get(v1.getVal()).set(v2.getVal(), v2);
        adjMatrix.get(v2.getVal()).set(v1.getVal(), v1);
    }

    public boolean isConnectedByList(Vertex v1, Vertex v2){
        if(v1.getVal() < adjList.size() && v2.getVal() < adjList.size()) {
            return adjList.get(v1.getVal()).contains(v2);
        }
        return false;
    }

    public boolean isConnectedByMatrix(Vertex v1, Vertex v2){
        if(v1.getVal() < adjMatrix.size() && v2.getVal() < adjMatrix.size()) {

            return adjList.get(v1.getVal()).get(v2.getVal()).getVal() > -1;
        }
        return false;
    }

    public List<List<Vertex>> getAdjList() {
        return adjList;
    }

    public List<List<Vertex>> getAdjMatrix() {
        return adjMatrix;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }
}
