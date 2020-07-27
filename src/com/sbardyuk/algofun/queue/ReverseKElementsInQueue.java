package com.sbardyuk.algofun.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElementsInQueue {

    private static Queue<Integer> reverseK(Queue<Integer> queue, int k) {
        Queue<Integer> newqueue = new LinkedList<>();
        if (queue.size() < k) throw  new IllegalStateException("k < size");

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            Integer val = queue.poll();
            stack.push(val);
        }

        while (!stack.isEmpty()) {
            Integer val =  stack.pop();
            newqueue.add(val);
        }

        while (!queue.isEmpty()) {
            newqueue.add(queue.poll());
        }

        return newqueue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 10; i ++) {
            queue.add(i);
        }

        System.out.println(queue);

        Queue<Integer> newq = reverseK(queue, 5);
        System.out.println(newq);
    }
}
