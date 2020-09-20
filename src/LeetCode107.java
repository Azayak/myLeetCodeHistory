import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode107 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int length = treeNodes.size();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = treeNodes.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) treeNodes.offer(treeNode.left);
                if (treeNode.right != null) treeNodes.offer(treeNode.right);
            }
            res.add(0,list);
        }
        return res;
    }
}
