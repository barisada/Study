package books.design_pattern._08_Abstract_factory.listFactory;


import books.design_pattern._08_Abstract_factory.factory.Factory;
import books.design_pattern._08_Abstract_factory.factory.Link;
import books.design_pattern._08_Abstract_factory.factory.Page;
import books.design_pattern._08_Abstract_factory.factory.Tray;

/**
 * Created on 2018-06-03.
 */
public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
