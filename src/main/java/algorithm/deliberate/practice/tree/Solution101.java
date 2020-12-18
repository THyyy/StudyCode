package algorithm.deliberate.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * @author yuancome
 * @date 2020/12/18
 */

public class Solution101 {
    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return checkSave(root, root);
    }

    private boolean checkSave(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return q.val == p.val && checkSave(p.left, q.right) && checkSave(p.right, q.left);
    }

    /**
     * 迭代解法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        return checkSave2(root, root);
    }

    private boolean checkSave2(TreeNode a, TreeNode b) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(a);
        q.offer(b);
        while (!q.isEmpty()) {
            a = q.poll();
            b = q.poll();
            if (a == null && b == null) {
                continue;
            }
            if (a == null || b == null || (a.val != b.val)) {
                return false;
            }
            q.offer(a.left);
            q.offer(b.right);

            q.offer(a.right);
            q.offer(b.left);
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
