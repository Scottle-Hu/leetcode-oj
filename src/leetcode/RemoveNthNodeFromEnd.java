package leetcode;

/**
 * leetcode: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * result: success
 */
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p1 = head;
        ListNode p2 = head;
        int span = 0;
        while (span < n - 1) {
            p2 = p2.next;
            span++;
        }
        boolean flag = false;
        while (p2.next != null) {
            p1 = p1.next;
            pre = pre.next;
            p2 = p2.next;
            flag = true;
        }
        if (flag) {
            pre.next = p1.next;
            return head;
        } else {
            return p1.next;
        }
    }
}
