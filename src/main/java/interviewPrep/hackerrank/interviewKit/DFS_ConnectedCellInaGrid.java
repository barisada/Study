package interviewPrep.hackerrank.interviewKit;

public class DFS_ConnectedCellInaGrid {
    static boolean[][] visit;
    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    static int dfs(int[][] grid, int i, int j){
        if(i < 0
                || j < 0
                || i >= grid.length
                || j >= grid[i].length

                ) return 0;

        if(!visit[i][j]){
            visit[i][j] = true;
            if(grid[i][j] > 0){

                return 1 + dfs(grid, i, j+1) +
                        dfs(grid, i + 1, j) +
                        dfs(grid, i + 1, j + 1) +
                        dfs(grid, i - 1, j) +
                        dfs(grid, i, j - 1) +
                        dfs(grid, i - 1, j - 1) +
                        dfs(grid, i -1, j + 1) +
                        dfs(grid, i + 1, j - 1)
                        ;
            }
        }

        return 0;
    }
}
