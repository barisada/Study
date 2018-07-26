package books.design_pattern._03_Template_method;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created on 2018-05-24.
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        AbstractDisplay charDisplay = new CharDisplay('H');
        AbstractDisplay stringDisplay = new StringDisplay("Hello, world!");
        AbstractDisplay stringDisplay2 = new StringDisplay(LocalDateTime.now().atZone(ZoneId.systemDefault()).toString());

        charDisplay.display();
        stringDisplay.display();
        stringDisplay2.display();

    }
}
