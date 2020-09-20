import java.util.ArrayList;
import java.util.List;

class treeNode {
    int val;
    treeNode left;
    treeNode right;
    treeNode(int x) { val = x; }
}


public class LeetCode257 {

    List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(treeNode root) {
        if (root == null) return paths;
        if (root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
            return paths;
        }
        String path = String.valueOf(root.val);
        if (root.left != null) dfs(root.left, path);
        if (root.right != null) dfs(root.right, path);
        return paths;
    }


    public void dfs(treeNode treeNode, String path) {
        path = path+"->"+String.valueOf(treeNode.val);
        if (treeNode.left == null && treeNode.right == null) {
            paths.add(path);
            return;
        }
        if (treeNode.left != null) dfs(treeNode.left, path);
        if (treeNode.right != null) dfs(treeNode.right, path);
    }

    public static void main(String[] args) {
        LeetCode257 solve = new LeetCode257();
        treeNode root = new treeNode(1);
        root.left = new treeNode(2);
        root.left.right = new treeNode(5);
        root.right = new treeNode(3);

        List<String> paths = solve.binaryTreePaths(root);
        for (String path : paths) {
            System.out.println(path);
        }

    }
}
