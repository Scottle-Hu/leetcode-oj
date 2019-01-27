package leetcode;

/**
 * leetcode: https://leetcode.com/problems/merge-two-sorted-lists/
 * result: success
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1, p2 = l2, pp2 = null;
        ListNode head = null;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                ListNode t = p1;
                p1 = p2;
                p2 = t;
            }
            if (head == null) {
                head = p1;
            }
            if (pp2 != null)
                pp2.next = p1;
            while (p1.next != null && p1.next.val < p2.val) {
                p1 = p1.next;
            }
            ListNode tmp = p1.next;
            p1.next = p2;
            pp2 = p2;
            p2 = p2.next;
            p1 = tmp;
        }
        if (p2 == null) {
            pp2.next = p1;
        }
        return head;
    }
}
