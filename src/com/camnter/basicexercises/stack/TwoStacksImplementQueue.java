package com.camnter.basicexercises.stack;

import java.util.Stack;

/**
 * 两个栈实现队列
 *
 * @author CaMnter
 */
public class TwoStacksImplementQueue {

    private static class Queue<T> {

        private final Stack<T> inStack;
        private final Stack<T> outStack;

        public Queue() {
            this.inStack = new Stack<T>();
            this.outStack = new Stack<T>();
        }

        public void add(T t) {
            this.inStack.add(t);
        }

        public T poll() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.add(inStack.pop());
                }
            }
            return outStack.pop();
        }

        public boolean isEmpty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

    }

    public static void main(String args[]) {
        Queue<Integer> queue = new Queue<Integer>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }


}
