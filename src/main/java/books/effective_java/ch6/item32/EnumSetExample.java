package books.effective_java.ch6.item32;

import java.util.Set;

public class EnumSetExample {
    public enum TextStyle {
        BOLD, ITALIC, UNDERLINE, STRIKETHOUGH
    }

    public void applyStyles(Set<TextStyle> styles){
        for(TextStyle st : styles){
            System.out.println(st + " applied");
        }
    }

}
