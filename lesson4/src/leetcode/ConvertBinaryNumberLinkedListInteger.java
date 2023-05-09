package leetcode;

public class ConvertBinaryNumberLinkedListInteger {

    public static int getDecimalValue(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode nx;
        while (curr != null){
            nx = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nx;
        }
        int res = 0;
        int pow = 0;
        while (prev != null){
           res+=  prev.val * Math.pow(2, pow);
           pow++;
           prev = prev.next;
        }
        return res;
    }

    public static void main(String[] args) {
        getDecimalValue(new ListNode(1, new ListNode(0, new ListNode(1))));
    }
}
