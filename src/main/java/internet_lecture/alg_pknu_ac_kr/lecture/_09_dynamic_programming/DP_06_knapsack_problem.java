package internet_lecture.alg_pknu_ac_kr.lecture._09_dynamic_programming;

import java.util.Arrays;

public class DP_06_knapsack_problem {
    public static void main(String[] args) {
        int[] v = {1,6,18,22,28};
        int[] w = {1,2,5,6,7};
        int limit = 11;

        int[][] memo = new int[v.length][limit];
        int max = findMax(v, w, memo);
        System.out.println(max);
        for(int[] row : memo){
            System.out.println(Arrays.toString(row));
        }
    }

    private static int findMax(int[] v, int[] w, int[][] memo) {
        for(int i = 0; i < v.length; i++){
            for(int j = 0; j < memo[0].length; j++){
                if( (j + 1) >= w[i]){
                    if(i == 0){
                        memo[i][j] = v[i];
                    } else {
                        if(j >= w[i]){
                            memo[i][j] = Math.max(memo[i - 1][j], memo[i - 1][j - w[i]] + v[i]);
                        } else {
                            memo[i][j] = Math.max(memo[i - 1][j], v[i]);
                        }
                    }
                } else {
                    if(i == 0){
                        memo[i][j] = 0;
                    } else {
                        memo[i][j] = memo[i - 1][j];
                    }
                }
            }
        }

        return memo[v.length - 1][memo[0].length - 1];
    }
}
