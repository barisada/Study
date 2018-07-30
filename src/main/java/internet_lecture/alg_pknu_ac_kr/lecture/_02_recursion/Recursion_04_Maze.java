package internet_lecture.alg_pknu_ac_kr.lecture._02_recursion;

import java.util.Arrays;

/**
 * MAZE
 * 현재 위치에서 출구까지 있는 경로가 있으려면,
 *  1. 현재 위치가 출구
 *  2. 이웃한 셀(왼쪽, 오른쪽, 위, 아래)들중 하나에서
 *  현재 위치를 지나치지 않고 출구까지 가는 경우
 */
public class Recursion_04_Maze {
    private static int EXIT = 9;
    private static int WALL = 0;
    private static int PATH_WAY = 1;
    private static int PATH_TO_DEAD_END = 4;
    private static int PATH_TO_EXIT = 7;

    public static void main(String[] args) {
        int n = 8;
        int[][] grid = createGrid(n);
        boolean hasFound = findPathDecision(grid, 0, 0);

        System.out.println("미로에서 나가는 출구가 있나? : " + hasFound);
        for(int[] row : grid){
            System.out.println(Arrays.toString(row));
        }
    }


    private static boolean findPathDecision(int[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid.length   //좌표가 범위안에 있는지 확인
                || (grid[row][col] !=PATH_WAY && grid[row][col] != EXIT)
                ){
            return false;
        } else if(grid[row][col] == EXIT){
            grid[row][col] = PATH_TO_EXIT;
            return true;
        } else {
            grid[row][col] = PATH_TO_EXIT;

            //북-동-남-서 순으로 체크.
            boolean result = findPathDecision(grid,row - 1, col)
                    || findPathDecision(grid, row, col + 1)
                    ||findPathDecision(grid, row +1, col)
                    || findPathDecision(grid, row, col - 1)
                    ;

            if(result) {
                return result;
            }
            else {
                grid[row][col] = PATH_TO_DEAD_END;
                return false;
            }
        }
    }


    private static int[][] createGrid(int n) {
        int[] row0 = {1,1,1,1,1,1,1,0};
        int[] row1 = {1,0,0,1,0,0,1,0};
        int[] row2 = {1,1,1,0,1,1,1,0};
        int[] row3 = {1,0,1,1,0,0,1,1};
        int[] row4 = {1,0,0,0,1,1,0,0};
        int[] row5 = {1,0,1,1,1,0,1,0};
        int[] row6 = {1,1,1,0,1,1,1,0};
        int[] row7 = {1,0,0,0,1,0,1,9};

        int[][] grid = new int[n][n];
        grid[0] = row0;
        grid[1] = row1;
        grid[2] = row2;
        grid[3] = row3;
        grid[4] = row4;
        grid[5] = row5;
        grid[6] = row6;
        grid[7] = row7;

        return grid;
    }
}
