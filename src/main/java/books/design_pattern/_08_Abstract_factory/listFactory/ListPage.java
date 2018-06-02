package books.design_pattern._08_Abstract_factory.listFactory;

import books.design_pattern._08_Abstract_factory.factory.Item;
import books.design_pattern._08_Abstract_factory.factory.Page;

/**
 * Created on 2018-06-03.
 */
public class ListPage extends Page {

    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>" + getTitle() + "</title></head>" + System.lineSeparator());
        sb.append("<body>" + System.lineSeparator());
        sb.append("<h1>" + getTitle() + "</h1>" + System.lineSeparator());
        sb.append("<ul>" + System.lineSeparator());

        for(Item item : getContents()){
            sb.append(item.makeHTML());
        }

        sb.append("</ul>" + System.lineSeparator());
        sb.append("<hr><address>" + getAuthor() + "</address>" + System.lineSeparator());
        sb.append("</body></html>" + System.lineSeparator());

        return sb.toString();
    }
}
