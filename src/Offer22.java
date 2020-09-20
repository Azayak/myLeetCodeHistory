public class Offer22 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode l1,l2;
        l1 = head;
        l2 = head;
        for(int i = 1;i <= k;++i){
            l2 = l2.next;
            if(l2 == null) return l1;
        }
        while(l2 != null){
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }
}
