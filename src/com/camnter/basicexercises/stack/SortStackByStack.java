package com.camnter.basicexercises.stack;

import java.util.Stack;

/**
 * 一个栈排序另一个栈
 * <p/>
 * 辅助栈 helper 栈
 * 原数据栈
 * <p/>
 * 原数据栈 pop 一个值 cur
 * 如果 helper 栈没有，则直接压入
 * 如果 cur 大于 helper 栈顶元素，则压入
 * 如果 cur 小于 helper 栈顶元素，则 helper 栈一直出栈压到原数据栈，直到 helper 出栈，直到 cur 小于或等于栈顶元素位置
 * 最后将 cur 压入 helper 栈
 * <p/>
 * 一直执行以上操作，直到 原数据栈为空，然后将 helper 栈元素全部压入 原数据栈
 *
 * @author CaMnter
 */
public class SortStackByStack<T extends Comparable<T>> {

    void sortStackByStack(Stack<T> rawStack) {
        Stack<T> helperStack = new Stack<T>();
        while (!rawStack.isEmpty()) {
            T cur = rawStack.pop();
            // 如果 cur 小于 helper 栈顶元素，则 helper 栈一直出栈压到原数据栈，直到 helper 出栈，直到 cur 小于或等于栈顶元素位置
            while (!helperStack.isEmpty() && helperStack.peek().compareTo(cur) > 0) {
                rawStack.push(helperStack.pop());
            }
            helperStack.push(cur);
        }

        while (!helperStack.isEmpty()) {
            rawStack.push(helperStack.pop());
        }
    }

    public static void main(String[] args) {
        SortStackByStack<Integer> sortStackByStack = new SortStackByStack<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(6);
        stack.push(1);
        stack.push(3);

        sortStackByStack.sortStackByStack(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}
