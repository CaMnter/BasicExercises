package com.camnter.basicexercises.linklist;

import com.camnter.basicexercises.core.Node;

/**
 * 删除链表中倒数第 K 个节点
 * <p/>
 * 一趟遍历头到尾，每次都 K--
 * 如果
 * K < 0。在一趟遍历，++K 判断 是否为 0，不为 0，继续 next 走，此时 cur 要删除的节点的 前一个节点
 * K > 0，没有这个节点的，脏数据，不处理
 * K = 0，就是头结点，remove head
 *
 * @author CaMnter
 */
public class RemoveLastKthNode<T> {

    public Node<T> removeLastKthNode(Node<T> head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }

        Node<T> cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }

        if (lastKth == 0) {
            // 删除头节点
            head = head.next;
        }

        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            /**
             * 因为之前是 ++lastKth 判断
             * 此时 cur 要删除的节点的 前一个节点
             * 删除 cur.next
             */
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveLastKthNode<Integer> removeLastKthNode = new RemoveLastKthNode<Integer>();
        /**
         * 1 2 3 4 5 6
         * 删除倒第 4 个
         * 1 2 4 5 6
         */
        Node.printLinkList(removeLastKthNode.removeLastKthNode(Node.getLinkList(), 4));
    }

}
