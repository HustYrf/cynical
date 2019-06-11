package LinkedListCycle;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slowNode = head;    //快指针
        ListNode fastNode = head;    //慢指针
        while(slowNode!=null&&fastNode!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if(fastNode == null){
                return false;
            }else{
                fastNode = fastNode.next;
            }
            if(slowNode == fastNode){
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
