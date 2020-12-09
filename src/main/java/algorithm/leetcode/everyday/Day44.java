package algorithm.leetcode.everyday;

/**
 * 每日一题——对链表进行插入排序
 *
 * @author yuancome
 * @date 2020/11/20
 */

public class Day44 {
    private ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode lastSort = head;
        ListNode curr = head.next;
        while (curr != null) {
            // 当前节点比最后的节点值大时，直接移动最后的排序节点
            if (curr.val >= lastSort.val) {
                lastSort = lastSort.next;
            } else {
                // 从头开始遍历到 lastSort
                ListNode pre = preHead;
                while (pre.next.val <= curr.val) {
                    pre = pre.next;
                }
                // 插入 curr 节点
                lastSort.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = lastSort.next;
        }
        return preHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
