package RemoveNthNodeFromEndOfList;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        ListNode pre = head;
        if (head == null) return p;
        while (n > 0) {
            q = q.next;
            n--;
        }
        while (q != null) {
            q = q.next;
            pre = p;
            p = p.next;
        }
        if(p == head){              //如果p没有改变的话，直接返回p.next
            return p.next;
        }
        pre.next = p.next;
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
