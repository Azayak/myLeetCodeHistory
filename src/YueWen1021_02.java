public class YueWen1021_02 {

//    class Solution {
//
//        public TreeNode nearestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
//            if (root == null || root.val == p.val || root.val == q.val) {
//                return root;
//            }
//            TreeNode left = nearestCommonAncestor(root.left, p, q);
//            TreeNode right = nearestCommonAncestor(root.right, p, q);
//            if (left == null) {
//                return right;
//            }
//            if (right == null) {
//                return left;
//            }
//            return root;
//        }
//    }
}
