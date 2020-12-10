package algorithm.demo;

/**
 * 链表相关数据结构代码模板
 *
 * @author yuancome
 * @date 2020/12/10
 */

public class ListCodeTemplate {
    // 单链表节点
    class ListNode {
        int val;
        ListNode next;
    }

    /**
     * 链表迭代访问
     *
     * @param head
     */
    private void traverse(ListNode head) {
        for (ListNode node = head; node != null; node = node.next) {
            // 迭代访问 node.val
        }
    }

    /**
     * 递归访问
     *
     * @param head
     */
    private void traverse2(ListNode head) {
        // 递归访问
        traverse2(head.next);
    }
}
