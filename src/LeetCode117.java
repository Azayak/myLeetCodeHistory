import java.util.Deque;
import java.util.LinkedList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
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


public class LeetCode117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> nodeDeque = new LinkedList<Node>();
        nodeDeque.offer(root);

        while (!nodeDeque.isEmpty()) {
            int size = nodeDeque.size();
            Node lastNode = null;
            for (int i = 1; i <= size; i++) {
                Node nextNode = nodeDeque.poll();
                if (nextNode.left != null) {
                    nodeDeque.offer(nextNode.left);
                }
                if (nextNode.right != null) {
                    nodeDeque.offer(nextNode.right);
                }
                if (i > 1) {
                    lastNode.next = nextNode;
                }
                lastNode = nextNode;
            }
        }
        return root;
    }
}

// package com.leetcode.explore.learnCard.dataStructureBinaryTree.conclusion4;

/**
 * 补充节点的右侧指针，不是完美二叉树
 */
class Solution {
    public Node connect(Node root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNextNoNullChild(root);
        }
        if (root.left == null) {
            root.right.next = getNextNoNullChild(root);
        }
        if (root.right == null) {
            root.left.next = getNextNoNullChild(root);
        }

        //这里要注意：先递归右子树，否则右子树根节点next关系没建立好，左子树到右子树子节点无法正确挂载
        root.right = connect(root.right);
        root.left = connect(root.left);

        return root;
    }

    /**
     * 一路向右找到有子节点的根节点
     */
    private static Node getNextNoNullChild(Node root) {
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }
            if (root.next.right != null) {
                return root.next.right;
            }
            root = root.next;
        }
        return null;
    }
}
