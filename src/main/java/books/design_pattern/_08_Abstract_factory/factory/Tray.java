package books.design_pattern._08_Abstract_factory.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018-06-03.
 */
public abstract class Tray extends Item{
    private List<Item> items;

    public Tray(String caption) {
        super(caption);
        items = new ArrayList<>();
    }

    public void add(Item item){
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
