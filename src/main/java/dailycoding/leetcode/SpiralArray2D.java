package dailycoding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralArray2D {
    public static void main(String[] args) {
        SpiralArray2D test = new SpiralArray2D();
        int[][] matrix1 = new int[][]{{1,2,3,},{4,5,6},{7,8,9}};
        System.out.println(test.spiralOrder(matrix1));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0, col = 0;
        char dir = 'R';
        while(result.size() != n*m){
            if(dir == 'R'){
                addResult(result, matrix, row, col);
                if(col + 1 == m || matrix[row][col + 1] == 0){
                    dir = 'D';row++;
                } else {
                    col++;
                }
            } else if(dir == 'D'){
                addResult(result, matrix, row, col);
                if(row + 1 == n || matrix[row + 1][col] == 0){
                    dir = 'L'; col--;
                } else{
                    row++;
                }
            } else if(dir == 'L'){
                addResult(result, matrix, row, col);
                if(col - 1 == -1 || matrix[row][col - 1] == 0){
                    dir = 'U'; row--;
                } else {
                    col--;
                }
            } else if(dir == 'U'){
                addResult(result, matrix, row, col);
                if(row - 1 ==  -1|| matrix[row -1][col] == 0){
                    dir = 'R'; col++;
                } else {
                    row--;
                }
            }
        }
        return result;
    }

    public void addResult(List<Integer> result, int[][] matrix, int row, int col){
        result.add(matrix[row][col]);
        matrix[row][col] = 0;
    }

}
