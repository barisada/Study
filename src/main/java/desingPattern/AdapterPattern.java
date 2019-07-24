package desingPattern;


import java.util.Deque;
import java.util.LinkedList;

public class AdapterPattern {
    public static void main(String[] args) {
        MyStackAdapter<Integer> stack = new MyStackAdapter<>(new LinkedList<>());
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


    //타겟
    interface MyStack<T>{
        public void push(T t);
        public T pop();
    }

    //아답터를 사용해서 마이스택 사용
    static class MyStackAdapter<T> implements MyStack<T> {
        Deque<T> deque;
        public MyStackAdapter(Deque<T> deque){
            this.deque = deque;
        }

        @Override
        public void push(T t) {
            deque.push(t);
        }

        @Override
        public T pop() {
            return deque.pop();
        }
    }

}
