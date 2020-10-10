package algorithm.leetcode.everyday;

/**
 * 每日一题——环形链表
 * 本题使用快慢指针思想
 * 因为存在环形则总会有快指针超过慢指针 N 圈且快指针等于慢指针的时候
 *
 * @author yuancome
 * @date 2020/10/9
 */

public class Day2 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


