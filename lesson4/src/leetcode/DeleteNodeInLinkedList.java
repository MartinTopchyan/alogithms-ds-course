package leetcode;

public class DeleteNodeInLinkedList {
    static ListNode head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));

    public static void deleteNode(ListNode node) {
        ListNode curr = head;
        while (curr != null){
            if(curr.val == node.val){
                node = curr.next;
                node.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }

        System.out.println(head);
    }

    public static void main(String[] args) {
        deleteNode(new ListNode(5));
    }
}
