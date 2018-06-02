package books.design_pattern._08_Abstract_factory.tableFactory;

import books.design_pattern._08_Abstract_factory.factory.Item;
import books.design_pattern._08_Abstract_factory.factory.Page;

/**
 * Created on 2018-06-03.
 */
public class TablePage extends Page {
    public TablePage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>" + getTitle() + "</title></head>" + System.lineSeparator());
        sb.append("<body>" + System.lineSeparator());
        sb.append("<h1>" + getTitle() + "</h1>" + System.lineSeparator());
        sb.append("<table width=\"80%\" border=\"3\">" + System.lineSeparator());

        for(Item item : getContents()){
            sb.append("<tr>" + item.makeHTML() + "</tr>");
        }

        sb.append("</table>" + System.lineSeparator());
        sb.append("<hr><address>" + getAuthor() + "</address>" + System.lineSeparator());
        sb.append("</body></html>" + System.lineSeparator());

        return sb.toString();
    }
}
