package books.ctci.recursion.quetion;

import java.util.ArrayList;
import java.util.List;

public class _8_2_RobotInGrid {
    private static boolean[][] visit;

    public static List<String> findPath(int[][] grid){
        visit = new boolean[grid.length][grid.length];
        List<String>  list = move(grid, 0, 0, new ArrayList<>());

        return list;
    }

    private static List<String> move(int[][] grid, int i, int j, List<String> path) {
        if(i >= grid.length || j >= grid.length) return path;

        if(!visit[i][j]) {
            visit[i][j] = true;
            if (grid[i][j] == 1) {
                path.add("(" + i + "," + j + ")");
            }
            move(grid, i + 1, j, path);
            move(grid, i, j + 1, path);
        }
        return path;
    }

    public static void main(String[] args) {
        int[][] grid = new int[4][4];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                grid[i][j] = 0;
            }
        }
        grid[0][0] = 1;
        grid[0][3] = 1;

        grid[1][1] = 1;
        grid[2][2] = 1;
        grid[3][3] = 1;

        System.out.println(findPath(grid));

    }
}
