package internet_lecture.alg_pknu_ac_kr.lecture._07_graph_algorithm;

import java.util.*;

public class Graph_02_BFS {

    void bfs(Graph g, int start){
        List<List<Integer>> adjList = g.getAdjList();
        boolean[] visit = new boolean[adjList.size()];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int level = 0;
        while(!queue.isEmpty()){
            int currentSize = queue.size();

            for(int i = 0; i < currentSize; i++ ) {
                int node = queue.poll();
                if(!visit[node]) {
                    visit[node] = true;

                    System.out.println("level[" + level + "] : " + node);

                    List<Integer> adj = adjList.get(node);
                    for (int val : adj) {
                        queue.offer(val);
                    }
                }
            }
            level++;
        }
    }

    void path(Graph g, int start){
        List<List<Integer>> adjList = g.getAdjList();
        int[] dist = new int[adjList.size()];
        int[] predecessor = new int[adjList.size()];
        Arrays.fill(dist, -1);
        Arrays.fill(predecessor, -1);

        dist[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int node = queue.poll();

            List<Integer> adj = adjList.get(node);
            for(int val : adj){
                if(dist[val] == -1){
                    dist[val] = dist[node] + 1;
                    predecessor[val] = node;
                    queue.add(val);
                }
            }
        }

        System.out.println("dist : " + Arrays.toString(dist));
        System.out.println("pi   : " + Arrays.toString(predecessor));

        System.out.println("========= shortest path ==========");
        System.out.println(start + " to " + 6);
        printPath(g, start, 6, predecessor);
        System.out.println("================ end =============");

        System.out.println(start + " to " + 7);
        printPath(g, start, 7, predecessor);
        System.out.println("================ end =============");
    }

    void printPath(Graph g, int start, int end, int[] predecessor){
        if(start == end) {
            System.out.println(start);
            return;
        } else if(predecessor[end] == -1) {
            System.out.println("no path from " + start + "  to  " + end + " exist." );
        } else {
            printPath(g, start, predecessor[end], predecessor);
            System.out.println(end);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(3,7);
        g.addEdge(3,8);
        g.addEdge(4,5);
        g.addEdge(5,6);
        g.addEdge(7,8);

        Graph_02_BFS bfs = new Graph_02_BFS();
        bfs.bfs(g, 1);
        bfs.path(g, 1);
    }

}
