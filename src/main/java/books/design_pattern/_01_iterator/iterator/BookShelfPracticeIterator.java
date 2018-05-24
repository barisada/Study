package books.design_pattern._01_iterator.iterator;

import books.design_pattern._01_iterator.aggregator.BookShelfPractice;
import books.design_pattern._01_iterator.model.Book;

import java.util.Iterator;

/**
 * Created on 2018-05-16.
 */
public class BookShelfPracticeIterator implements Iterator<Book> {
    private BookShelfPractice bookShelf;
    private int index;

    public BookShelfPracticeIterator(BookShelfPractice bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return bookShelf.getSize() > index;
    }

    @Override
    public Book next() {
        return bookShelf.getBook(index++);
    }
}
