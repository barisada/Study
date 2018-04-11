package books.effective_java.ch10.item67;

import books.effective_java.ch10.item67.ObservableSet;

/**
 * Created on 2018-04-12.
 */
public interface SetObserver<E> {
    void added(ObservableSet<E> set, E element);
}
