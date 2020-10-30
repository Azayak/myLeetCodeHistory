import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        treeNodeDeque.push(root);
        while (!treeNodeDeque.isEmpty()) {
            TreeNode treeNode = treeNodeDeque.pop();
            res.add(treeNode.val);
            if (treeNode.right != null) {
                treeNodeDeque.push(treeNode.right);
            }
            if (treeNode.left != null) {
                treeNodeDeque.push(treeNode.left);
            }
        }
        return res;
    }
}
