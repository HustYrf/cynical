package LinkedListCycle2;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Note: Do not modify the linked list.
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (slowNode != null && fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode == null) {
                return null;
            } else {
                fastNode = fastNode.next;
            }
            if (fastNode == slowNode) {
                break;
            }
        }
        fastNode = head;//接下来，我们将fast指针重新指向头部，
        // 并和slow指针一起向前走，每轮走一步，则有,当fast指针走了a步时，slow指针正好走了a + b步
        // ，此时两指针同时指向链表环入口(a为头到环开始的长度，b为整个环的长度）
        while (fastNode != null && slowNode != null) {
            if (fastNode == slowNode) {
                return fastNode;
            } else {
                fastNode = fastNode.next;
                slowNode = slowNode.next;
            }
        }
        return null;
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
