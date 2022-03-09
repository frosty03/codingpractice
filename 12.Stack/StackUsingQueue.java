package com.example.stub.unassigned;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Problem Statement: https://leetcode.com/problems/implement-stack-using-queues/
 * Submitted Solution: https://leetcode.com/submissions/detail/654642721/
 *
 * 225. Implement Stack using Queues
 *
 * You must use only standard operations of a queue, which means that only push to back,
 * peek/pop from front, size and is empty operations are valid.
 *
 */
class MyStack {
    Queue<Integer> q1 = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        int size = q1.size();
        while(size --> 1)
            q1.add(q1.poll());

        return q1.poll();
    }

    public int top() {
        int size = q1.size();
        while(size --> 1)
            q1.add(q1.poll());

        Integer t = q1.poll();
        q1.add(t);
        return t;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(myStack.top());; // return 2
        System.out.println(myStack.pop());; // return 2
        System.out.println(myStack.top());; // return 2
        System.out.println(myStack.pop());; // return 2
        System.out.println(myStack.top());; // return 2
        System.out.println(myStack.pop());; // return 2
        System.out.println(myStack.top());; // return 2
        System.out.println(myStack.pop());; // return 2
        System.out.println(myStack.empty());; // return False
        System.out.println(myStack.top());; // return 2
        System.out.println(myStack.pop());; // return 2
        System.out.println(myStack.empty());; // return False

    }
}
