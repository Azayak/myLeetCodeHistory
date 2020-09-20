import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode637 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageRes = new ArrayList<>();
        if (root == null) return averageRes;

        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        int levelSize = 1;

        while(!treeNodes.isEmpty()) {
            double sum = 0;
            int nextSize = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = treeNodes.poll();
                sum += treeNode.val;
                if (treeNode.left != null) {
                    treeNodes.offer(treeNode.left);
                    nextSize++;
                }
                if (treeNode.right != null) {
                    treeNodes.offer(treeNode.right);
                    nextSize++;
                }
            }
            double average = sum / levelSize;
            averageRes.add(average);
            levelSize = nextSize;
        }
        return averageRes;
    }
}
