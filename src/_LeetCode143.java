public class _LeetCode143 {

//    public void reorderList(ListNode head) {
//        if (head == null || head.next == null || head.next.next == null) {
//            return;
//        }
//        ListNode node1 = head.next, node2 = getLastNode(head);
//        head.next = node2.next;
//        node2.next = null;
//        reorderList(node1);
//        head.next.next = node1;
//    }
//
//    public ListNode getLastNode(ListNode listNode) {
//        ListNode lastNode = listNode;
//        while (lastNode.next.next != null) {
//            lastNode = lastNode.next;
//        }
//        return lastNode;
//    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode midNode = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = midNode.next;
        midNode.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
