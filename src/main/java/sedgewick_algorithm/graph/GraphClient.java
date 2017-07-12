package sedgewick_algorithm.graph;

import java.util.Arrays;

/**
 * Created by jwlee1 on 2017. 7. 12..
 */
public class GraphClient {
	/*
	test input
	13 -> #of vertices
	13 -> #of edge
	0 5
	4 3
	0 1
	9 12
	6 4
	5 4
	0 2
	11 12
	9 10
	0 6
	7 8
	9 11
	5 3
	 */
	public static void main(String...args){
		Graph g = new Graph(13);
		g.addEdge(0,5);
		g.addEdge(4,3);
		g.addEdge(0,1);
		g.addEdge(9,12);
		g.addEdge(6,4);
		g.addEdge(5,4);
		g.addEdge(0,2);
		g.addEdge(11,12);
		g.addEdge(9,10);
		g.addEdge(0,6);
		g.addEdge(7,8);
		g.addEdge(9,11);
		g.addEdge(5,3);
		System.out.println(g.getEdgeSize());


		DepthFirstSearch dfs = new DepthFirstSearch(g, 7);
		System.out.println(Arrays.asList(dfs.getMarked()));
		System.out.println(Arrays.asList(dfs.getEdgeTo()));
	}
}
