//import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 您需要在二叉树的每一行中找到最大的值
 */




public class LeetCode515 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * BFS广度优先遍历
     */
//    public List<Integer> largestValues(TreeNode root) {
//        List<TreeNode> thisLine = new ArrayList<>();
//        List<TreeNode> nextLine = new ArrayList<>();
//        List<Integer> res = new ArrayList<>();
//
//        if(root!=null)
//            thisLine.add(root);
//
//        while(!thisLine.isEmpty()){
//
//            int max = thisLine.get(0).val;
//            for(int i=0;i<thisLine.size();i++){
//                max = max>=thisLine.get(i).val?max:thisLine.get(i).val;
//                if(thisLine.get(i).left!=null) nextLine.add(thisLine.get(i).left);
//                if(thisLine.get(i).right!=null) nextLine.add(thisLine.get(i).right);
//            }
//            res.add(max);
//            thisLine = nextLine;
//            nextLine = new ArrayList<>();
//        }
//
//
//        return res;
//    }

    /**
     * DFS深度优先遍历
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        DFSSearch(root,res,1);
        return res;
    }

    public void DFSSearch(TreeNode root,List<Integer> res,int level){
        if(root==null) return;

        if(level==res.size()+1){
            res.add(root.val);
        }
        else {
            res.set(level - 1, Math.max(res.get(level - 1), root.val));
        }
        DFSSearch(root.left,res,level+1);
        DFSSearch(root.right,res,level+1);
        return;
    }
}
