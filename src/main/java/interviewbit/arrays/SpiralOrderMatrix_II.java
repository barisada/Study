package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Given n = 3,
 *
 * You should return the following matrix:
 *
 * [
 *   [ 1, 2, 3 ],
 *   [ 8, 9, 4 ],
 *   [ 7, 6, 5 ]
 * ]
 */
public class SpiralOrderMatrix_II {

    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int size = A;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        if(size <= 0) return matrix;
        if(size == 1){
            matrix.add(new ArrayList<Integer>(){{this.add(1);}});
            return matrix;
        }

        for(int i = 0; i < size; i++){
            ArrayList<Integer> col = new ArrayList<>();
            matrix.add(col);
            for(int j = 0; j < size; j++){
                col.add(-1);
            }
        }

        int cur = 1;
        Point p = new Point(0, -1);
        for(int i = 0; i < size; i++){
            cur = goRight(matrix, p, cur);
            cur = goDown(matrix, p, cur);
            cur = goLeft(matrix, p, cur);
            cur = goUp(matrix, p, cur);
            i++;
        }

        return matrix;
    }

    public int goRight(ArrayList<ArrayList<Integer>> matrix, Point p, int cur){
        ArrayList<Integer> row = matrix.get(p.row);
        for(int i = 0; i < row.size(); i++){
            if(row.get(i) == -1) {
                row.set(i, cur++);
                p.col++;
            }

        }
        return cur;
    }

    public int goLeft(ArrayList<ArrayList<Integer>> matrix, Point p, int cur){
        ArrayList<Integer> row = matrix.get(p.row);
        for(int i = row.size() - 1; i >= 0; i--){
            if(row.get(i) == -1) {
                row.set(i, cur++);
                p.col--;
            }
        }
        return cur;
    }

    public int goDown(ArrayList<ArrayList<Integer>> matrix, Point p, int cur){
        for(int i = 0; i < matrix.size(); i++) {
            ArrayList<Integer> row = matrix.get(i);
            if(row.get(p.col) == -1) {
                row.set(p.col, cur++);
                p.row++;
            }
        }
        return cur;
    }

    public int goUp(ArrayList<ArrayList<Integer>> matrix, Point p, int cur){
       for(int i = matrix.size() - 1; i >= 0;i--){
           ArrayList<Integer> row = matrix.get(i);
           if(row.get(p.col) == -1) {
               row.set(p.col, cur++);
               p.row--;
           }

       }
       return cur;
    }

    class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    public static void main(String[] args) {
        SpiralOrderMatrix_II spiralOrderMatrix_ii = new SpiralOrderMatrix_II();
        ArrayList<ArrayList<Integer>> list = spiralOrderMatrix_ii.generateMatrix(5);
        for(ArrayList arr : list){
            System.out.println(arr);
        }
    }

}
