package books.effective_java.ch10.item67;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created on 2018-04-12.
 */
public class FixedObservableSet<E> extends ObservableSet<E>{
    public FixedObservableSet(Set s) {
        super(s);
    }

    @Override
    public void notifyElementAdded(E element) {
        List<SetObserver<E>> snapshot = null;
        synchronized (observers){
            snapshot = new ArrayList<>(observers);
        }
        for(SetObserver<E> observer : snapshot){
            observer.added(this, element);
        }
    }
}
