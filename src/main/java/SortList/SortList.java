package SortList;

import java.util.List;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList {
    /**
     * use The idea of merging and sorting
     * <p>
     * this sub question is MergeTwoSortedLists
     */
    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode p = head;
        ListNode q = head;

        while (q != null && q.next != null) {
            pre = p;
            p = p.next;  //走一步
            q = q.next.next; //走两步
        }

        pre.next = null;
        return mergeSort2List(sortList(head), sortList(p));   //important need to know

    }


    //this method is merge 2 List to Ordered state
    private ListNode mergeSort2List(ListNode l1, ListNode l2) {
        if (l1 == null || (l2 != null && l2.val < l1.val)) {  //swap
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        if (l1 != null) {                               // need to know this judge conditions
            l1.next = mergeSort2List(l1.next, l2);
        }
        return l1;
    }

    /**
     * stupid answer
     */
//    public ListNode sortList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode p = head; //p在前
//        ListNode q = p.next; //q在后
//        while (q != null) {
//            if (p.val <= q.val) {
//                p = q;
//                q = q.next;
//            } else {
//                insert2List(head, q);
//                q = q.next;
//                p.next = q;
//            }
//        }
//
//        return head;
//    }
//
//    private void insert2List(ListNode head, ListNode target) {
//        ListNode pre = null;
//        ListNode p = head;
//        ListNode target1 = target;
//        while (p != target) {
//            if (target1.val <= p.val) {
//                if (p == head) {
//                    target1.next = head;
//                    return;
//                } else {
//                    pre.next = target1;
//                    target1.next = p;
//                    return;
//                }
//            } else {
//                pre = p;
//                p = p.next;
//            }
//        }
//        return;
//    }
//
//    private class ListNode {
//        int val;
//        ListNode next;
//
//        public ListNode(int val) {
//            this.val = val;
//        }
//    }
}
