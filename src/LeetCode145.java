import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode145 {

    List<Integer> res = new ArrayList<>();

//    public List<Integer> postorderTraversal(TreeNode root) {
//        if (root == null) return res;
//        dfs(root);
//        return res;
//    }
//
//    private void dfs(TreeNode treeNode) {
//        if (treeNode != null) {
//            dfs(treeNode.left);
//            dfs(treeNode.right);
//            res.add(treeNode.val);
//        }
//    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        TreeNode preNode = null;
        while (root != null || !treeNodeDeque.isEmpty()) {
            while (root != null) {
                treeNodeDeque.push(root);
                root = root.left;
            }
            root = treeNodeDeque.pop();
            if (root.right == null || root.right == preNode) {
                res.add(root.val);
                preNode = root;
                root = null;
            } else {
                treeNodeDeque.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
