package books.effective_java.ch5.item24;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Objects;

public class MinimalizedSuppressWarningsCoverageExample<E> extends AbstractList<E> {
    private final E[] a;

    MinimalizedSuppressWarningsCoverageExample(E[] array) {
        a = Objects.requireNonNull(array);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(a.length < size()){
            @SuppressWarnings("unchecked")
            T[] result = (T[]) Arrays.copyOf(this.a, size(), a.getClass());
            return result;
        }
        System.arraycopy(this.a, 0, a, 0, size());
        if(a.length > size()){
            a[size()] = null;
        }
        return a;
    }

    @Override
    public int size() {
        return a.length;
    }


    @Override
    public E get(int index) {
        return a[index];
    }
}
