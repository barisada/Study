package internet_lecture.coursera.sedgewick_algorithm.graph;

/**
 * Created by jwlee1 on 2017. 7. 12..
 */
public class DepthFirstSearch {
	private Boolean[] marked;
	private Integer[] edgeTo;
	private int s;

	public DepthFirstSearch(Graph g, int s){
		this.marked = new Boolean[g.getVerticeSize()];
		for(int i = 0; i < marked.length; i++){
			marked[i] = false;
		}
		this.edgeTo = new Integer[g.getEdgeSize()];
		for(int i = 0; i < edgeTo.length; i++){
			edgeTo[i] = -1;
		}
		this.s = s;
		dfs(g, s);
	}

	private void dfs(Graph g, int v) {
		marked[v] = true;
		for(int w : g.adjacency(v)){
			if(marked[w]){
				//if already visited, do nothing
			} else {
				dfs(g, w);
				edgeTo[w] = v;
			}
		}
	}

	public Boolean[] getMarked() {
		return marked;
	}

	public Integer[] getEdgeTo() {
		return edgeTo;
	}
}
