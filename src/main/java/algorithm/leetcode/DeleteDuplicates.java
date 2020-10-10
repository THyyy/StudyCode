package algorithm.leetcode;

/**
 * 移除有序链表中的重复元素
 *
 * @author yuancome
 * @date 2020/10/10
 */

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归到最后节点
        head.next = deleteDuplicates(head.next);
        // 然后进行判断，需要注意是先递归再判断
        if (head.val == head.next.val) {
            head = head.next;
        }
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
