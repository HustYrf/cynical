package PalindromeLinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        int count = 0;
        ListNode root = head;
        ListNode compareHead = head;
        while (head != null) {
            count++;
            head = head.next;
        }
        int mid = count / 2;
        ListNode pre = null;
        while (mid != 0) {
            mid--;
            pre = root;
            root = root.next;
        }
        pre.next = null;
        ListNode tail = null;
        if (count % 2 == 0) {   //链表个数偶数个
            tail = reverseLinkedList(root);
        } else {//链表个数基数个
            tail = reverseLinkedList(root.next);
        }
        while (compareHead != null && tail != null) {
            if (compareHead.val != tail.val) {
                return false;
            }
            compareHead = compareHead.next;
            tail = tail.next;
        }

        return true;
    }

    public ListNode reverseLinkedList(ListNode root) {  //反转链表
        ListNode pre = null;
        ListNode cur = root;
        while (cur != null) {
            ListNode tempNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNode;
        }
        return pre;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


