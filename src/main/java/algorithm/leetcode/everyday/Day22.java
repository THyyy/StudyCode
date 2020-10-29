package algorithm.leetcode.everyday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 每日一题——从根到叶子节点生成的所有数字之和
 *
 * @author yuancome
 * @date 2020/10/29
 */

public class Day22 {
    private int sumNumbers(TreeNode root) {
        return sum(root,0);
    }

    private int sum(TreeNode root, int preResult) {
        if (root == null) {
            return 0;
        }
        int current = preResult * 10 + root.val;
        if (root.left == null && root.right == null) {
            return current;
        } else {
            return sum(root.left, current) + sum(root.right, current);

        }
    }

    /**
     * 广度优先算法
     *
     * @param root
     * @return
     */
    private int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
