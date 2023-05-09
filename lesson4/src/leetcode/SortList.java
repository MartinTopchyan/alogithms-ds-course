package leetcode;

import java.util.List;

public class SortList {
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode left = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode resHead = res;
        while (l1!= null && l2 != null){
            if(l1.val < l2.val){
                res.next = l1;
                l1 = l1.next;
            }else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }

        if (l1 != null){
            res.next = l1;
        }
        if(l2 != null){
            res.next = l2;
        }
        return resHead.next;
    }

    public static void main(String[] args) {
        ListNode node = sortList(new ListNode(4, new ListNode(2, new ListNode(3, new ListNode(1)))));
        System.out.println(node);
    }
}
