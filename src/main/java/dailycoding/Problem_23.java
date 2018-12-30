package dailycoding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an M by N matrix consisting of booleans that represents a board.
 * Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
 *
 * Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start.
 * If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.
 *
 * For example, given the following board:
 *
 * [[f, f, f, f],
 * [t, t, f, t],
 * [f, f, f, f],
 * [f, f, f, f]]
 * and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7,
 * since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
 */
public class Problem_23 {
    public static void main(String[] args) {
        Problem_23 test = new Problem_23();
        boolean[][] grid = new boolean[4][4];
        grid[1][0] = true;
        grid[1][1] = true;
        grid[1][3] = true;
        System.out.println("should be 7 :  " + test.shortestPath(grid, new int[]{3,0}, new int[]{0,0}));

        grid[1][2] = true;
        System.out.println("should be -1 : " + test.shortestPath(grid, new int[]{3,0}, new int[]{0,0}));
    }

    public int shortestPath(boolean[][] grid, int[] start, int[] end){
        int[][] dp = new int[grid.length][grid[0].length];
        //BFS
        int step = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start[0], start[1]));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point point = queue.poll();
                int row = point.row;
                int col = point.col;
                if(row >= 0 && row < dp.length && col >= 0 && col < dp[row].length && !grid[row][col] && dp[row][col] == 0) {
                    dp[row][col] = step;
                    queue.add(new Point(row + 1, col));
                    queue.add(new Point(row, col + 1));
                    queue.add(new Point(row, col - 1));
                    queue.add(new Point(row - 1, col));
                }
            }
            step++;
        }
        //for(int[] row : dp) System.out.println(Arrays.toString(row));
        int shortestPath = dp[end[0]][end[1]];
        return  shortestPath == 0 ? -1 : shortestPath - 1;
    }

    class Point{
        int row;
        int col;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }
}
