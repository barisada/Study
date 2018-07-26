package books.ctci.graph;

import java.util.*;

public class FindMinimumDistance {
    boolean[][] visit;
    int[][] dist;
    void findMininumDistance(int rows, int cols, List<List<Integer>> grid){
        visit= new boolean[rows][cols];
        dist = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;
        Point dPoint = null;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid.get(i).get(j) == 9){
                    dPoint = new Point(i, j, 0);
                    break;
                }

                /**
                 * 현재 노드와 연결되어있는 노드의 거리를 갱신한다.
                 * 미니멈이니까 기존 거리와 현재 추가하는 거리중 작은걸로 갱신한다.
                 */
                if(grid.get(i).get(j) == 1){
                    visit[i][j] = true;
                    if(i - 1 >= 0 && !visit[i - 1][j] && grid.get(i - 1).get(j) != 0)
                        dist[i - 1][j] = Math.min(dist[i - 1][j], dist[i][j] + 1);
                    if(i + 1 < rows && !visit[i + 1][j] && grid.get(i + 1).get(j) != 0)
                        dist[i + 1][j] = Math.min(dist[i + 1][j], dist[i][j] + 1);
                    if(j - 1 >= 0 && !visit[i][j - 1] && grid.get(i).get(j - 1) != 0)
                        dist[i][j - 1] = Math.min(dist[i][j - 1], dist[i][j] + 1);
                    if(j + 1 < cols && !visit[i][j + 1] && grid.get(i).get(j + 1) != 0)
                        dist[i][j + 1] = Math.min(dist[i][j + 1], dist[i][j] + 1);
                }

            }
        }

        for(int[] arr : dist){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(dist[dPoint.row][dPoint.col]);
    }


    public static void main(String[] args) {
        List<Integer> row1 = Arrays.asList(1,1,1,0);
        List<Integer> row2 = Arrays.asList(0,0,1,0);
        List<Integer> row3 = Arrays.asList(1,0,1,9);
        List<Integer> row4 = Arrays.asList(0,0,1,1);
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(row1);
        grid.add(row2);
        grid.add(row3);
        grid.add(row4);

        FindMinimumDistance min = new FindMinimumDistance();
        min.findMininumDistance(grid.size(), row1.size(), grid);

    }

    private class Point {
        int row;
        int col;
        int val;

        public Point(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row &&
                    col == point.col;
        }

        @Override
        public int hashCode() {

            return Objects.hash(row, col);
        }
    }
}
