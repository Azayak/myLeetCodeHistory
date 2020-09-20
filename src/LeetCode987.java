import java.util.*;

public class LeetCode987 {

//    class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//    }
//
//    无法处理统一列中的顺序问题
//    List<List<Integer>> res = new LinkedList<>();
//    int mid = 0;
//
//    public List<List<Integer>> verticalTraversal(TreeNode root) {
//        dfs(root, 0);
//        for (int i = 0; i < res.size(); i++) {
//            if (res.get(i).size() == 0) {
//                res.remove(i);
//                i--;
//            }
//        }
//        return res;
//    }
//
//    public void dfs(TreeNode treeNode, int x) {
//        if (treeNode == null) {
//            insert(null, x);
//            return;
//        }
//        insert(treeNode,x);
//        dfs(treeNode.left, x - 1);
//        dfs(treeNode.right, x + 1);
//    }
//
//    public void insert(TreeNode treeNode, int x) {
//        if (x + mid >= 0 && x + mid <= res.size() - 1) {
//            if (treeNode != null) {
//                for (int i = 0; i < res.get(mid + x).size(); i++) {
//                    if (res.get(mid + x).get(i) > treeNode.val) {
//                        res.get(mid + x).add(i,treeNode.val);
//                        break;
//                    }
//                    if (i == res.get(mid + x).size() - 1) {
//                        res.get(mid + x).add(res.get(mid + x).size(),treeNode.val);
//                    }
//                }
//            }
//        }
//        else {
//            List<Integer> newList = new LinkedList<>();
//            if (treeNode != null) {
//                newList.add(treeNode.val);
//            }
//            if (x + mid < 0) {
//                res.add(0, newList);
//                mid++;
//            }
//            if (x +mid > res.size() - 1) {
//                res.add(res.size(), newList);
//            }
//        }
//    }

    public class Node {
        public int x;
        public int y;
        public int val;
        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    // 先将所有节点的坐标和值收集起来，然后按照题目中的规则对这些节点排序，最后按照坐标x的值进行收集
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Node> list = new ArrayList<>();
        // 收集所有节点信息
        collect(list, root, 0, 0);
        // 定义排序规则并排序
        list.sort((node1, node2) -> {
            int x1 = node1.x;
            int y1 = node1.y;
            int v1 = node1.val;
            int x2 = node2.x;
            int y2 = node2.y;
            int v2 = node2.val;
            // x小的在前
            if (x1 != x2) return x1 - x2;
            // y大的在前
            if (y1 != y2) return y2 - y1;
            // 节点值小的在前
            return v1 - v2;
        });

        // 对所有x相同的节点分组收集
        int i = 0;
        do {
            int x = list.get(i).x;
            List<Integer> l = new ArrayList<>();
            while (i < list.size() && x == list.get(i).x) {
                l.add(list.get(i).val);
                ++i;
            }
            ans.add(l);
        } while (i != list.size());

        return ans;
    }

    // 收集所有节点的信息
    private void collect(List<Node> list, TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        list.add(new Node(x, y, root.val));
        if (root.left != null) {
            collect(list, root.left, x - 1, y - 1);
        }
        if (root.right != null) {
            collect(list, root.right, x + 1, y - 1);
        }
    }
}
