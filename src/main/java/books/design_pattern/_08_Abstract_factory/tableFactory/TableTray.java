package books.design_pattern._08_Abstract_factory.tableFactory;

import books.design_pattern._08_Abstract_factory.factory.Item;
import books.design_pattern._08_Abstract_factory.factory.Tray;

/**
 * Created on 2018-06-03.
 */
public class TableTray extends Tray {
    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<td>");
        sb.append("<table width=\"100%\" border=1><tr>");
        sb.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\""
                + getItems().size() + "\"><b>" + getCaption() + "</b></td>");
        sb.append("</tr>" + System.lineSeparator());
        sb.append("<tr>" + System.lineSeparator());

        for(Item item : getItems()){
            sb.append(item.makeHTML());
        }

        sb.append("</tr></table>");
        sb.append("</td>");

        return sb.toString();
    }
}
