package books.effective_java.ch10.item67;

import books.effective_java.ch4.item16.ForwardingSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created on 2018-04-11.
 */
public class ObservableSet<E> extends ForwardingSet<E> {
    protected final List<SetObserver<E>> observers = new ArrayList<>();


    public ObservableSet(Set s) {
        super(s);
    }

    public void addObserver(SetObserver<E> observer){
        synchronized (observers){
            observers.add(observer);
        }
    }

    public void removeObserver(SetObserver<E> observer){
        synchronized (observers){
            observers.remove(observer);
        }
    }

    public void notifyElementAdded(E element){
        synchronized (observers){
            for(SetObserver<E> observer : observers){
                observer.added(this, element);
            }
        }
    }

    @Override
    public boolean add(E e) {
        boolean added = super.add(e);
        if(added){
            notifyElementAdded(e);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for(E e : c){
            result |= add(e);
        }
        return result;
    }
}
