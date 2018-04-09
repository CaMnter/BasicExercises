package com.camnter.basicexercises.linklist;

import com.camnter.basicexercises.core.Node;

import java.util.Stack;

/**
 * 链表相加
 * <p/>
 * 用栈解，然后同时出栈，顺便记录进位值
 * 然后，都为 empty 的时候，考虑进位值
 *
 * @author CaMnter
 */
public class LinkListAddition {

    public Node<Integer> linkListAddition(Node<Integer> head1, Node<Integer> head2) {
        Stack<Node<Integer>> stack1 = new Stack<Node<Integer>>();
        Stack<Node<Integer>> stack2 = new Stack<Node<Integer>>();

        Node<Integer> cur1 = head1;
        Node<Integer> cur2 = head2;

        // 入栈
        while (cur1 != null || cur2 != null) {
            if (cur1 != null) {
                stack1.push(cur1);
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                stack2.push(cur2);
                cur2 = cur2.next;
            }
        }

        /**
         * 由于从个位开始算
         * 这里开始要 反转链表
         */

        Node<Integer> node = null;
        // 记录上一个节点
        Node<Integer> pre = null;
        int s1;
        int s2;
        int v;
        // 进位值
        int ca = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            s1 = stack1.isEmpty() ? 0 : stack1.pop().value;
            s2 = stack2.isEmpty() ? 0 : stack2.pop().value;
            v = s1 + s2 + ca;
            node = new Node<Integer>(v % 10);
            node.next = pre;
            pre = node;
            ca = v / 10;
        }

        // 再来一次 反转链表 的套路
        if (ca != 0) {
            pre = node;
            node = new Node<Integer>(ca);
            node.next = pre;
        }
        return node;
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node<Integer>(1);
        node.next = new Node<Integer>(2);
        node.next.next = new Node<Integer>(3);

        // 123 + 123 = 246
        LinkListAddition linkListAddition = new LinkListAddition();
        Node.printLinkList(linkListAddition.linkListAddition(node, node));
    }


}
