package leetcode;

public class InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(0);
        ListNode current = head;
        while (current != null) {
            ListNode tmp = res;
            while (tmp.next != null && current.val > tmp.next.val) {
                tmp = tmp.next;
            }
            ListNode tmp2 = tmp.next;
            tmp.next = new ListNode(current.val, tmp2);
            current = current.next;

        }
        return res.next;
    }

    public static void main(String[] args) {
        insertionSortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
    }
}
