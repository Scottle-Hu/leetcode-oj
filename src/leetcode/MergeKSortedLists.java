package leetcode;

/**
 * leetcode: https://leetcode.com/problems/merge-k-sorted-lists/
 * result: success
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = null;
        for (int i = 0; i < lists.length - 1; i++) {
            head = mergeTwoSortedList(lists[i], lists[i + 1]);
            lists[i + 1] = head;
        }
        return head;
    }

    private ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode p1 = list1, p2 = list2, pp2 = null;
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

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        ListNode head = new MergeKSortedLists().mergeKLists(lists);
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
}
