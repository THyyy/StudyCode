package algorithm.leetcode.everyday;

/**
 * 每日一题——排序链表
 *
 * @author yuancome
 * @date 2020/11/21
 */

public class Day45 {
    private ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode left = head;
        ListNode right = head.next;
        while (right != null) {
            if (left.val < right.val) {
                left = left.next;
            } else {
                ListNode pre = preHead;
                while (pre.next.val < right.val) {
                    pre = pre.next;
                }
                left.next = right.next;
                right.next = pre.next;
                pre.next = right;
            }
            right = left.next;
        }
        return preHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
