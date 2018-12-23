package dailycoding.leetcode;

import dailycoding.leetcode.nodes.ListNode;

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
        Stack<Integer> s1 = toStack(l1);
        Stack<Integer> s2 = toStack(l2);

        int carry = 0;
        ListNode head = null;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int v1 = s1.isEmpty() ? 0 : s1.pop();
            int v2 = s2.isEmpty() ? 0 : s2.pop();

            int sum = carry + v1 + v2;
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;

            ListNode newHead = new ListNode(sum);
            newHead.next = head;
            head = newHead;
        }
        if(carry != 0){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    private Stack<Integer> toStack(ListNode node){
        Stack<Integer> s = new Stack<>();
        while(node != null){
            s.push(node.val);
            node = node.next;
        }

        return s;
    }
}
