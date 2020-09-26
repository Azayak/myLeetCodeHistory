import java.util.*;

public class _LeetCode968 {

    Deque<TreeNode> yesNodes = new LinkedList<>();
    Deque<TreeNode> noNodes = new LinkedList<>();
    int res = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        noNodes.offer(root);
        bfs();
        return res;
    }

    public void bfs() {
        while (!yesNodes.isEmpty() || !noNodes.isEmpty()) {
            while (!yesNodes.isEmpty()) {
                res++;
                TreeNode treeNode = yesNodes.poll();
                if (treeNode.left != null) {
                    noNodes.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    noNodes.offer(treeNode.right);
                }
            }
            while (!noNodes.isEmpty()) {
                TreeNode treeNode = noNodes.poll();
                if (treeNode.left != null) {
                    yesNodes.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    yesNodes.offer(treeNode.right);
                }
            }
        }

    }
}
