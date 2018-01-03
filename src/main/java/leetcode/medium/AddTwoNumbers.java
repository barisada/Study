package leetcode.medium;

/**
 *
 */
public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     *
     *
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Example

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     Explanation: 342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode first = result;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = l1 ==  null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            int rem = sum % 10;
            carry = sum >= 10 ? 1 : 0;
            if(result.val == -1){
                result.val = rem;
            } else {
                ListNode temp = new ListNode(rem);
                result.next = temp;
                result = result.next;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry != 0){
            result.next = new ListNode(carry);
        }

        return first;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}

