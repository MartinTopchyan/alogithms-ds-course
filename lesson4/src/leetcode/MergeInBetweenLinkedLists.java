package leetcode;

public class MergeInBetweenLinkedLists {

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;
        int skipFirst = a;
        while (skipFirst > 1){
            curr = curr.next;
            skipFirst--;
        }
        int itemsToRemoved = b-a +1;
        ListNode tmp = curr;
        while (itemsToRemoved > 0){
            tmp = tmp.next;
            itemsToRemoved--;
        }

        curr.next = list2;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = tmp.next;
        return list1;
    }

    public static void main(String[] args) {
        mergeInBetween(new ListNode(0, new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))), 3,4,new ListNode(100, new ListNode(101, new ListNode(102))));
    }
}
