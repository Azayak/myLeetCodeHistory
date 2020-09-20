import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode111 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int minDepth(TreeNode root) {
//        return BFSMinDepth(root);
        return DFSMinDepth(root,1);
    }

    public int BFSMinDepth(TreeNode root){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        int length = 1;
        int depth = 1;
        while(!nodeQueue.isEmpty()){
            int nextLength = 0;

            for(int i=0;i<length;i++){
                TreeNode node = nodeQueue.poll();
                if(node.left==null&&node.right==null){
                    return depth;
                }
                if(node.left!=null){
                    nodeQueue.add(node.left);
                    nextLength++;
                }
                if(node.right!=null){
                    nodeQueue.add(node.right);
                    nextLength++;
                }
            }
            depth++;
            length = nextLength;
        }
        return depth;
    }

    public int DFSMinDepth(TreeNode root,int depth){
        if(root==null) return depth-1;
        if(root.left==null && root.right==null) return depth;
        if(root.left==null && root.right!=null) return DFSMinDepth(root.right,depth+1);
        if(root.left!=null && root.right==null) return DFSMinDepth(root.left,depth+1);
        return Math.min(DFSMinDepth(root.left,depth+1),DFSMinDepth(root.right,depth+1));
    }

}
