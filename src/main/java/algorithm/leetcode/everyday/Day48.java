package algorithm.leetcode.everyday;

/**
 * 每日一题—— 完全二叉树的节点个数
 *
 * @author yuancome
 * @date 2020/11/24
 */

public class Day48 {
    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
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
