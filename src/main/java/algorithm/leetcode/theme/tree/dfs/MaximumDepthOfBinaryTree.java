package algorithm.leetcode.theme.tree.dfs;

/**
 * 二叉树深度
 *
 * @author tanheyuan
 * @version 1.0
 * @since 2021/8/2
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            // 左节点最大深度和右节点最大深度比较，最大值加上1（根节点）
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
