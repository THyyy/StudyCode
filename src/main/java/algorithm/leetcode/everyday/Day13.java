package algorithm.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 每日一题——重排链表
 *
 * @author yuancome
 * @date 2020/10/20
 */

public class Day13 {
    private void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> nodeList = new ArrayList<>();
        // 构造线性表
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        int i = 0, j = nodeList.size() - 1;
        while (i < j) {
            nodeList.get(i).next = nodeList.get(j);
            i++;
            if (i == j) {
                break;
            }
            nodeList.get(j).next = nodeList.get(i);
            j--;
        }
        // 最后节点指向 null
        nodeList.get(i).next = null;
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
