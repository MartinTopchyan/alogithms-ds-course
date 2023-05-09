package leetcode;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        while (second != null && second.next != null){
            first = first.next;
            second = second.next.next;
            if(first == second){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasCycle(new ListNode(1)));
    }
}
