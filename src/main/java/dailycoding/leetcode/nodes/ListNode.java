package dailycoding.leetcode.nodes;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode create(int...vals) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int val : vals){
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return head.next;
    }

    @Override
    public String toString() {
        return val + "->" + next;
    }
}
