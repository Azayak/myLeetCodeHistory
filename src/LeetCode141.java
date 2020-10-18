public class LeetCode141 {

//    public boolean hasCycle(ListNode head) {
//        if (head == null) return false;
//        int flag = Integer.MAX_VALUE;
//        while (head.next != null) {
//            if (head.val == flag) {
//                return true;
//            }else {
//                head.val = flag;
//                head = head.next;
//            }
//        }
//        return false;
//    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
