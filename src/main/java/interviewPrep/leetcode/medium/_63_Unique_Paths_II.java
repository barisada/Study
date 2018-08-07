package interviewPrep.leetcode.medium;

public class _63_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] up = new int[row][col];

        up[0][0] = 1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(obstacleGrid[i][j] != 1){
                    if(i - 1 >=0){
                        up[i][j] += up[i - 1][j];
                    }
                    if(j - 1 >= 0){
                        up[i][j] += up[i][j -1];
                    }
                }
            }
        }

        return up[row - 1][col -1];

    }

    public static void main(String[] args) {
        _63_Unique_Paths_II up2 = new _63_Unique_Paths_II();
        int[][] grid = new int[4][5];
        int[] row1 = {0,0,0, 0,0};
        int[] row2 = {0,0,0,0,1};
        int[] row3 = {0,0,0,1,0};
        int[] row4= {0,0,0,0,0};
        grid[0] = row1;
        grid[1] = row2;
        grid[2] = row3;
        grid[3] = row4;
        System.out.println(up2.uniquePathsWithObstacles(grid));
    }
}
