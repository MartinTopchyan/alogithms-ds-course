package edu;

public class Stack {
    int[] arr;

    int top;

    int size;

    public Stack(int size) {
        this.arr = new int[size];
        this.size = size;
        this.top = -1;
    }

    void push(int val) {
        if (isFull()) {
            // error
            System.out.println("error the stack is full");
        } else {
            arr[top++] = val;
        }
    }

    int pop() {
        if (isEmpty()) {
            // error
            System.out.println("error the stack is empty");
            System.exit(-1);
        }
        return arr[top--];
    }

    int peek(int val) {
        if (isEmpty()) {
            // error
            System.out.println("error the stack is empty");
            System.exit(-1);
        }
        return arr[top];

    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

}
