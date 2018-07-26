package books.design_pattern._08_Abstract_factory.listFactory;

import books.design_pattern._08_Abstract_factory.factory.Item;
import books.design_pattern._08_Abstract_factory.factory.Tray;

/**
 * Created on 2018-06-03.
 */
public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<li>" + System.lineSeparator());
        sb.append(getCaption() + System.lineSeparator());
        sb.append("<ul>" + System.lineSeparator());

        for(Item item : getItems()){
            sb.append(item.makeHTML());
        }

        sb.append("</ul>" + System.lineSeparator());
        sb.append("</li>" + System.lineSeparator());

        return sb.toString();
    }
}
