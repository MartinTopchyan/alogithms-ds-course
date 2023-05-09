package leetcode;

public class RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode res = new ListNode();
        ListNode curr = res;
        while (head != null){
            if(head.val != val){
                curr.next = new ListNode(head.val);
                curr = curr.next;
            }
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        removeElements(new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))), 6);
    }
}
