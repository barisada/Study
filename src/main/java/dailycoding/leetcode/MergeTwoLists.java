package dailycoding.leetcode;

import dailycoding.leetcode.nodes.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * leetcode #23
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        MergeTwoLists test = new MergeTwoLists();
        ListNode node1 = ListNode.create(1,2,4);
        ListNode node2 = ListNode.create(1,3,4);

        System.out.println(test.mergeTwoLists(node1, node2));
    }

    //todo update logic shorter or recursive...
    public ListNode mergeTwoLists(ListNode left, ListNode right) {
        if(left == null && right == null) return null;
        if(right == null ) return left;
        if(left == null) return right;
        ListNode head = left;
        ListNode prev = null;

        while(left != null && right != null){
            if(left.val <= right.val){
                prev = left;
                left = left.next;
            } else{
                if(prev == null){
                    prev = right;
                    right = right.next;
                    prev.next = left;
                    head = prev;

                } else {
                    prev.next = right;
                    right = right.next;
                    prev.next.next = left;
                    prev = prev.next;
                }
            }
        }

        if(left != null) prev.next = left;
        if(right != null) prev.next =right;

        return head;
    }
}
