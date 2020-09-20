/**给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 
*逆序的方式存储的，并且它们的每个节点只能存储一位数字。
*如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
*您可以假设除了数字 0 之外，这两个数都不会以 0 开头。*/


import java.util.Scanner;

public class LeetCode2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
/**************************************************************/
//    解法一；整数溢出
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int x,y,sum;
//        ListNode res;
//        x = ListToInt(l1);
//        y = ListToInt(l2);
//        sum = x + y;
//        res = IntToList(sum);
//        return res;
//    }
//    private int ListToInt(ListNode ll){
//        int i=0;
//        int p=1;
//        while (ll != null){
//            i+=p*ll.val;
//            p*=10;
//            ll=ll.next;
//        }
//        return i;
//    }
//    private ListNode IntToList(int i){
//        ListNode LHead = new ListNode(i%10);
//        ListNode ll = LHead;
//        i/=10;
//        int j;
//        while(i != 0){
//            ll.next = new ListNode(i%10);
//            ll = ll.next;
//            i/=10;
//        }
//        return LHead;
//    }

/*****************************************************************/
//    解法二
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
           int x=0,y=0,flag=0,sum=0;
           ListNode resHead = new ListNode(0);
           ListNode res = resHead;

           while(l1 != null || l2 != null){
               x = (l1 == null)? 0:l1.val;
               y = (l2 == null)? 0:l2.val;
               sum = x + y + flag;
               flag = sum / 10;
               sum = sum % 10;

               res.next = new ListNode(sum);
               res = res.next;

               if(l1 != null)
                   l1 = l1.next;
               if(l2 != null)
                   l2 = l2.next;

           }

           if(flag==1) res.next = new ListNode(1);
           return resHead.next;
    }
/******************************************************************/

//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        char[] L1,L2;
//        System.out.println("输入链表一");
//        L1 = in.nextLine();
//
//
//        System.out.println("输入链表二");
//    }
}
