package hackerrank.algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by jw on 2017-09-18.
 */
public class GridChallenge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0; i < cases; i++){
            int n = sc.nextInt();
            sc.nextLine();
            int[][] grid = new int[n][n];
            for(int j = 0; j < n; j++){
                grid[j] = sc.nextLine().chars().toArray();
            }
            boolean answer = isRearrangable(grid);
            System.out.println(answer ? "YES" : "NO");
        }
    }

    private static boolean isRearrangable(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            grid[i] = Arrays.stream(grid[i]).sorted().toArray();
        }

        for(int i = 0; i < grid.length - 1; i++){
            for(int j = 0; j <grid.length; j++){
                if(grid[i][j] >  grid[i + 1][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
