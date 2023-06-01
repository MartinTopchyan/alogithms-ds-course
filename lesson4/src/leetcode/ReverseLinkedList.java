package leetcode;

public class ReverseLinkedList {
    static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode nx;
        while (curr != null){
            nx = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nx;
        }
        return prev;
    }

    static ListNode reverseRecursive(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode resHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return resHead;
    }
    public static void main(String[] args) {
        ListNode node = reverseRecursive(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        System.out.println(node);
    }

}
