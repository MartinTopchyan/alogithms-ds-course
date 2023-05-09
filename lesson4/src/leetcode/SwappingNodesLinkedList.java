package leetcode;

public class SwappingNodesLinkedList {

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        ListNode curr = head;

        while (k > 1){
            left = left.next;
            curr = curr.next;
            k--;
        }

        while (curr.next != null){
            curr = curr.next;
            right = right.next;
        }

        int tmpVal = left.val;
        left.val = right.val;
        right.val = tmpVal;
        return head;
    }

    public static void main(String[] args) {
        swapNodes(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    }
}
