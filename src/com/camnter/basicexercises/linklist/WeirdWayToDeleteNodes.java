package com.camnter.basicexercises.linklist;

import com.camnter.basicexercises.core.Node;

/**
 * 一种怪异的方式删除节点
 * <p/>
 * 不给头结点，要气时间复杂度 O(1)
 * <p/>
 * <p/>
 * 比如 1 2 3 4
 * 要删除 2 节点
 * 那么将 2 节点后一个节点的值，赋值到 2 上
 * 1 3 3 4
 * 2 节点指向 2 的 下下个节点
 * 1 3 | 3 | 4
 * 1 3 4
 * 就把 2 节点的下个节点删除
 * 然后 2 节点的值变为 3
 * <p/>
 * 这是一种从值上表达删除节点的方式
 * 从引用角度来说，并没用删除
 * <p/>
 * 而且这种方式无法处理尾节点
 *
 * @author CaMnter
 */
public class WeirdWayToDeleteNodes<T> {

    public void weirdWayToDeleteNodes(Node<T> target) {
        if (target == null) return;
        if (target.next == null) return;
        Node<T> next = target.next;
        target.value = next.value;
        target.next = next.next;
    }

    public static void main(String[] args) {

        // 1 2 3 4 5 6
        Node<Integer> head = Node.getLinkList();
        // 4
        Node<Integer> target = head.next.next.next;

        WeirdWayToDeleteNodes<Integer> weirdWayToDeleteNodes = new WeirdWayToDeleteNodes<Integer>();
        weirdWayToDeleteNodes.weirdWayToDeleteNodes(target);
        Node.printLinkList(head);

    }

}
