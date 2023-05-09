package leetcode;

import java.util.List;

public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (secondHalf != null) {
            ListNode tmp = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = tmp;
        }

        ListNode current = head;
        while (prev != null){
            ListNode tmp = current.next;
            current.next = prev;
            prev= prev.next;
            current.next.next = tmp;
            current = current.next.next;
        }
    }

    public static void main(String[] args) {
        reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));

    }
}
