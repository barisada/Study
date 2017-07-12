package sedgewick_algorithm.bigraph;

import java.util.List;
import java.util.Stack;

/**
 * Created by jw on 2017-07-13.
 */
public class TopologicalSort {
    private Boolean[] marked;
    private Stack<Integer> postorderStack;

    public TopologicalSort(Bigraph g){
        marked = new Boolean[g.getV()];
        postorderStack = new Stack<>();
        for(int i = 0; i < marked.length; i++){
            marked[i] = false;
        }
        for(int i = 0; i < marked.length; i++){
            if(!marked[i]){
                dfs(g, i);
            }
        }
    }

    private void dfs(Bigraph g, int v) {
        marked[v] = true;
        List<Integer> adj = g.adj(v);
        adj.sort(Integer::compareTo);
        adj.stream().filter(w -> !marked[w]).forEach(w -> dfs(g, w));
        postorderStack.push(v);
    }

    public Stack<Integer> getPostorserStack(){
        return postorderStack;
    }

}
