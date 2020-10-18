public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastNode = head;
        ListNode slowNode = new ListNode(0);
        slowNode.next = head;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        if (slowNode.next == head) {
            return slowNode.next.next;
        } else {
            slowNode.next = slowNode.next.next;
            return head;
        }
    }
}
