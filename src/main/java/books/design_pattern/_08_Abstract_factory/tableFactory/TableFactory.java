package books.design_pattern._08_Abstract_factory.tableFactory;

import books.design_pattern._08_Abstract_factory.factory.Factory;
import books.design_pattern._08_Abstract_factory.factory.Link;
import books.design_pattern._08_Abstract_factory.factory.Page;
import books.design_pattern._08_Abstract_factory.factory.Tray;

/**
 * Created on 2018-06-03.
 */
public class TableFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
