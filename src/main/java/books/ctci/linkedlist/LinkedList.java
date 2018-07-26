package books.ctci.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    Node head;
    Node last;
    int size = 0;

    public int get(int at){
        Node target = head;
        for(int i = 0; i < at; i++){
            target = target.next;
        }
        return target.val;
    }

    public void add(int v){
        if(head == null){
            Node node = new Node(v);
            head = node;
            last = node;
        } else {
            Node node = new Node(v);
            node.prev = last;
            last.next = node;
            last = node;
        }
        size++;
    }

    public void insertAt(int at, int val){
        Node target = head;
        for(int i = 0; i < at; i++){
            target = target.next;
        }

        Node node = new Node(val);
        if(at == 0) {
            node.next = head;
            head.prev = node;
            head = node;
        } else if(at == size){
            add(val);
            return;
        }
        else {
            target.prev.next = node;
            node.next = target;
            node.prev = target.prev;
            target.prev = node;
        }
        size++;
    }

    public int removeAt(int at){
        if(at >= size) throw  new IllegalArgumentException("too big input for this list size");

        Node target = head;
        for(int i = 0; i < at; i++){
            target = target.next;
        }

        if(at == 0){
            head = head.next;
            head.prev = null;
        } else if(at == size - 1){
            return removeLast();
        } else {
            target.prev.next = target.next;
            if(target.next != null) {
                target.next.prev = target.prev;
            }
        }

        size--;
        return target.val;
    }

    public int removeLast(){
        int val = last.val;

        last = last.prev;
        last.next = null;
        size--;
        return val;
    }

    public String toString(){
        List<Integer> list = new ArrayList<>();
        Node node = head;
        while(node != null){
            list.add(node.val);
            node = node.next;
        }

        return list.toString();
    }

    public int size(){
        return  size;
    }

    class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }
}
