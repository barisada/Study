package books.design_pattern._05_Singleton.practice;

/**
 * Created on 2018-05-28.
 */
public class TripleTest {
    public static void main(String[] args) {
        for(int i = 0; i < 9; i++){
            Triple triple = Triple.getInstance(i % 3);
            System.out.println("[" + i + "] " + triple.toString() + "(" + triple.hashCode() + ")");
        }
    }
}
