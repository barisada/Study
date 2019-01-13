package dailycoding.leetcode;

import dailycoding.leetcode.nodes.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class AddTwoNumber_II {
    public static void main(String[] args) {

        AddTwoNumber_II test = new AddTwoNumber_II();
        ListNode node1 = ListNode.create(3,9,9,9,9,9,9,9,9,9,9);
        ListNode node2 = ListNode.create(7);

        ListNode node3 = ListNode.create(2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9);
        ListNode node4 = ListNode.create(5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9);

        System.out.println("should be 40000000006 : "  + test.addTwoNumbers(node1, node2));
        System.out.println("should be [8,0,7,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,7,2,4,3,8] :" + test.addTwoNumbers(node3, node4));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = getListNodeAsStack(l1);
        Deque<ListNode> stack2 = getListNodeAsStack(l2);

        ListNode head = null;
        int carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int v1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int v2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            int sum = v1 + v2 + carry;
            carry = sum >= 10 ? 1 : 0;
            ListNode newHead = new ListNode(sum % 10);
            newHead.next = head;
            head = newHead;
        }
        if(carry == 1){
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    private Deque<ListNode> getListNodeAsStack(ListNode node) {
        Deque<ListNode> deque = new LinkedList<>();
        while(node != null){
            deque.push(node);
            node = node.next;
        }
        return deque;
    }
}
