package internet_lecture.alg_pknu_ac_kr.lecture._01_recursion;

import java.util.Arrays;
import java.util.Random;

/**
 * Binary Image 에서
 * 각 픽셀은 background pixel or imange pixcel.
 * Connected image cell = Blob.
 *
 * Connected image cell is, if
 *  1. 상하좌우 및 대각선으로 연결되있으면 connected cell.
 */
public class Recursion_05_Counting_cells_in_a_Blob {
    private static final int BACKGROUND_CELL = 0;
    private static final int IMAGE_CELL= 1;
    private static final int MARKED_IMAGE_CELL = 2;

    public static void main(String[] args) {
        int n = 8;
        int[][] grid = createGrid(n);

        int colNum = new Random().nextInt(n);
        int rowNum = new Random().nextInt(n);

        int blobSize = countBlobSize(grid, rowNum, colNum);
        System.out.println("(" + colNum + ", " + rowNum + ")" + "의 Blob 사이즈는 " + blobSize + " 입니다.");
        for(int[] row : grid){
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * 입력 : grid 와 좌표 (col, row)
     *
     * 리턴 : 픽셀(col, row) 가 포함된 blob의 크기.
     * (col, row)가 어떤  blob에도 속하지 않은 경우에 0.
     * @param grid
     * @param row
     * @param col
     * @return
     */
    private static int countBlobSize(int[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid.length){
            return 0;
        } else if(grid[row][col] != IMAGE_CELL){
            return 0;
        } else {
            grid[row][col] = MARKED_IMAGE_CELL;
            //북-북동-동-동남-남-남서-서-북서 순으로 확인한다.
            return 1 + countBlobSize(grid, row -1, col)
                    + countBlobSize(grid, row -1 , col + 1)
                    + countBlobSize(grid, row, col + 1)
                    + countBlobSize(grid, row + 1, col + 1)
                    + countBlobSize(grid, row + 1, col)
                    + countBlobSize(grid, row + 1, col - 1)
                    + countBlobSize(grid, row, col - 1)
                    + countBlobSize(grid, row - 1, col -1);
        }
    }

    private static int[][] createGrid(int n) {
        int[] row0 = {1,0,0,0,0,0,0,1};
        int[] row1 = {0,1,1,0,0,1,0,0};
        int[] row2 = {1,1,0,0,1,0,1,0};
        int[] row3 = {0,0,0,0,0,1,0,0};
        int[] row4 = {0,1,0,1,0,1,0,0};
        int[] row5 = {0,1,0,1,0,1,0,0};
        int[] row6 = {1,0,0,0,1,0,0,1};
        int[] row7 = {0,1,1,0,0,1,1,1};

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
