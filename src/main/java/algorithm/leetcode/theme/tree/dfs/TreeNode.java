package algorithm.leetcode.theme.tree.dfs;

/**
 * 二叉树节点类，便于引用
 *
 * @author tanheyuan
 * @version 1.0
 * @since 2021/7/30
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
