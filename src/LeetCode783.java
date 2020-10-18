public class LeetCode783 {
    int pre;
    int res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
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
