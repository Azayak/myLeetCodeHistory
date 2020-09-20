

public class binTree {




    public boolean getTheRes(TreeNode root) {
        if (root == null) return true;
        TreeNode preNode = null;
        return getSonRes(root.left, root, true) && getSonRes(root.right, root, false);
    }


    public boolean getSonRes(TreeNode root, TreeNode preNode, boolean isLeft) {
        if (root == null) {
            return true;
        }
        else {
            if (isLeft) {
                if (root.val < preNode.val) {
                    return getSonRes(root.left, root, true) && getSonRes(root.right, root, false);
                }
            }else {
                if (root.val > preNode.val) {
                    return getSonRes(root.left, root, true) && getSonRes(root.right, root, false);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        binTree solve = new binTree();
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(1);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node5.left = node6;

        System.out.println(solve.getTheRes(root));
    }


}
