package books.design_pattern._01_iterator;

import books.design_pattern._01_iterator.aggregator.BookShelf;
import books.design_pattern._01_iterator.aggregator.BookShelfPractice;
import books.design_pattern._01_iterator.model.Book;

import java.util.Iterator;

/**
 * Created on 2018-05-15.
 */
public class IteratorPatternTest {
    public static void main(String[] args) {
        BookShelf bookShelf = createBookShelf(10);
        Iterator<Book> bookIterator = bookShelf.iterator();
        bookIterator.forEachRemaining(System.out::println);

        BookShelfPractice bookShelfPractice = createBookShelfPractice(10);
        Iterator<Book> practiceIterator = bookShelfPractice.iterator();
        practiceIterator.forEachRemaining(System.out::println);
    }

    public static BookShelf createBookShelf(int initial) {
        BookShelf bookShelf = new BookShelf(initial / 2 + 1);
        for(int i = 0; i < initial; i++){
            bookShelf.appendBook(new Book("book-" + i));
        }
        return bookShelf;
    }
    public static BookShelfPractice createBookShelfPractice(int initial) {
        BookShelfPractice bookShelf = new BookShelfPractice(initial);
        for(int i = 0; i < initial; i++){
            bookShelf.appendBook(new Book("practice book-" + i));
        }
        return bookShelf;
    }
}
