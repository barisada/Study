package books.design_pattern._01_iterator;

import java.util.Iterator;

/**
 * Created on 2018-05-15.
 */
public class BookShelfIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return bookShelf.getSize() > index;
    }

    @Override
    public Book next() {
        return bookShelf.getBook(++index);
    }
}
