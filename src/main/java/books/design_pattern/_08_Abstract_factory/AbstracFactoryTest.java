package books.design_pattern._08_Abstract_factory;


import books.design_pattern._08_Abstract_factory.factory.Factory;
import books.design_pattern._08_Abstract_factory.factory.Link;
import books.design_pattern._08_Abstract_factory.factory.Page;
import books.design_pattern._08_Abstract_factory.factory.Tray;

/**
 * Created on 2018-06-03.
 */
public class AbstracFactoryTest {

    public static void main(String[] args) {
        showHtml(Factory.getFactory("books.design_pattern._08_Abstract_factory.listFactory.ListFactory"));
        System.out.println("*******************************");
        showHtml(Factory.getFactory("books.design_pattern._08_Abstract_factory.tableFactory.TableFactory"));


    }

    private static void showHtml(Factory factory) {
        Link google = factory.createLink("Google US", "https://google.com");
        Link googleKr = factory.createLink("Google KR", "https://google.co.kr");
        Link googleCa = factory.createLink("Google CA", "https://google.ca");
        Link bing = factory.createLink("Bing", "https://www.bing.com/");

        Link github = factory.createLink("Github", "https://github.com/");
        Link sof = factory.createLink("Stackoverflow", "https://stackoverflow.com/");

        Tray googles = factory.createTray("Google");
        googles.add(google);
        googles.add(googleKr);
        googles.add(googleCa);

        Tray search = factory.createTray("Search");
        search.add(googles);
        search.add(bing);

        Tray dev = factory.createTray("Developer");
        dev.add(github);
        dev.add(sof);

        Page page = factory.createPage("Links", "NoAuthor");
        page.add(dev);
        page.add(search);

        System.out.println(page.makeHTML());
    }

    private static void tableFactory() {

    }
}
