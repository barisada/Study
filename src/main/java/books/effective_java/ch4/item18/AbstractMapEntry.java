package books.effective_java.ch4.item18;

import java.util.Map;

public abstract class AbstractMapEntry<K,V> implements Map.Entry<K,V>{

    @Override
    public abstract K getKey();

    @Override
    public abstract V getValue();

    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Map.Entry)) return false;

        Map.Entry<?,?> arg = (Map.Entry) o;
        return equals(getKey(), arg.getKey()) && equals(getValue(), arg.getValue());
    }

    private static boolean equals(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }

    @Override
    public int hashCode() {
        return hashCode(getKey())^hashCode(getValue());
    }

    private int hashCode(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }
}
