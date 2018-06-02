package books.design_pattern._08_Abstract_factory.listFactory;

import books.design_pattern._08_Abstract_factory.factory.Link;

/**
 * Created on 2018-06-03.
 */
public class ListLink extends Link {

    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "<li>"
                + "<a href=\"" + getUrl() + "\">" + getCaption() + "</a>"
                + "</li>"
                + System.lineSeparator();
    }
}
