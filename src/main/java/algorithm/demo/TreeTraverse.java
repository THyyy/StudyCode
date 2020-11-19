package algorithm.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树的遍历
 *
 * @author yuancome
 * @date 2020/11/19
 */

public class TreeTraverse {
    /**
     * 广度搜索算法
     *
     * @param treeNode
     * @return
     */
    private List<TreeNode> BFS(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        List<TreeNode> treeNodeList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode != null) {
                treeNodeList.add(currentNode);
                stack.push(currentNode.left);
                stack.push(currentNode.right);
            }
        }
        return treeNodeList;
    }

    /**
     * 深度搜索算法
     *
     * @param treeNode
     * @return
     */
    private void DFS(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        DFS(treeNode.left);
        DFS(treeNode.right);
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
