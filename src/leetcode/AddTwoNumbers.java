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


//2021-01-11 再做
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode resultHead = new ListNode();
//        ListNode resultCur = resultHead;
//        boolean shouldAdd = false;
//        while (l1 != null && l2 != null) {
//            int sum = l1.val + l2.val + (shouldAdd ? 1 : 0);
//            shouldAdd = false;
//            if (sum >= 10) {
//                shouldAdd = true;
//                sum = sum - 10;
//            }
//            resultCur.next = new ListNode(sum);
//            resultCur = resultCur.next;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//
//        if (l1 != null || l2 != null) {
//            ListNode rest = l1 != null ? l1 : l2;
//            ListNode restCur = rest;
//            while (shouldAdd) {
//                int sum = restCur.val + 1;
//                if (sum >= 10) {
//                    sum = sum - 10;
//                } else {
//                    shouldAdd = false;
//                }
//                restCur.val = sum;
//                if (restCur.next == null && shouldAdd) {
//                    restCur.next = new ListNode(1);
//                    break;
//                }
//                restCur = restCur.next;
//            }
//            resultCur.next = rest;
//        } else if (shouldAdd) {
//            resultCur.next = new ListNode(1);
//        }
//
//        return resultHead.next;
//    }
//}
