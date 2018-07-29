package internet_lecture.alg_pknu_ac_kr.lecture._01_recursion;

import java.util.Arrays;

/**
 * n x n grid 에서
 * 퀸을 다 놓을수 있는지 찾는문제.
 * 퀸과 같은 행, 열, 대각선에는 다른 퀸을 놓을 수 없다.
 * 모든 row 마다 둘 수 있는 퀸의 위치를 찾아보아라!
 * 찾으면 true, 못찾으면 false...
 */
public class Recursion_06_n_queens_problem {
    static int[] cols;

    public static void main(String[] args) {
        int n = 8;
        int[][] grid = createGrid(n);
        cols = new int[n];

        boolean found = queens(grid, -1);
        System.out.println("모든 퀸을 다 둘 수 있다 : " + found);
        System.out.println("cols " + Arrays.toString(cols));

        for(int i = 0; i < cols.length; i++){
            grid[i][cols[i]] = 9;
        }
        for(int[] row : grid){
            System.out.println(Arrays.toString(row));
        }

    }

    private static boolean queens(int[][] grid, int level) {
        if(!promising(level)){
            return false;
        } else if (level == grid.length - 1){
            return true;
        } else {
            //현재노드의 모든 하위노드를 순회함
            for(int i = 0; i < grid.length; i++){
                cols[level + 1] = i;
                if(queens(grid, level + 1))     //하위노드중 순회중 정답이 나왔으면 리턴
                    return true;
            }
            return false;
        }
    }

    private static boolean promising(int level) {
        for(int i = 0; i < level; i++){
            if(cols[i] == cols[level]){     //같은 열에 있는지 검사
                return false;
            } else if(level - i == Math.abs(cols[level] - cols[i])){             //대각선에 있는지 검사
                return false;
            }
        }
        return true;
    }


    private static int[][] createGrid(int n) {
        return new int[n][n];
    }
}
