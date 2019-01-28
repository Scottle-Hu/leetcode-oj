package leetcode;

/**
 * leetcode: https://leetcode.com/problems/swap-nodes-in-pairs/
 * result: success
 */
public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head, p2 = head.next, ret = null, tail = null;
        while (p1 != null && p2 != null) {
            if (ret == null) {
                ret = p2;
            } else {
                tail.next = p2;
            }
            tail = p1;
            p1.next = p2.next;
            p2.next = p1;
            p1 = p1.next;
            if (p1 != null)
                p2 = p1.next;
        }
        return ret;
    }
}
