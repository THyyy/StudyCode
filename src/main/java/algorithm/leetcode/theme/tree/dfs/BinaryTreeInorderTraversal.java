package algorithm.leetcode.theme.tree.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 *
 * @author tanheyuan
 * @version 1.0
 * @since 2021/7/29
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        process(root, result);
        return result;
    }

    private void process(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // 中序遍历先遍历左节点，根节点，右节点
        process(root.left, result);
        result.add(root.val);
        process(root.right, result);
    }


    class TreeNode {
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


