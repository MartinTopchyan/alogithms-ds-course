package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueues {
}

class MyStack {

    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();


    public MyStack() {

    }

    public void push(int x) {
        Queue<Integer> q3 = new ArrayDeque<>();
        q3.add(x);
        while (!q1.isEmpty()){
            q3.add(q1.poll());
        }
//        Queue<Integer> q = q1;
        q1 = q3;
//        q2 = q;
    }

    public int pop() {
        if(!q1.isEmpty()){
            return q1.poll();
        }
        return Integer.MIN_VALUE;
    }

    public int top() {
        if(q1.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.top());
    }
}
