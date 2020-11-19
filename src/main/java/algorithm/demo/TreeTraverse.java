package algorithm.demo;

import java.util.*;

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
        List<TreeNode> resultList = new ArrayList<>();
        //记录某层具有多少个节点
        int levelNum = 0;
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(treeNode);
        while (!treeQueue.isEmpty()) {
            levelNum = treeQueue.size();
            while (levelNum > 0) {
                TreeNode tempNode = treeQueue.poll();
                if (tempNode != null) {
                    resultList.add(tempNode);
                    treeQueue.add(tempNode.left);
                    treeQueue.add(tempNode.right);
                }
                levelNum--;
            }
        }
        return resultList;
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
