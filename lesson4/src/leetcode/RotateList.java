package leetcode;

public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if(k == 0){
            return head;
        }
        if(head == null || head.next == null){
            return head;
        }
        int count = 0;
        ListNode current = head;
        while (current != null){
            current = current.next;
            count++;
        }
        k = k % count;
        if(k == 0){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode nx;
        while (curr != null){
            nx = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nx;
        }

        return reverse(prev, k);
    }

    static ListNode reverse(ListNode head, int k){
        ListNode curr = head;
        ListNode prevFirst = null;
        while (curr != null && k >0){
            ListNode nx;
            nx = curr.next;
            curr.next = prevFirst;
            prevFirst = curr;
            curr = nx;
            k--;
        }

        ListNode prevLast = null;
        while (curr != null){
            ListNode nx;
            nx = curr.next;
            curr.next = prevLast;
            prevLast = curr;
            curr = nx;
        }
        ListNode res = prevFirst;
        while (prevFirst.next != null){
            prevFirst = prevFirst.next;
        }
        prevFirst.next = prevLast;
        return res;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if(k == 0){
            return head;
        }
        if(head == null || head.next == null){
            return head;
        }
        int count = 0;
        ListNode current = head;
        while (current != null){
            current = current.next;
            count++;
        }
        k = k % count;
        if(k == 0){
            return head;
        }
        int iterCount = count - k -1;
        ListNode curr = head;
        ListNode first = curr;
        while (iterCount > 0){
            curr = curr.next;
            iterCount--;
        }

        ListNode currrent = curr.next;
        curr.next = null;
        ListNode res = currrent;
        while (currrent.next != null){
            currrent = currrent.next;
        }
        currrent.next = first;
        return res;
    }

    public static ListNode rotateRight3(ListNode head, int k) {
        if(k == 0){
            return head;
        }
        if(head == null || head.next == null){
            return head;
        }
        int count = 0;
        ListNode current = head;
        while (current != null){
            current = current.next;
            count++;
        }
        k = k % count;
        if(k == 0){
            return head;
        }
        current = head;
        int tmp = count - k;
        while (tmp > 1){
            current = current.next;
            tmp--;
        }

        ListNode left = head;
        ListNode tmpNode = current.next;
        current.next = null;
        ListNode res = tmpNode;
        while (tmpNode.next != null){
            tmpNode = tmpNode.next;
        }
        tmpNode.next = left;
        return res;

    }

    public static void main(String[] args) {
        System.out.println(rotateRight3(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 4));
//        System.out.println(rotateRight2(new ListNode(1, new ListNode(2)), 2));

    }
}
