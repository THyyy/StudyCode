package algorithm.leetcode.everyday;

/**
 * 树的最大深度
 *
 * @author yuancome
 * @date 2020/12/2
 */

public class MaxDepthOfTree {
    private int maxDepth(TreeNode root) {
        if (root == null) {
            // 终止条件一：根节点为 null
            return 0;
        } else if (root.left == null && root.right == null) {
            // 终止条件二：左右节点均为 null
            return 1;
        } else {
            // 查询左子树最大深度
            int left = maxDepth(root.left);
            // 查询右子树最大深度
            int right = maxDepth(root.right);
            // 判断左子树右子树最大深度
            return 1 + Math.max(left, right);
        }
    }


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
}
