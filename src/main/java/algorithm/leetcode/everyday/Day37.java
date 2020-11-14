package algorithm.leetcode.everyday;

/**
 * 每日一题——奇偶链表
 *
 * @author yuancome
 * @date 2020/11/13
 */

public class Day37 {
    private ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenNode = head.next;
        ListNode ood = head;
        ListNode even = evenNode;
        while (even != null && even.next != null) {
            ood.next = even.next;
            ood = ood.next;
            even.next = ood.next;
            even = even.next;
        }
        ood.next = evenNode;
        return head;
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



