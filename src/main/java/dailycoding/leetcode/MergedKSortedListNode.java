package dailycoding.leetcode;

import dailycoding.leetcode.nodes.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 *
 * Output: 1->1->2->3->4->4->5->6
 *
 * leetcode #23
 *
 */
public class MergedKSortedListNode {
    public static void main(String[] args) {
        MergedKSortedListNode test = new MergedKSortedListNode();
        ListNode[] arr = new ListNode[]{ListNode.create(1,4,5), ListNode.create(1,3,4), ListNode.create(2,6)};

        System.out.println(test.mergeKLists(arr));

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        int i = 0;
        while(i < lists.length){
            ListNode left = i < lists.length ? lists[i++] : null;
            ListNode right = i < lists.length ? lists[i++] : null;
            result = merge(result, merge(left, right));
        }
        return result;
    }

    private ListNode merge(ListNode left, ListNode right){
        if(left == null) return right;
        if(right == null) return left;
        if(left.val > right.val){
            right.next = merge(left, right.next);
            return right;
        } else {
            left.next = merge(left.next, right);
            return left;
        }
    }
}
