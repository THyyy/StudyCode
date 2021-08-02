package algorithm.leetcode.theme.tree.dfs;

/**
 * 对称二叉树
 *
 * @author tanheyuan
 * @version 1.0
 * @since 2021/8/2
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return check(root, root);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}
