package books.design_pattern._01_iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created on 2018-05-15.
 */
public class BookShelf implements Aggregate<Book> {
    private Book[] books;
    private int last;

    public BookShelf(int maxSize){
        this.books = new Book[maxSize];
        this.last = 0;
    }

    public Book getBook(int i){
        return books[i];
    }

    public void appendBook(Book book){
        if(books.length - 1 == last){
            books = Arrays.copyOf(books, (last * 2) + 1);
        }
        books[++last] = book;
    }

    public int getSize(){
        return last;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
