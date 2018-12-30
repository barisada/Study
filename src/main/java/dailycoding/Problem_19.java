package dailycoding;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * A builder is looking to build a row of N houses that can be of K different colors.
 * He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.
 *
 * Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color,
 * return the minimum cost which achieves this goal.
 */
public class Problem_19 {
    public static void main(String[] args) {
        Problem_19 test = new Problem_19();
        int[][] grid = new int[5][5];
        grid[0] = new int[]{2,3,1,10,9};
        grid[1] = new int[]{10,11,1,20,17};
        grid[2] = new int[]{4,81,9,10,11};
        grid[3] = new int[]{10,2,5,7,4};
        grid[4] = new int[]{70,1,50,120,100};

        System.out.println("should be 12 : " + test.minimumCost(grid));
        System.out.println("should be 12 : " + test.minCostII(grid));

        int[][] grid2 = new int[3][3];
        grid2[0] = new int[]{1, 1, 1};
        grid2[1] = new int[]{2, 2, 2};
        grid2[2] = new int[]{3, 1, 5};
        System.out.println("should be 4 : " + test.minimumCost(grid2));
        System.out.println("should be 4 : " + test.minCostII(grid2));

        int[][] grid3 = new int[9][9];
        StopWatch sw = new StopWatch("test");
        sw.start("dfs");
        System.out.println("should be 0 : " + test.minimumCost(grid3));
        sw.stop();
        sw.start("dp");
        System.out.println("should be 0 : " + test.minCostII(grid3));
        sw.stop();
        System.out.println(sw.prettyPrint());

    }


    public int minimumCost(int[][]grid){
        List<Integer> result = new ArrayList<>();
        dfs(grid, -1, new ArrayList<>(), result);
        return result.stream().min(Integer::compareTo).orElse(0);
    }

    private void dfs(int[][] grid, int level, List<Integer> colIdx, List<Integer> result) {
        if(level >= 1 && colIdx.get(level - 1) == colIdx.get(level)){
            return;
        } else if(level == grid.length - 1){
            int sum = 0;
            for(int row = 0; row < colIdx.size(); row++){
                sum += grid[row][colIdx.get(row)];
            }
            result.add(sum);
        } else {
            for(int col = 0; col < grid[level + 1].length; col++){
                colIdx.add(col);
                dfs(grid, level + 1, colIdx, result);
                colIdx.remove(colIdx.size() - 1);
            }
        }
    }

    public int minCostII(int[][] costs) {
        if (costs != null && costs.length == 0) return 0;

        int preMin = 0, preSecndMin = 0, preColor = -1;

        for (int i = 0; i < costs.length; i++) {
            int curMin = Integer.MAX_VALUE;
            int curSecndMin = Integer.MAX_VALUE;
            int curColor = -1;
            for (int j = 0; j < costs[i].length; j++) {
                costs[i][j] = costs[i][j] + (preColor == j ? preSecndMin : preMin);

                if (costs[i][j] < curMin) {
                    curSecndMin = curMin;
                    curMin = costs[i][j];
                    curColor = j;
                } else if (costs[i][j] < curSecndMin) {
                    curSecndMin = costs[i][j];
                }
            }
            preMin = curMin;
            preSecndMin = curSecndMin;
            preColor = curColor;
           /* for(int[] row : costs){
                System.out.println(Arrays.toString(row));
            }
            System.out.println("================================");*/
        }
        return preMin;
    }

}
