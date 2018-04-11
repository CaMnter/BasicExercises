package com.camnter.basicexercises.linklist;

import com.camnter.basicexercises.core.Node;

/**
 * 有序的环形链表插入值
 * <p/>
 * pre = head
 * cur = head.next
 * 一直走下去，如果要 插入的值 小于等于 cur 或者 大于等于 pre
 * 就插入到 pre 与 cur 之间
 * <p/>
 * 走一圈下来，如果没有的话
 * 环形链表，最小都在头，最大在尾巴
 *
 * @author CaMnter
 */
public class OrderedCircularLinkListInsertNode<T extends Comparable<T>> {

    public Node<T> orderedCircularLinkListInsertNode(Node<T> head, T target) {
        Node<T> node = new Node<T>(target);
        if (head == null) {
            node.next = node;
            return node;
        }

        Node<T> pre = head;
        Node<T> cur = head.next;

        /**
         * cur != head 表示了 走一圈了
         */
        while (cur != head) {
            if (pre.value.compareTo(target) <= 0 && cur.value.compareTo(target) >= 0) {
                // 找到位置
                break;
            }
            pre = cur;
            cur = cur.next;
        }

        pre.next = node;
        node.next = cur;
        return head.value.compareTo(target) < 0 ? head : node;
    }

    public static void main(String[] args) {
        OrderedCircularLinkListInsertNode<Integer> orderedCircularLinkListInsertNode = new OrderedCircularLinkListInsertNode<Integer>();
        Node.printRingLinkList(orderedCircularLinkListInsertNode.orderedCircularLinkListInsertNode(Node.getRingLinkList(), 7));
        Node.printRingLinkList(orderedCircularLinkListInsertNode.orderedCircularLinkListInsertNode(Node.getRingLinkList(), 0));
        Node.printRingLinkList(orderedCircularLinkListInsertNode.orderedCircularLinkListInsertNode(Node.getRingLinkList(), 3));

    }

}
