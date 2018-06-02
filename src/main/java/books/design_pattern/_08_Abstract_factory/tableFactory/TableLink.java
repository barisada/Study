package books.design_pattern._08_Abstract_factory.tableFactory;

import books.design_pattern._08_Abstract_factory.factory.Link;

/**
 * Created on 2018-06-03.
 */
public class TableLink extends Link {
    public TableLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "<td><a href=\"" + getUrl() + "\">" + getCaption() + "</a></td>" + System.lineSeparator();
    }
}
