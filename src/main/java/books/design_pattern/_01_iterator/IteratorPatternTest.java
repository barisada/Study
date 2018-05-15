package books.design_pattern._01_iterator;

import java.util.Iterator;

/**
 * Created on 2018-05-15.
 */
public class IteratorPatternTest {
    public static BookShelf init(int initial) {
        BookShelf bookShelf = new BookShelf(initial / 2 + 1);
        for(int i = 0; i < initial; i++){
            bookShelf.appendBook(new Book("book-" + i));
        }
        return bookShelf;
    }

    public static void main(String[] args) {
        BookShelf bookShelf = init(10);
        Iterator<Book> bookIterator = bookShelf.iterator();
        bookIterator.forEachRemaining(System.out::println);

    }
}
