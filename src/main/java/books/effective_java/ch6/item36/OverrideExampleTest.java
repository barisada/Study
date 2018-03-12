package books.effective_java.ch6.item36;

import java.util.HashSet;
import java.util.Set;

public class OverrideExampleTest {
    public static void main(String[] args) {
        Set<BigramWrongOverrideExample> wrongs = new HashSet<>();
        for(int i = 0; i < 10; i++){
            for(char ch = 'a'; ch<='z'; ch++){
                wrongs.add(new BigramWrongOverrideExample(ch, ch));
            }
        }
        System.out.println("[" + BigramWrongOverrideExample.class.getName() + "] "
                + "expected 26 but actual size is " + wrongs.size());

        Set<BigramRightOverrideExample> rights = new HashSet<>();
        for(int i = 0; i < 10; i++){
            for(char ch = 'a'; ch <= 'z'; ch++){
                rights.add(new BigramRightOverrideExample(ch, ch));
            }
        }
        System.out.println("[" + BigramRightOverrideExample.class.getName() + "] "
                + "expected 26 and actual size is " + rights.size());
    }
}
