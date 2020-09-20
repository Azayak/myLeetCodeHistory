public class LeetCode865 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null) return null;

        int leftDepth,rightDepth;
        leftDepth = getDepth(root.left);
        rightDepth = getDepth(root.right);
        if(leftDepth==rightDepth) return root;
        else return leftDepth>rightDepth?subtreeWithAllDeepest(root.left):subtreeWithAllDeepest(root.right);
    }

    public int getDepth(TreeNode root){
        if(root==null) return 0;
        else return 1 + Math.max(getDepth(root.left),getDepth(root.right));
    }

}
