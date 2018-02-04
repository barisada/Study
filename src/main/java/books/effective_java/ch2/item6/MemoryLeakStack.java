package books.effective_java.ch2.item6;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MemoryLeakStack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public MemoryLeakStack(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if(size == 0) throw new EmptyStackException();
        return elements[--size];
    }

    public Object preventMemoryLeakPop(){
        if(size == 0) throw new EmptyStackException();
        Object temp = elements[--size];
        elements[size] = null;
        return temp;
    }

    private void ensureCapacity() {
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

}
