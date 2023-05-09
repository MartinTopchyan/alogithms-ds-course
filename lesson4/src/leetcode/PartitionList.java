package leetcode;

public class PartitionList {


    public static ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode();
        ListNode last = new ListNode();
        ListNode curr = head;
        ListNode res1 = first;
        ListNode res2 = last;
        while (curr != null){
            if(curr.val < x){
                first.next = curr;
                first = first.next;
            }else {
                last.next = curr;
                last = last.next;
            }
            curr = curr.next;
        }
        last.next = null;
        first.next = res2.next;
        return res1.next;
    }

    public static void main(String[] args) {
        System.out.println(partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3));
    }
}
