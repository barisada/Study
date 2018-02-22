package books.effective_java.ch5.item24;

import java.util.Arrays;

public class SuppressWarningTest {
    public static void main(String[] args) {
        Integer[] ar = {1, 2, 3, 4, 5};
        MinimalizedSuppressWarningsCoverageExample<Integer> ex =
                new MinimalizedSuppressWarningsCoverageExample<>(ar);
        Integer[] ar2 = ex.toArray(ar);
        System.out.println(Arrays.toString(ar2));
    }
}
