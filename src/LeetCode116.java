public class LeetCode116 {
    public Node connect(Node root) {
        constructPtr(root, null, false);
        return root;
    }

    public void constructPtr(Node node, Node preNode, boolean isLeft) {
        if (node != null) {
            if (preNode == null) {
                node.next = null;
            } else {
                if (isLeft) {
                    node.next = preNode.right;
                } else {
                    if (preNode.next != null) {
                        node.next = preNode.next.left;
                    } else {
                        node.next = null;
                    }
                }
            }
            constructPtr(node.left, node, true);
            constructPtr(node.right, node, false);
        }
    }
}
