public class LeetCode235 {

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if ((p.val > root.val) != (q.val > root.val) || p.val == root.val || q.val == root.val) {
//            return root;
//        }
//        else {
//            if (p.val < root.val && q.val < root.val) {
//                return lowestCommonAncestor(root.left, p, q);
//            }
//            else {
//                return lowestCommonAncestor(root.left, p, q);
//            }
//        }
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        while (true) {
            if (p.val < res.val && q.val < res.val) {
                res = res.left;
            }
            else if (p.val > res.val && q.val > res.val) {
                res = res.right;
            }
            else {
                break;
            }
        }
        return res;
    }
}
