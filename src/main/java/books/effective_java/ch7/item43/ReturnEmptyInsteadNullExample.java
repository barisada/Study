package books.effective_java.ch7.item43;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReturnEmptyInsteadNullExample {

    private final List<Cheese> cheesesInStock = new ArrayList<>();
    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

    public Cheese[] getChesses(){
        return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
    }

    public List<Cheese> getCheeseList(){
        if(cheesesInStock.isEmpty()) return Collections.emptyList();
        else return new ArrayList<>(cheesesInStock);
    }

    public void addCheese(){
        cheesesInStock.add(Cheese.STILTON);
    }

    public enum Cheese{
        STILTON
    }
}
