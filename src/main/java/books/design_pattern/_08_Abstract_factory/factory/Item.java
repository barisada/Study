package books.design_pattern._08_Abstract_factory.factory;

/**
 * Created on 2018-06-03.
 */
public abstract class Item implements HTMLMaker{
    private String caption;

    public Item(String caption) {
        this.caption = caption;
    }

    @Override
    public abstract String makeHTML();

    public String getCaption() {
        return caption;
    }
}
