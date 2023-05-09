package leetcode;

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return null;
        }
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        int removed = count - n;
        ListNode res = new ListNode();
        ListNode curr = res;
        curr.next = head;
        while (removed > 0) {
            removed--;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return res.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;
        while (n > 0) {
            right = right.next;
            n--;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        removeNthFromEnd2(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        removeNthFromEnd2(new ListNode(1, new ListNode(2)), 2);
    }
}
