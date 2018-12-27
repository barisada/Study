package dailycoding;

import dailycoding.leetcode.nodes.ListNode;


/**
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 *
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 *
 * In this example, assume nodes with the same value are the exact same node objects.
 *
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 *
 * leetcode #160
 */
public class Problem_20 {

    public static void main(String[] args) {
        Problem_20 test = new Problem_20();
        ListNode n1 = ListNode.create(3,7);
        ListNode n2 = ListNode.create(99,1);
        ListNode dup = ListNode.create(8,10);
        n1.next = dup; n2.next = dup;
        System.out.println("should be 8 : " + test.intersect(n1, n2));

        n1 = ListNode.create(4,1);
        n2 = ListNode.create(5,0,1);
        dup = ListNode.create(8,4,5);
        n1.next = dup; n2.next = dup;
        System.out.println("should be 8 :" + test.intersect(n1, n2));

    }

    public ListNode intersect(ListNode n1, ListNode n2){
        int len1 = getLength(n1);
        int len2 = getLength(n2);

        n1 = len1 > len2 ? move(n1, len1 - len2) : n1;
        n2 = len2 > len1 ? move(n2, len2 - len1) : n2;

        while(n1 != null && n2 != null){
            if(n1 == n2) return n1;
            n1 = n1.next;
            n2 = n2.next;
        }
        return null;
    }

    private ListNode move(ListNode head, int i) {
        while(i != 0){
            head = head.next;
            i--;
        }
        return head;
    }

    private int getLength(ListNode node) {
        int count = 0;
        while(node != null){
            node = node.next;
            count++;
        }
        return count;
    }


}
