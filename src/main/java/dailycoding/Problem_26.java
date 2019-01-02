package dailycoding;

import dailycoding.leetcode.nodes.ListNode;

/**
 *Given a singly linked list and an integer k, remove the kth last element from the list.
 * k is guaranteed to be smaller than the length of the list.
 *
 * The list is very long, so making more than one pass is prohibitively expensive.
 *
 * Do this in constant space and in one pass.
 *
 * leetcode #19
 */
public class Problem_26 {
    public static void main(String[] args) {
        Problem_26 test = new Problem_26();
        ListNode head1 = ListNode.create(1,2,3,4,5,6,7,8,9,10);
        System.out.println("8 should missing : " + test.removeNthFromEnd(head1, 3));
        System.out.println("5, 8 should missing : " + test.removeNthFromEnd(head1, 5));
        System.out.println("2, 5, 8 should missing : " + test.removeNthFromEnd(head1, 7));
        System.out.println("1, 2, 5, 8 should missing : " + test.removeNthFromEnd(head1, 7));

        ListNode head2 = ListNode.create(1);
        System.out.println("should be null : " + test.removeNthFromEnd(head2, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode slow = newHead;
        ListNode fast = newHead;
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next =slow.next.next;
        return newHead.next;
    }
}
