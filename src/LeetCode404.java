public class LeetCode404 {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return sum;
        }
        dfs(root, false);
        return sum;
    }

    private void dfs(TreeNode treeNode, boolean isLeft) {
        if (treeNode.left == null && treeNode.right == null && isLeft) {
            sum += treeNode.val;
        }
        else {
            if (treeNode.left != null) {
                dfs(treeNode.left, true);
            }
            if (treeNode.right != null) {
                dfs(treeNode.right, false);
            }
        }
    }
}
