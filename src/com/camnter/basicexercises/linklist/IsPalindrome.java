package com.camnter.basicexercises.linklist;

import com.camnter.basicexercises.core.Node;

import java.util.Stack;

/**
 * 链表是否是回文结构
 * <p/>
 * true  1 2 1
 * true  1 2 2 1
 * true  15 6 15
 * false 1 2 3
 * <p/>
 * 回文：正走 和 反走，值都一样
 * <p/>
 * 用栈解，因为出栈正好相反
 *
 * @author CaMnter
 */
public class IsPalindrome<T extends Comparable<T>> {

    public boolean isPalindrome(Node<T> head) {
        Node<T> cur = head;

        // 入栈
        Stack<Node<T>> stack = new Stack<Node<T>>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        /**
         * stack 控制 反走，出栈
         * head  控制 正走
         */
        while (!stack.isEmpty()) {
            // 正反同时走的时候，不相等
            if (head.value.compareTo(stack.pop().value) != 0) {
                return false;
            }
            // 正走
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        IsPalindrome<Integer> isPalindrome = new IsPalindrome<Integer>();
        System.out.println(isPalindrome.isPalindrome(Node.getPalindromeLinkList()));
        System.out.println(isPalindrome.isPalindrome(Node.getLinkList()));
    }

}
