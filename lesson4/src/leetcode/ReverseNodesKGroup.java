package leetcode;

public class ReverseNodesKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        int groupLength = k;
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (groupLength > 0 && curr != null){
            curr = curr.next;
            groupLength--;
        }
        if(curr == null){
            return head;
        }
        ListNode tmp = curr.next;
        curr.next = null;
        ListNode prev = reverse(dummy.next);
        head.next = reverseKGroup(tmp, k);
        return prev;
    }

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

    public static void main(String[] args) {
        ListNode node = reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        System.out.println();
    }
}
