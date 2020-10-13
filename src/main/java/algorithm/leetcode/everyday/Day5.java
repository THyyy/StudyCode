package algorithm.leetcode.everyday;

/**
 * 每日一题——二叉搜索树的最小绝对差
 * 二叉搜索树中序遍历得到的值序列是递增有序的
 * 最小绝对差则为相邻两个节点值的差值
 * 用后一位值减前一位值必为正数，不用考虑绝对值问题
 *
 * @author yuancome
 * @date 2020/10/12
 */

public class Day5 {
    int pre;
    int ans;
    private int getMinimumDifference(TreeNode root) {
        // 设置默认值
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 中序遍历：左、root、右
        dfs(root.left);
        // 左节点为空时，pre = root.val;
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
