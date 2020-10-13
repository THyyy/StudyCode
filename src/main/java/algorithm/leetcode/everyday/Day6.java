package algorithm.leetcode.everyday;

/**
 * 每日一题——两两交换链表中的节点
 *
 * @author yuancome
 * @date 2020/10/13
 */

public class Day6 {
    private ListNode swapPairs(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        // head下个节点指向后面的节点
        head.next = swapPairs(next.next);
        // next的下个节点指向head
        next.next = head;
        return next;
    }

    private ListNode swapPairs2(ListNode head) {
        // 非递归方法需要两个指针 pre 和 temp
        // pre 用来保留头指针位置，temp 进行指针交换
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }


    // Definition for singly-linked list.
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
