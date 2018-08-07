package internet_lecture.coursera.sedgewick_algorithm.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	public static void main(String...args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/graph/tinyCG.txt"));
		Graph g = new Graph(Integer.valueOf(br.readLine()));
		int edges = Integer.valueOf(br.readLine());
		for(int i = 0; i < edges; i++){
			String[] pair = br.readLine().split(" ");
			g.addEdge(Integer.valueOf(pair[0]), Integer.valueOf(pair[1]));
		}
		System.out.println(g.toString());
		BreadthFirstSearch dfs = new BreadthFirstSearch(g, 0);
		System.out.println(Arrays.asList(dfs.getMarked()));
		System.out.println(Arrays.asList(dfs.getEdgeTo()));
		System.out.println(Arrays.asList(dfs.getDist()));


	}
}
