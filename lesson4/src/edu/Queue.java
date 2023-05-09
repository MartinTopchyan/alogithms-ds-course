package edu;

public class Queue {

    int[] arr;

    int end;

    int start;

    int size;

    public Queue(int capacity) {
        this.arr = new int[capacity];
        this.size = 0;
        this.start = 0;
        this.end = 0;
    }

    void add(int val) {
        if (isFull()) {
            // error
            System.out.println("error the stack is full");
        } else {
            arr[end++] = val;
            if(end == arr.length){
                end = 0;
            }
        }
        size++;
    }

    int pop() {
        if (isEmpty()) {
            // error
            System.out.println("error the stack is empty");
            System.exit(-1);
        }
        int head = arr[start];
        start++;
        if (start == arr.length) {
            start = 0;
        }
        size--;
        return head;
    }

    int peek() {
        if (isEmpty()) {
            // error
            System.out.println("error the stack is empty");
            System.exit(-1);
        }
        return arr[start];

    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == arr.length;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }
}

