package books.effective_java.ch5.item28;

import books.effective_java.ch5.item26.StackWithGenericExample;

import java.util.*;

public class UseBoundWildCardStackExample<E> extends StackWithGenericExample<E> {

    public void pushAll(Iterable<? extends E> src){
        for(E e : src) push(e);
    }

    public Collection<? super E> popAll(Collection<? super E> dst){
        while(!isEmpty()){
            dst.add(pop());
        }
        return dst;
    }



    public static void main(String[] args) {
        UseBoundWildCardStackExample<Number> numStack = new UseBoundWildCardStackExample<>();
        Iterable<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        numStack.pushAll(integers);
        System.out.println(numStack);

        Collection<Object> objects = new LinkedList<>();
        System.out.println(numStack.popAll(objects));
    }
}
