package algorithm.leetcode.everyday;

/**
 * 每日一题——填充每个节点的下一个右侧节点指针
 *
 * @author yuancome
 * @date 2020/10/15
 */

public class Day8 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node pre = root;
        Node current = null;
        // 当左节点不为 null 时，右节点必存在（完美二叉树性质）
        while (pre.left != null) {
            current = pre;
            while (current != null) {
                // 同一根节点时，左节点指向右节点
                current.left.next = current.right;
                if (current.next != null) {
                    // 同一层不同根节点时，右节点的 next 指向根节点的 next 节点的左节点
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            pre = pre.left;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
