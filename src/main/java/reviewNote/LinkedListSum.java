package reviewNote;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 369, 4610
 * add both 3-6-9 and 4-6-1-0 return as linked list
 */
public class LinkedListSum {

    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public String toString(){
            List<Integer> list = new ArrayList<>();
            list.add(val);

            Node next = this.next;
            while(next != null){
                list.add(next.val);
                next = next.next;
            }

            return list.toString();
        }
    }


    static Node sum(Node a, Node b){

        System.out.println(a + " , " + b);

        int aVal = 0;
        int bVal = 0;
        while(a != null || b != null){
            if(a != null) {
                aVal = aVal * 10 + a.val;
                a = a.next;
            }
            if(b != null){
                bVal = bVal * 10  + b.val;
                b = b.next;
            }
        }
        int sum = aVal + bVal;

        return createNode(sum);
    }

    static private Node createNode(int sum) {
        Stack<Integer> stack = new Stack<>();
        while(sum > 0){
            int remainder = sum % 10;
            sum = sum / 10;
            stack.push(remainder);
        }

        Node node = new Node(0, null);
        Node head = node;
        while(!stack.isEmpty()){
            int val = stack.pop();
            node.next = new Node(val, null);
            node = node.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, new Node(6, new Node(6, null)));
        Node node2 = new Node(2, new Node(0, new Node(3, new Node(4, null))));
        System.out.println(node1 + " + " + node2);
        System.out.println(sum(node1, node2));
    }

}
