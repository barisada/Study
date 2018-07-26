package books.design_pattern._08_Abstract_factory.factory;

/**
 * Created on 2018-06-03.
 */
public abstract class Factory {

    public static Factory getFactory(String className){
        Factory factory = null;

        try {
            factory = (Factory) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return factory;
    }

    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);
}
