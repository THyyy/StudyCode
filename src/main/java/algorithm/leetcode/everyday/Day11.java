package algorithm.leetcode.everyday;

/**
 * 每日一题——删除链表的倒数第N个节点
 *
 * @author yuancome
 * @date 2020/10/18
 */

public class Day11 {
    private ListNode removeNthFromEnd(ListNode head, int n) {
        // 构建虚拟节点，虚拟节点的指针指向 head
        ListNode dummy = new ListNode(0, head);
        // 构建一个pre节点和一个last节点，pre节点比last节点快 n 步
        ListNode pre = head;
        ListNode last = dummy;
        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }
        // pre 和 last 同时遍历，当 pre 为 null 时，此时的 last 是倒数第 n 个节点
        while (pre != null) {
            pre = pre.next;
            last = last.next;
        }
        // 把last 的指针指向下下个节点，从而移除倒数第 n 个节点
        last.next = last.next.next;
        ListNode result = dummy.next;
        return result;
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
