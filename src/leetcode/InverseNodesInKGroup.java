package leetcode;

/**
 * leetcode: https://leetcode.com/problems/reverse-nodes-in-k-group/
 * result: success
 */
public class InverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode tail, ret = null, preTail = null, tmp = null;
        outer:
        while (true) {
            tail = head;
            for (int i = 0; i < k - 1; i++) {
                if (tail != null && tail.next != null) {
                    tail = tail.next;
                } else {
                    if (preTail != null) {
                        preTail.next = head;
                    } else {
                        ret = head;
                    }
                    break outer;
                }
            }
            tmp = tail.next;
            reverseUtilEnd(head, tail);
            if (ret == null) {
                ret = tail;
            } else {
                preTail.next = tail;
            }
            preTail = head;
            head = tmp;

        }
        return ret;
    }

    private void reverseUtilEnd(ListNode head, ListNode end) {
        if (head == end || head == null) {
            return;
        }
        reverseUtilEnd(head.next, end);
        head.next.next = head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head = new InverseNodesInKGroup().reverseKGroup(head, 3);
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
}
