import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode105 {

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


//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder.length == 0 || inorder.length == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[0]);
//
//        int inRootPos = -1;
//        for (int i = 0; i < inorder.length; i++) {
//            if (inorder[i] == preorder[0]) {
//                inRootPos = i;
//                break;
//            }
//        }
//        int preLeftBegin = Math.min(1, preorder.length - 1);
//        int preLeftEnd = Math.min(inRootPos + 1, preorder.length);
//        int preRightBegin = Math.min(inRootPos + 1, preorder.length - 1);
//        int preRightEnd = preorder.length;
//        int inLeftBegin = Math.max(0, inRootPos - 1);
//        int inLeftEnd = Math.max(inRootPos, 0);
//        int inRightBegin = Math.min(inRootPos + 1, inorder.length - 1);
//        int inRightEnd = inorder.length;
//        int[] preLeft = Arrays.copyOfRange(preorder, preLeftBegin, preLeftEnd);
//        int[] preRight = Arrays.copyOfRange(preorder, preRightBegin, preRightEnd);
//        int[] inLeft = Arrays.copyOfRange(inorder, inLeftBegin, inLeftEnd);
//        int[] inRight = Arrays.copyOfRange(inorder, inRightBegin, inRightEnd);
//        root.left = buildTree(preLeft, inLeft);
//        root.right = buildTree(preRight, inRight);
//        return root;
//    }

    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        int preorder_root = preorder_left;
        int inorder_root = indexMap.get(preorder[preorder_root]);

        TreeNode root = new TreeNode(preorder[preorder_root]);
        int size_left_subtree = inorder_root - inorder_left;
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
