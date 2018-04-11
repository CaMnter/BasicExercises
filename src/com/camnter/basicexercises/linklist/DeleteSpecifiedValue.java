package com.camnter.basicexercises.linklist;

import com.camnter.basicexercises.core.Node;

import java.util.Stack;

/**
 * 链表删除特定值
 * <p/>
 * 使用栈去解，是特定值，不入栈
 * 出栈的时候，来一趟反转链表
 *
 * @author CaMnter
 */
public class DeleteSpecifiedValue<T extends Comparable<T>> {

    public Node<T> deleteSpecifiedValue(Node<T> head, T target) {
        if (head == null) return null;
        Stack<Node<T>> stack = new Stack<Node<T>>();
        while (head != null) {
            if (head.value.compareTo(target) != 0) {
                stack.push(head);
            }
            head = head.next;
        }

        /**
         * 来一趟反转链表
         */
        Node<T> pre = null;
        Node<T> cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            cur.next = pre;
            pre = cur;
        }

        return pre;
    }

    public static void main(String[] args) {
        DeleteSpecifiedValue<Integer> deleteSpecifiedValue = new DeleteSpecifiedValue<Integer>();
        Node.printLinkList(deleteSpecifiedValue.deleteSpecifiedValue(Node.getPalindromeLinkList(), 3));
    }

}
