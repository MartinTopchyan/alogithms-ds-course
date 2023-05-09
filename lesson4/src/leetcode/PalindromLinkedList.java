package leetcode;

public class PalindromLinkedList {

    public static boolean isPalindrome(ListNode head) {
        ListNode slow= head;
        ListNode fast = head;

        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode current = slow;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }


        while(prev != null){
            if(prev.val != head.val){
                return false;
            }
            prev = prev.next;
            head = head.next;
        }

        return true;

    }

    public static boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode current = slow;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        while(prev != null){
            if(prev.val != head.val){
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
        isPalindrome2(new ListNode(1, new ListNode(0, new ListNode(1))));

    }
}
