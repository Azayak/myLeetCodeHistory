public class LeetCode530 {
//    int res = Integer.MAX_VALUE;
//    public int getMinimumDifference(TreeNode root) {
//        dfs(root);
//        return res;
//    }
//
//    public void dfs(TreeNode treeNode) {
//        if (treeNode != null) {
//            if (treeNode.left != null) {
//                res = Math.min(res, treeNode.val - treeNode.left.val);
//            }
//            if (treeNode.right != null) {
//                res = Math.min(res, treeNode.right.val - treeNode.val);
//            }
//            dfs(treeNode.left);
//            dfs(treeNode.right);
//        }
//    }
    int pre;
    int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}
