package algorithm.leetcode.theme.tree.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

    /**
     * 迭代实现
     * 迭代算法必须开拓另一个空间进行节点存储
     *
     * @param root
     * @return
     */
    private List<Integer> process2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();

        while (root != null && !nodeDeque.isEmpty()) {
            while (root != null) {
                nodeDeque.push(root);
                root = root.left;
            }
            root = nodeDeque.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}


