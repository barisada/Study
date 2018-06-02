package books.design_pattern._08_Abstract_factory.factory;

/**
 * Created on 2018-06-03.
 */
public abstract class Link extends Item{
    private String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
