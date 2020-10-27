package algorithm.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 每日一题——回文链表
 *
 * @author yuancome
 * @date 2020/10/23
 */

public class Day16 {
    private boolean isPalindrome(ListNode head) {
        // 链表加转换成数组
        List<ListNode> listNodeList = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            listNodeList.add(currentNode);
            currentNode = currentNode.next;
        }
        // 双指针进行判断
        int left = 0;
        int right = listNodeList.size() - 1;
        while (left < right) {
            if (listNodeList.get(left).val != listNodeList.get(right).val) {
                return false;
            }
            left++;
            right--;
        }
        return true;
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
