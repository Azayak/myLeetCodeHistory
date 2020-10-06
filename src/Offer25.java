public class Offer25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resHead = new ListNode(0), curNode = resHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            }
            else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        curNode.next = l1 != null ? l1 : l2;
        return resHead.next;
    }

    //递归
    public ListNode _mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
