import java.util.Deque;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Offer06 {

    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode listNode = head;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        int[] res = new int[length];
        listNode = head;
        for (int index = length - 1; index >= 0; index--) {
            res[index] = listNode.val;
            listNode = listNode.next;
        }
        return res;
    }

//    public int[] reversePrint(ListNode head) {
//        Deque<Integer> listNodeDeque = new LinkedList<>();
//        ListNode listNode = head;
//        int length = 0;
//        while (listNode != null) {
//            listNodeDeque.push(listNode.val);
//            listNode = listNode.next;
//            length++;
//        }
//        int[] res = new int[length];
//        int index = 0;
//        while (!listNodeDeque.isEmpty()) {
//            res[index++] = listNodeDeque.pop();
//        }
//        return res;
//    }
}
