package leetcode;

public class ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }
        if(left == right){
            return head;
        }
        ListNode current = head;
        ListNode dummy = new ListNode(0, head);
        ListNode leftPrev = dummy;
        int count = 0;
        while (count < left -1){
            leftPrev = leftPrev.next;
            current = current.next;
            count++;
        }
        count = 0;
        ListNode prev = current;
        while(count < (right-left +1)){
            ListNode nx = current.next;
            current.next = prev;
            prev = current;
            current = nx;
            count++;
        }
        leftPrev.next.next = current;
        leftPrev.next = prev;


        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4, new ListNode(5))))), 3, 4));
//        System.out.println(reverseBetween(new ListNode(1, new ListNode(2)), 1, 1));

    }
}
