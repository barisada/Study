package internet_lecture.coursera.sedgewick_algorithm.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by jwlee1 on 2017. 7. 12..
 */
public class Graph{
	private int v;       //vertices
	private List<List<Integer>> adjacencyList;

	//init
	public Graph(int v){
		this.v = v;
		this.adjacencyList = new ArrayList<>();
		for(int i = 0; i < v; i++){
			adjacencyList.add(new ArrayList<>());
		}

	}

	//add an edge v-w
	public void addEdge(int v, int w){
		adjacencyList.get(v).add(w);
		adjacencyList.get(w).add(v);
	}

	//vertices adjacent to v
	public List<Integer> adjacency(int v){
		return adjacencyList.get(v);
	}

	//number of vertices
	public int getVerticeSize(){
		return v;
	}

	//number of edges
	public int getEdgeSize(){
		return (int) adjacencyList.stream().map(adj -> adj.size()).count();
	}

	public int getV() {
		return v;
	}

	public List<List<Integer>> getAdjacencyList() {
		return adjacencyList;
	}
	public String toString(){
		StringJoiner sj = new StringJoiner(", ");
		for(int i = 0; i < v; i++){
			for(int v : adjacencyList.get(i)){
				sj.add(i + "-" + v);
			}
		}
		return sj.toString();
	}
}
