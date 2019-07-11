package MergeTwoSortedLists;


/*
 *
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);  //head节点
        ListNode head = p;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        while (l1 != null) {
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null) {
            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }
        return head.next;
    }


}


/*
solution update
 */
//public class Solution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null || (l2 != null && l1.val > l2.val)) {
//            ListNode t = l1; l1 = l2; l2 = t;
//        }
//        if (l1 != null) l1.next = mergeTwoLists(l1.next, l2);
//        return l1;
//    }
//}
