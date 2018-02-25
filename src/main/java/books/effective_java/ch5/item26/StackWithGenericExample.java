package books.effective_java.ch5.item26;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackWithGenericExample<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INIT_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public StackWithGenericExample(){
        elements = (E[]) new Object[DEFAULT_INIT_CAPACITY];
    }

    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop(){
        if(size == 0) throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null;      //eliminate obsolete reference
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void ensureCapacity(){
        if(size == elements.length){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

}
