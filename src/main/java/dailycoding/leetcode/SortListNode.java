package dailycoding.leetcode;

import dailycoding.leetcode.nodes.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 * leatcode #148
 */
public class SortListNode {
    public static void main(String[] args) {
        SortListNode test = new SortListNode();
        ListNode node1 = ListNode.create(4,2,1,3);
        ListNode node2 = ListNode.create(-1,5,3,4,0);

        System.out.println(test.sortList(node1));
        System.out.println(test.sortList(node2));
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode left, ListNode right){
        if(left == null) return right;
        if(right == null) return left;

        if(left.val > right.val){
            right.next = mergeList(left, right.next);
            return right;
        } else {
            left.next = mergeList(left.next, right);
            return left;
        }
    }
}
