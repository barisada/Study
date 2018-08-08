package internet_lecture.alg_pknu_ac_kr.lecture._07_graph_algorithm;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<List<Integer>> adjList;
    private int[][] adjMatrix;

    public Graph(int size) {
        this.adjList = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            adjList.add(new ArrayList<>());
        }
        this.adjMatrix = new int[size][size];
    }

    public void addEdge(int i, int j){
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;

        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public boolean isConnected(int i, int j){
        boolean byAdjList = adjList.get(i).contains(j);
        boolean byAdjMatrix = adjMatrix[i][j] == 1;

        return byAdjList || byAdjMatrix;
    }

    public int numberOfAdjacent(int v){
        int byAdjList = adjList.get(v).size();
        int byAdjMatrix = 0;
        for(int i = 0; i < adjMatrix.length; i++){
            if(adjMatrix[v][i] != 0){
                byAdjMatrix++;
            }
        }
        return Math.max(byAdjList, byAdjMatrix);

    }

    public List<List<Integer>> getAdjList() {
        return adjList;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
}
