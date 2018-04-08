package com.camnter.basicexercises.linklist;

import com.camnter.basicexercises.core.Node;

/**
 * 反转部分链表
 * <p/>
 * 长度为 N
 * 将第 from 个节点和第 to 个节点这部分反转
 * <p/>
 * 注意情况过滤 1<=from<=to<N
 * <p/>
 * 记录 from 前面的那个节点，就是第 from - 1 个节点，记作 fromPre 节点
 * 记录 to   后面的那个节点，就是第 to   + 1 个节点，记作 toNext  节点
 * 因为反转的时候也需要这两个节点连接
 * <p/>
 * toNext 的连接
 * 然后将 from - to 的部分反转，判断 是否 到了 toNext
 * fromPre 的连接
 * <p/>
 * 1 2 3 4 5 6，from = 2，to = 4
 * 1 4 3 2 5 6
 *
 * @author CaMnter
 */
public class ReversePartOfLinkList<T> {

    private Node<T> reverseLinkList(Node<T> head, int from, int to) {
        int length = 0;
        Node<T> node1 = head;
        Node<T> fromPre = null;
        Node<T> toNext = null;

        /**
         * 一趟循环到底
         * 拿到 length, fromPre, toNext
         */
        while (node1 != null) {
            length++;
            fromPre = length == from - 1 ? node1 : fromPre;
            toNext = length == to + 1 ? node1 : toNext;
            node1 = node1.next;
        }

        // 特殊情况处理
        if (from > to || from < 1 || to > length) {
            return head;
        }

        // 拿到真正的 from
        node1 = fromPre == null ? head : fromPre.next;

        // 对接上 toNext
        Node<T> node2 = node1.next;
        node1.next = toNext;

        // 开始反转
        Node<T> next;
        while (node2 != toNext) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        // 对接上 fromPre
        if (fromPre != null) {
            fromPre.next = node1;
            return head;
        }


        return node1;
    }

    public static void main(String args[]) {
        ReversePartOfLinkList<Integer> reverseLinkList = new ReversePartOfLinkList<Integer>();
        Node.printLinkList(reverseLinkList.reverseLinkList(Node.getLinkList(), 2, 4));
    }

}
