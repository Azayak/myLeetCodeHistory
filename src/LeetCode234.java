public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slowNode = head, fastNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        ListNode firstEndNode = slowNode;
        ListNode secondStartNode = reverseList(firstEndNode.next);

        ListNode node1 = head, node2 = secondStartNode;

        boolean flag = true;
        while (flag && node2 != null) {
            if (node1.val != node2.val) {
                flag = false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        firstEndNode.next = reverseList(secondStartNode);
        return flag;
    }

    private ListNode reverseList(ListNode head) {
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
}
