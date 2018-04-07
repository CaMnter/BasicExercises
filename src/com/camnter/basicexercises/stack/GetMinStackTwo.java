package com.camnter.basicexercises.stack;

import java.util.Stack;

/**
 * getMin 栈
 * 重复压栈法
 * <p/>
 * 两个 stack，一个是原数据栈，一个是 min 栈
 * <p/>
 * - 1      1
 * - 2      1
 * - 1      1
 * - 5      3
 * - 4      3
 * - 3      3
 * <p/>
 * 只有小于等于 min 栈顶，继续把 min 栈顶元素再压进去一次
 * 如果 min 栈没数据，也跟着压
 * 原数据栈正常压
 * <p/>
 * 出栈的话，正常出
 * 原数据栈正常出
 * <p/>
 * 特点：进栈费用空间，出栈省时间
 * 时间复杂度 O(1)
 * 空间复杂度 O(n)
 *
 * @author CaMnter
 */
public class GetMinStackTwo {

    private static class SuperStack<T extends Comparable<T>> {

        private final Stack<T> rawStack;
        private final Stack<T> minStack;

        private SuperStack() {
            this.rawStack = new Stack<T>();
            this.minStack = new Stack<T>();
        }

        public void push(T t) {
            this.rawStack.push(t);
            if (this.minStack.isEmpty()) {
                this.minStack.push(t);
            } else if (this.getMin() != null && this.getMin().compareTo(t) >= 0) {
                this.minStack.push(t);
            } else if (this.getMin() != null && this.getMin().compareTo(t) < 0) {
                this.minStack.push(this.getMin());
            }
        }

        public T pop() {
            if (this.rawStack.isEmpty()) return null;
            this.minStack.pop();
            return this.rawStack.pop();
        }

        public boolean isEmpty() {
            return this.rawStack.isEmpty();
        }

        public T getMin() {
            // 不出栈，只拿数据
            if (this.minStack.isEmpty()) return null;
            return this.minStack.peek();
        }

    }

    public static void main(String[] args) {
        SuperStack<Integer> superStack = new SuperStack<Integer>();
        superStack.push(3);
        superStack.push(4);
        superStack.push(5);
        superStack.push(1);
        superStack.push(2);
        superStack.push(1);

        // 1
        System.out.println(superStack.getMin());
        superStack.pop();
        superStack.pop();
        // 1
        System.out.println(superStack.getMin());
        superStack.pop();
        // 3
        System.out.println(superStack.getMin());
    }

}
