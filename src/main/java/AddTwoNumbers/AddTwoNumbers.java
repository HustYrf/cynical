package AddTwoNumbers;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;
        int value;
        ListNode head = new ListNode(0);
        ListNode flagNode = head;
        while (l1 != null && l2 != null) {
            value = flag ? l1.val + l2.val + 1 : l1.val + l2.val;
            ListNode p = new ListNode(value % 10);
            head.next = p;
            head = p;
            if (value >= 10) {
                flag = true;
            } else {
                flag = false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode conNode = null;
        if (l1 != null) {
            conNode = l1;
        } else if (l2 != null) {
            conNode = l2;
        }
        while (conNode != null) {
            value = conNode.val;
            if (flag) {
                value++;
            }
            ListNode p = new ListNode(value % 10);
            head.next = p;
            head = p;
            if (value >= 10) {
                flag = true;
            } else {
                flag = false;
            }
            conNode = conNode.next;
        }
        if(flag){
            ListNode p = new ListNode(1);
            head.next = p;
        }
        return flagNode.next;
//        return resverseLinkList(flagNode.next);
    }

//    public ListNode resverseLinkList(ListNode root) {
//        if (root == null || root.next == null) return root;
//        ListNode p = null;
//        ListNode q = root;
//        while (q != null) {
//            ListNode nextNode = q.next;
//            q.next = p;
//            p = q;
//            q = nextNode;
//        }
//        return p;
//    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
