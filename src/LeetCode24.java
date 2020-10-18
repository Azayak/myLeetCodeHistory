public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode resHead = new ListNode(0);
        resHead.next = head;
        ListNode curNode = resHead;
        while (curNode.next != null && curNode.next.next != null) {
                ListNode tempNode1 = curNode.next.next;
                ListNode tempNode2 = curNode.next;
                curNode.next = tempNode1;
                tempNode2.next = tempNode1.next;
                tempNode1.next = tempNode2;
                curNode = tempNode2;
        }
        return resHead.next;
    }
}
