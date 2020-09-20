import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode1367 {


//     Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        List<TreeNode> treeList = findAllRoot(head,root);
        boolean flag = false;
        for(int i=0;i<treeList.size();i++){
            if(DFSMethod(head,treeList.get(i))){
                flag = true;
            }
        }
        return flag;
    }

    public boolean DFSMethod(ListNode head,TreeNode root){

        if(root==null&&head!=null) return false;

        if(head.val==root.val&&head.next==null){
            return true;
        }
        if(head.val==root.val&&head.next!=null){
             return DFSMethod(head.next,root.left)||DFSMethod(head.next, root.right);
        }
        return false;
    }

    public List<TreeNode> findAllRoot(ListNode head,TreeNode root){
        List<TreeNode> res = new ArrayList<>();
        Queue<TreeNode> temp = new ArrayDeque<>();
        temp.add(root);
        while(!temp.isEmpty()){
            TreeNode thisNode = temp.poll();
            if(thisNode.val==head.val){
                res.add(thisNode);
            }
            if(thisNode.left!=null) temp.add(thisNode.left);
            if(thisNode.right!=null) temp.add(thisNode.right);
        }
        return res;
    }


}
