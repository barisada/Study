package groupstudy.ㅋ사.test.answers;

import java.util.Scanner;

/**
 * Created by jw on 2017-07-02.
 */
public class FirstProblem {

    public static void main(String...args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String andrea[] = new String[a];
        insertArray(sc, a, andrea);

        int m = sc.nextInt();
        String maria[] = new String[m];
        insertArray(sc, m, maria);
        sc.close();

        int min = minimumMove(andrea, maria);
        System.out.println(min);
    }

    private static int minimumMove(String[] andrea, String[] maria) {
        int size = andrea.length;
        int diff = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < andrea[i].length(); j++){
                diff += Math.abs((int) andrea[i].charAt(j) - (int) maria[i].charAt(j));
            }
        }
        return diff;
    }

    private static void insertArray(Scanner sc, int a, String[] andrea) {
        for(int i = 0; i < a; i++){
            andrea[i] = sc.next();
        }
    }
}
