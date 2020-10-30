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
//                return lowestCommonAncest or(root.left, p, q);
//            }
//        }
//    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


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
