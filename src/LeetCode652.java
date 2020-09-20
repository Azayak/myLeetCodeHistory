import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//    }
//}

public class LeetCode652 {

//    List<TreeNode> res = new ArrayList<>();
//
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        if (root == null) return res;
//        dfs(root);
//        return res;
//    }
//
//    public void dfs(TreeNode root) {
//        List<TreeNode> treeNodes = new ArrayList<>();
//        treeNodes.add(root);
//        int length = 1;
//        for (int i = 0; i < length; i++) {
//            TreeNode treeNode = treeNodes.get(i);
//            if (treeNode.left != null) {
//                treeNodes.add(treeNode.left);
//                length++;
//            }
//            if (treeNode.right != null) {
//                treeNodes.add(treeNode.right);
//                length++;
//            }
//        }
//        for (TreeNode treeNode : treeNodes) {
//            System.out.print(treeNode.val + "   ");
//        }
//        System.out.println();
//        for (int i = 0; i < treeNodes.size() - 1; i++) {
//            for (int j = i + 1; j < treeNodes.size(); j++) {
//                if (isSame(treeNodes.get(i), treeNodes.get(j))) {
//                    System.out.print(treeNodes.get(i).val + "       ");
//                    System.out.println(isExist(res, treeNodes.get(i)));
//                    if (!isExist(res, treeNodes.get(i)))
//                        res.add(treeNodes.get(i));
//                }
//            }
//        }
//    }
//
//    public boolean isExist(List<TreeNode> treeNodes, TreeNode treeNode) {
//        for (TreeNode treeNode1 : treeNodes) {
//            if (isSame(treeNode1, treeNode)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean isSame(TreeNode t1, TreeNode t2) {
//        if (t1 == null && t2 == null) return true;
//        if (t1 == null || t2 == null) return false;
//        if (t1.val != t2.val) return false;
//        else return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
//    }

    public static void main(String[] args) {
        LeetCode652 solve = new LeetCode652();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);

        List<TreeNode> res = solve.findDuplicateSubtrees(root);
    }



    Map<String, Integer> count;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap();
        ans = new ArrayList();
        collect(root);
        return ans;
    }

    public String collect(TreeNode node) {
        if (node == null) return "#";
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2)
            ans.add(node);
        return serial;
    }
}