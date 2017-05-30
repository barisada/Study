package sedgewick_algorithm.datastructure;

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
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if(!isEmpty()){
            Node<Item> oldFirst = this.first;
            this.first = this.first.next;
            size--;
            return oldFirst.item;
        } else{
            throw new NoSuchElementException();
        }
    }

    // remove and return the item from the end
    public Item removeLast(){
        if(!isEmpty()){
            Node<Item> oldLast = this.last;
            this.last = this.last.prev;
            this.last.next = null;
            size--;
            return oldLast.item;
        } else{
            throw new NoSuchElementException();
        }
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator(){
        Node<Item> temp = first;
        final Node[] nodeArr = {temp};
        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return nodeArr[0] != null;
            }

            @Override
            public Item next() {
                if(nodeArr[0] != null) {
                    Item item = (Item) nodeArr[0].item;
                    nodeArr[0] = nodeArr[0].next;
                    return item;
                } else{
                    throw new NoSuchElementException();
                }
            }
        };
    }

    private void validation(Item item) {
        if(item == null) throw new NullPointerException();
    }

    // unit testing (optional)
    public static void main(String[] args){
        Deque<String> deque = new Deque<>();
        System.out.println(deque.isEmpty());
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        deque.addFirst("d");
        printDeque(deque);
        System.out.println(deque.removeFirst());
        printDeque(deque);
        System.out.println(deque.removeLast());
        printDeque(deque);

        deque.addLast("1");
        deque.addLast("2");
        deque.addLast("3");
        deque.addLast("4");
        printDeque(deque);
        deque.removeFirst();
        deque.removeLast();
        printDeque(deque);

        System.out.println("size : " + deque.size());


    }

    private static void printDeque(Deque<String> deque) {
        Iterator<String> it = deque.iterator();
        List<String> list = new ArrayList<>();
        while(it.hasNext()){
            list.add(it.next());
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
