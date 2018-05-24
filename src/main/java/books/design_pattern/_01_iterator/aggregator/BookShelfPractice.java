package books.design_pattern._01_iterator.aggregator;

import books.design_pattern._01_iterator.iterator.BookShelfPracticeIterator;
import books.design_pattern._01_iterator.model.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 2018-05-16.
 */
public class BookShelfPractice implements Aggregate<Book> {
    private List<Book> books;

    public BookShelfPractice(int capacity){
        books = new ArrayList<>(capacity);
    }

    public Book getBook(int i){
        return books.get(i);
    }

    public void appendBook(Book book){
        books.add(book);
    }

    public int getSize(){
        return books.size();
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfPracticeIterator(this);
    }
}
