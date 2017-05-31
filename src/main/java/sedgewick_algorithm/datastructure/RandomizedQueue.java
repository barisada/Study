package sedgewick_algorithm.datastructure;

import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by jw on 2017-06-01.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<Item>{
        Item item;
        Node<Item> next;
        Node<Item> prev;
        Node(Node prev, Item item, Node next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    // construct an empty randomized queue
    public RandomizedQueue(){
    }

    // is the queue empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        this.validation(item);
        if(isEmpty()){
            Node<Item> temp = new Node(null, item, null);
            this.first = temp;
            this.last = temp;
            size++;
        } else{
            Node<Item> temp = new Node(last, item, null);
            last.next = temp;
            last = temp;
            size++;
        }
    }

    // remove and return a random item
    public Item dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        } else{
            int n = StdRandom.uniform(size);
            Node<Item> temp = first;
            for(int i = 0; i < n; i++){
                temp = temp.next;
            }
            if(n == 0){
                first = temp.next;
                if(first != null){
                    first.prev = null;
                }
            } else if(n == size - 1){
                temp.prev.next = null;
                last = temp.prev;
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            size--;
            return temp.item;
        }
    }

    // return (but do not remove) a random item
    public Item sample(){
        if(isEmpty()){
            throw new NoSuchElementException();
        } else{
            int n = StdRandom.uniform(size);
            Node<Item> temp = first;
            for(int i = 0; i < n; i++){
                temp = temp.next;
            }
            return temp.item;
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item>{
        Node<Item> temp = first;
        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public Item next() {
            Node<Item> old = temp;
            temp = temp.next;
            return old.item;
        }
    }

    private void validation(Item item) {
        if(item == null) throw new NullPointerException();
    }

    // unit testing (optional)
    public static void main(String[] args){
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        for(int i = 0 ; i < 10; i++){
            rq.enqueue(i);
        }
        printRandomizedQueue(rq);
        System.out.println(rq.isEmpty());
        for(int i = 0; i < 10; i++){
            rq.dequeue();
            printRandomizedQueue(rq);
        }
        System.out.println(rq.isEmpty());

    }

    private static void printRandomizedQueue(RandomizedQueue<? extends Object> rq) {
        List<Object> list = new ArrayList<>();
        for(Object obj : rq){
            list.add(obj);
        }
        System.out.println(list);
    }
}
