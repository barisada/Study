package sedgewick_algorithm.bigraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jw on 2017-07-12.
 */
public class BigraphClient {

    public static void main(String...args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/bigraph/tinyDAG.txt"));
        Bigraph bigraph = new Bigraph(Integer.valueOf(br.readLine()));
        int edges = Integer.valueOf(br.readLine());
        for(int i = 0; i < edges; i++){
            String[] pair = br.readLine().split(" ");
            bigraph.addEdge(Integer.valueOf(pair[0]), Integer.valueOf(pair[1]));
        }
        System.out.println(bigraph);
        TopologicalSort ts = new TopologicalSort(bigraph);
        System.out.println(ts.getPostorserStack());
    }
}
