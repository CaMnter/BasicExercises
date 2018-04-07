package com.camnter.basicexercises.linklist;

import com.camnter.basicexercises.core.Node;

/**
 * 反转链表
 *
 * 记录此次循环当前节点，作为 previous
 * 以备下次循环的时候指向 current.next = previous
 *
 * @author CaMnter
 */
public class ReverseLinkList<T> {

    private Node<T> reverseLinkList(Node<T> head) {

        Node<T> previous = null;
        Node<T> current = head;

        while (current != null) {
            // 拿到下个节点
            Node<T> next = current.next;
            // 改变下个节点的引用，previous 用于记录上个循环中的 current
            current.next = previous;
            // 记录这个循环中的 current，以备下个循环用
            previous = current;
            // 移动引导到下个节点
            current = next;
        }

        return previous;
    }

    public static void main(String args[]) {
        ReverseLinkList<Integer> reverseLinkList = new ReverseLinkList<Integer>();
        Node.printLinkList(reverseLinkList.reverseLinkList(Node.getLinkList()));
    }

}
