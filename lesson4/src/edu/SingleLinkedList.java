package edu;

public class SingleLinkedList {

    Node head;

    public SingleLinkedList(Node head) {
        this.head = head;
    }

    void insertInLast(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
        }else {
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = new Node(val);
        }

    }

    void deleteFromLast(){
        Node current = head;
        while (current.next.next != null){
            current = current.next;
        }
        current.next = null;
    }

    void insertInIndex(int val, int index) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } if(index == 0){
            node.next = head;
            head = node;
        }else {
            int count = 1;
            Node current = head;
            while (count < index) {
                current = current.next;
                count++;
            }
            node.next = current.next.next;
            current.next = node;
        }
    }
}
