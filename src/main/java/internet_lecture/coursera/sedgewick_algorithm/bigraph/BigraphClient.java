package internet_lecture.coursera.sedgewick_algorithm.bigraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringJoiner;

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

        Bigraph g = new Bigraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        ts = new TopologicalSort(g);
        StringJoiner sj = new StringJoiner(",");
        while(ts.getPostorserStack().size() > 0){
            sj.add(String.valueOf(ts.getPostorserStack().pop()));
        }
        System.out.println(sj.toString());
    }
}
