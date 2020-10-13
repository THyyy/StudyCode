package algorithm.leetcode.everyday;

/**
 * 每日一题——环形链表
 *
 * @author yuancome
 * @date 2020/10/10
 */

public class Day3 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            // 判断是否有环
            if (fast == slow) {
                break;
            }
        }
        // 第一轮slow已经走了 nb 步，则fast重新定向head，走a步时，a+nb一定在还入口处
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

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
