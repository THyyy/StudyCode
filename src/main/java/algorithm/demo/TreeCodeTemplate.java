package algorithm.demo;

/**
 * 二叉树相关数据结构代码模板
 *
 * @author yuancome
 * @date 2020/12/10
 */

public class TreeCodeTemplate {
    // 二叉树节点
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * 二叉树的递归访问
     *
     * @param root
     */
    private void traverse(TreeNode root) {
        // 前序遍历
        // 先遍历 root 节点，再遍历左节点，后遍历右节点
        traverse(root.left);
        // 中序遍历
        // 先遍历左节点，再遍历 root 节点，后遍历右节点
        traverse(root.right);
        // 后序遍历
        // 先遍历左节点，再遍历右节点，后遍历 root 节点
    }
}
