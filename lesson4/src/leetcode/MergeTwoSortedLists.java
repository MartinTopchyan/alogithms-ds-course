package leetcode;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resHead = new ListNode();
        ListNode res = resHead;
        while (l1!= null && l2 != null){
            if(l1.val < l2.val){
                resHead.next = l1;
                l1 = l1.next;
            }else {
                resHead.next = l2;
                l2 = l2.next;
            }
            resHead = resHead.next;
        }

        if (l1 != null){
            resHead.next = l1;
        }
        if(l2 != null){
            resHead.next = l2;
        }
        return res;
    }

    public static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        if(l1.val < l2.val){
            l1.next =  mergeTwoListsRecursive(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode node = mergeTwoListsRecursive(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
        System.out.println();
    }
}
