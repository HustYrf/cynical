package IntersectionofTwoLinkedLists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tailA = null;
        ListNode tailB = null;
        ListNode rootA = headA;
        ListNode rootB = headB;
        int numA = 0;
        int numB = 0;
        while (headA != null) {
            tailA = headA;
            numA++;
            headA = headA.next;
        }
        while (headB != null) {
            tailB = headB;
            numB++;
            headB = headB.next;
        }
        if (tailA != tailB) {
            return null;
        }
        int cap = Math.max(numA, numB) - Math.min(numA, numB);
        if (numA > numB) {
            while (cap != 0) {
                cap--;
                rootA = rootA.next;
            }
        }
        if (numB > numA) {
            while (cap != 0) {
                cap--;
                rootB = rootB.next;
            }
        }
        while (rootA != null && rootB != null) {
            if (rootA == rootB) return rootA;
            rootA = rootA.next;
            rootB = rootB.next;
        }
        return null;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
