package books.effective_java.ch6.item32;

import java.util.EnumSet;

public class EnumSetTest {

    public static void main(String[] args) {
        EnumSetExample ex = new EnumSetExample();

        ex.applyStyles(EnumSet.of(EnumSetExample.TextStyle.BOLD, EnumSetExample.TextStyle.ITALIC));
    }
}
