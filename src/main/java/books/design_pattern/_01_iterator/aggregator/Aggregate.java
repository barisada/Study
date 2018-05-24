package books.design_pattern._01_iterator.aggregator;

import java.util.Iterator;

/**
 * Created on 2018-05-15.
 */
public interface Aggregate<E> {
    Iterator<E> iterator();
}
