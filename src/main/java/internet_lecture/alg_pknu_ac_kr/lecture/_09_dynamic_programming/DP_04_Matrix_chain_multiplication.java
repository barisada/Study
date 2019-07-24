package internet_lecture.alg_pknu_ac_kr.lecture._09_dynamic_programming;

import java.util.Arrays;
import java.util.Random;

public class DP_04_Matrix_chain_multiplication {
    public static void main(String[] args) {
        int[][] m1 = createMatrix(3,4);
        int[][] m2 = createMatrix(4,5);
        for(int[] row : m1){
            System.out.println(Arrays.toString(row));
        }
        for(int[] row : m2){
            System.out.println(Arrays.toString(row));
        }

        matrixChainMultiplication(m1, m2);
    }

    private static void matrixChainMultiplication(int[][] m1, int[][] m2) {
        int[][] multiplied = new int[m1.length][m2[0].length];
        for(int i = 0; i < m1.length; i++){
            for(int j = 0; j < m2[0].length; j++){
                multiplied[i][j] = 0;
                for(int k = 0; k < m2.length; k++){
                    multiplied[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        for(int[] row : multiplied){
            System.out.println(Arrays.toString(row));
        }
    }

    private static int[][] createMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        Random random = new Random(1);
        for(int i = 0; i < m; i++){
            for(int  j = 0; j < n; j++){
                matrix[i][j] = random.nextInt(5);
            }
        }
        return matrix;
    }
}
