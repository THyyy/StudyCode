package algorithm.leetcode;

/**
 * 合并两个链表
 *
 * @author yuancome
 * @date 2020/10/9
 */

public class MergeTowLists {
    /**
     * 递归实现
     * 时间复杂度O(n+m)
     * 空间复杂度O(n+m)
     *
     * @param l1
     * @param l2
     * @return 递归过程中的结果，最后结果为结果list 头指针
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = l1.val < l2.val ? l1 : l2;
        result.next = mergeTwoLists(result.next, l1.val >= l2.val ? l1 : l2);
        return result;
    }

    /**
     * 迭代实现
     * 时间复杂度O(n+m)
     * 空间复杂度O(1)
     *
     * @param l1
     * @param l2
     * @return 结果list 头指针
     */
    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev = l1;
                l1 = l1.next;
            } else {
                prev = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static void main(String[] args) {
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
