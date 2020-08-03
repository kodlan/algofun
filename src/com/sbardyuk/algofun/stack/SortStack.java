package com.sbardyuk.algofun.stack;

import java.util.Stack;

public class SortStack {

    private static void sortStack(Stack<Integer> stack) {
        Stack<Integer> newStack = new Stack<>();
        while (!stack.isEmpty()) {
            Integer value = stack.pop();

            if (!newStack.isEmpty() && value >= newStack.peek()) {
                newStack.push(value);
            } else {
                while (!newStack.isEmpty() && newStack.peek() > value) {
                    stack.push(newStack.pop());
                }
                newStack.push(value);
            }
        }
        while (!newStack.isEmpty())
            stack.push(newStack.pop());
    }


    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(97);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(60);
        stack.push(23);

        sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
