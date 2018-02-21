package books.effective_java.ch4.item21_22;

import java.io.Serializable;
import java.util.Comparator;

public class ComparatorHostExmaple {

    private static class StringComparatorExample implements Comparator<String>, Serializable {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    public static final Comparator<String> STR_LENGTH_COMPARATOR = new StringComparatorExample();
}
