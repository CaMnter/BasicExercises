package com.camnter.basicexercises.stack;

import java.util.Stack;

/**
 * 只用递归和栈操作逆序一个栈
 * <p/>
 * 递归一，将栈底元素取出并从栈内删除
 * 递归二，调用递归一，直到栈空，然后全部压栈
 *
 * @author CaMnter
 */
public class ReverseStack<T> {

    /**
     * 将栈底元素取出并从栈内删除
     * <p/>
     * 一直翻到最底部，拿到栈底元素
     * 然后层层递归回来的时候又一个一个把过程中的非栈底元素放进去
     *
     * @param stack stack
     * @return T
     */
    public T getAndRemoveLastElement(Stack<T> stack) {
        T result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            T last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverse(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // 拿到栈底元素
        T t = getAndRemoveLastElement(stack);
        // 递归不断拿栈底元素
        reverse(stack);
        // 层层递归的栈底元素放入
        stack.push(t);
    }

    public static void main(String[] args) {
        ReverseStack<Integer> reverseStack = new ReverseStack<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        reverseStack.reverse(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
