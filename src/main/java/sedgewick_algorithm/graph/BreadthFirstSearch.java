package sedgewick_algorithm.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jwlee1 on 2017. 7. 13..
 */
public class BreadthFirstSearch {
	private Boolean[] marked;
	private Integer[] edgeTo;
	private Integer[] dist;
	private int source;

	public BreadthFirstSearch(Graph g, int s){
		marked = new Boolean[g.getV()];
		edgeTo = new Integer[g.getV()];
		dist = new Integer[g.getV()];
		this.source = s;
		for(int i = 0; i < g.getV(); i++){
			marked[i] = false;
			edgeTo[i] = -1;
			dist[i] = 0;
		}
		bfs(g, source);
	}

	private void bfs(Graph g, int s) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		marked[s] = true;
		while(!queue.isEmpty()){
			int v = queue.poll();
			List<Integer> adj = g.adjacency(v);
			adj.sort(Integer::compareTo);
			for(int w : adj){
				if(!marked[w]) {
					marked[w] = true;
					edgeTo[w] = v;
					dist[w] = dist[v] + 1;
					queue.add(w);
				}
			}

		}
	}

	public Boolean[] getMarked() {
		return marked;
	}

	public Integer[] getEdgeTo() {
		return edgeTo;
	}

	public Integer[] getDist() {
		return dist;
	}
}
