package internet_lecture.alg_pknu_ac_kr.lecture._09_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_02_Basic_Example {
    public static void main(String[] args) {
        int[][] grid = createGrid();
        int[][] memo = new int[grid.length][grid.length];

        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        int min = findMin(grid, memo,grid.length - 1, grid.length - 1);

        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        int min2 = findMinBottomUp(grid, memo,grid.length - 1, grid.length - 1);

        List<Integer> paths = new ArrayList<>();
        findMinPath(grid, memo, paths, 0, 0);

        System.out.println("최소합 탑다운 :  " + min);
        System.out.println("최소합 바텁업 :  " + min2);
        System.out.println("최소 거리 패스 : " + paths);
    }

    private static int findMin(int[][] grid, int[][] memo, int row, int col) {
        if(memo[row][col]  != -1){
            return memo[row][col];
        } else if(row == 0 && col == 0){
            memo[row][col] =  grid[row][col];
        } else if(row == 0){
            memo[row][col] = findMin(grid, memo, row, col - 1) + grid[row][col];
        } else if(col == 0){
            memo[row][col] = findMin(grid, memo, row - 1, col) + grid[row][col];
        } else{
            memo[row][col] = Math.min(findMin(grid, memo, row - 1, col), findMin(grid, memo, row, col - 1)) + grid[row][col];
        }

        return memo[row][col];
    }

    private static int findMinBottomUp(int[][] grid, int[][] memo, int row, int col){
        for(int i = 0; i <= row; i++){
            for(int j = 0; j <= col; j++){
                if(i == 0 && j == 0){
                    memo[i][j] = grid[i][j];
                } else if(i == 0){
                    memo[i][j] = memo[i][j - 1] + grid[i][j];
                } else if(j == 0){
                    memo[i][j] = memo[i - 1][j] + grid[i][j];
                } else {
                    memo[i][j] = Math.min(memo[i - 1][j], memo[i][j - 1]) + grid[i][j];
                }
            }
        }
        return memo[row][col];
    }

    private static void findMinPath(int[][] grid, int[][] memo, List<Integer> paths, int row, int col){
        if(row + 1 >=memo.length && col + 1 >= memo.length) {
            paths.add(grid[row][col]);
            return;
        }
        if(row + 1>= memo.length ){
            paths.add(grid[row][col]);
            findMinPath(grid,memo,paths, row, col + 1);
        } else if(col + 1 >= memo.length) {
            paths.add(grid[row][col]);
            findMinPath(grid,memo,paths, row + 1, col);
        } else if(memo[row + 1][col] > memo[row][col + 1]){
            paths.add(grid[row][col]);
            findMinPath(grid, memo, paths, row, col + 1);
        } else if(memo[row + 1][col] < memo[row][col + 1]){
            paths.add(grid[row][col]);
            findMinPath(grid, memo, paths, row + 1, col);
        }
    }

    private static int[][] createGrid(){
        int[][] grid = new int[4][4];
        int[] row1 = {6,7,12,5};
        int[] row2 = {5,3,11,18};
        int[] row3 = {7,17,3,3};
        int[] row4 = {8, 10, 14, 9};
        grid[0] = row1;
        grid[1] = row2;
        grid[2] = row3;
        grid[3] = row4;
        return grid;
    }
}
