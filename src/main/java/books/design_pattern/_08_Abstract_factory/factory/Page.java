package books.design_pattern._08_Abstract_factory.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018-06-03.
 */
public abstract class Page implements HTMLMaker{
    private String title;
    private String author;
    private List<Item> contents;

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
        this.contents = new ArrayList<>();
    }

    public void add(Item item){
        contents.add(item);
    }

    public void output(){
        System.out.println(this.makeHTML());
    }

    @Override
    public abstract String makeHTML();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<Item> getContents() {
        return contents;
    }
}
