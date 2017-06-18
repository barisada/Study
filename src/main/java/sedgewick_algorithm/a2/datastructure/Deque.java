package sedgewick_algorithm.a2.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by jw on 2017-05-31.
 */
public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    // construct an empty deque
    public Deque(){
    }

    // is the deque empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst(Item item){
        validation(item);
        Node<Item> oldFirst = this.first;
        Node<Item> node = new Node<>(null, item, first);
        if(isEmpty()) {
            this.first = node;
            this.last = node;
        } else{
            this.first = node;
            oldFirst.prev = node;
        }
        size++;
    }

    // add the item to the end
    public void addLast(Item item){
        validation(item);
        if(isEmpty()) {
            this.addFirst(item);
        } else {
            Node<Item> oldLast = this.last;
            Node<Item> node = new Node<>(last, item, null);
            this.last = node;
            oldLast.next = node;
            size++;
        }

    }

    // remove and return the item from the front
    public Item removeFirst(){
        if(!isEmpty()){
            Node<Item> next = this.first.next;
            Item item = this.first.item;
            this.first.item = null;
            this.first.next = null;
            this.first = null;

            this.first = next;
            size--;
            return item;
        } else{
            throw new NoSuchElementException();
        }
    }

    // remove and return the item from the end
    public Item removeLast(){
        if(!isEmpty()){
            Node<Item> oldLast = this.last;
            if(size == 1) {
                this.removeFirst();
            } else {
                this.last = this.last.prev;
                this.last.next = null;
                size--;
            }
            oldLast.next = null;
            oldLast.prev = null;

            return oldLast.item;
        } else{
            throw new NoSuchElementException();
        }
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator(){
       return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{
        Node<Item> node = first;

        @Override
        public boolean hasNext() {
           return node != null;
        }

        @Override
        public Item next() {
            Node<Item> oldNode = node;
            node = node.next;
            return oldNode.item;
        }
    }

    private void validation(Item item) {
        if(item == null) throw new NullPointerException();
    }

    // unit testing (optional)
    public static void main(String[] args){
        Deque<Object> deque = new Deque<>();
        deque.addLast(0);
        deque.addFirst(1);
        deque.removeLast();
        deque.removeLast();
        printDeque(deque);
        System.out.println("size : " + deque.size());


    }

    private static void printDeque(Deque<? extends Object> deque) {
        List<Object> list = new ArrayList<>();
        for(Object s : deque){
            list.add(s);
        }
        System.out.println(list);
    }

    private class Node<Item>{
        public Item item;
        public Node<Item> prev;
        public Node<Item> next;
        public Node(Node<Item> prev, Item item, Node<Item> next){
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
