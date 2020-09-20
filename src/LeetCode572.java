import java.util.Deque;
import java.util.LinkedList;

public class LeetCode572 {

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) return false;
        return isSubtree(s.left,t) || isSubtree(s.right,t) || isSameTree(s,t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null && t ==null) return true;
        if(s.val != t.val) return false;
        if(s == null || t == null) return false;
//        if (s.left != null && t.left ==null) return false;
//        if (s.right != null && t.right ==null) return false;
//        if (s.left == null && t.left !=null) return false;
//        if (s.right == null && t.right !=null) return false;
//        if (s.left == null && s.right == null && t.left == null && t.right == null) return true;
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }

//修改版
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        if(s == null) return false;
//        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
//    }
//
//    public boolean isSameTree(TreeNode s, TreeNode t) {
//        if (s == null && t == null) return true;
//        if (s == null || t == null) return false;
//        if (s.val != t.val) return false;
//        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
//    }


}
