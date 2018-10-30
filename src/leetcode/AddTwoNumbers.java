package leetcode;

/**
 * leetcode: https://leetcode.com/problems/add-two-numbers/
 * result: success
 *
 * @author huqj
 */

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, head = null;
        boolean inited = false;
        int remain = 0;
        while (true) {
            if (l1 == null || l2 == null) {
                break;
            }
            int n1 = l1.val, n2 = l2.val;
            int num = n1 + n2 + remain;
            if (num < 10) {
                if (inited) {
                    result.next = new ListNode(num);
                    result = result.next;
                } else {
                    result = new ListNode(num);
                    inited = true;
                    head = result;
                }
                remain = 0;
            } else {
                if (inited) {
                    result.next = new ListNode(num - 10);
                    result = result.next;
                } else {
                    result = new ListNode(num - 10);
                    inited = true;
                    head = result;
                }
                remain = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode t = l1 != null ? l1 : l2;
        if (t != null) {
            if (inited) {
                while (true) {
                    int num = t.val + remain;
                    if (num < 10) {
                        t.val = num;
                        result.next = t;
                        break;
                    } else {
                        result.next = new ListNode(num - 10);
                        remain = 1;
                    }
                    t = t.next;
                    result = result.next;
                    if (t == null) {
                        result.next = new ListNode(1);
                        break;
                    }
                }
            } else {
                result = t;
                head = result;
            }
        } else if (remain == 1) {
            result.next = new ListNode(1);
        }
        return head;
    }
}
