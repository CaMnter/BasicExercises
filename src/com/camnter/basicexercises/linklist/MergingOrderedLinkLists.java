package com.camnter.basicexercises.linklist;

import com.camnter.basicexercises.core.Node;

/**
 * 合并两个有序链表
 * <p/>
 * 找一个头较小的 链表
 * cur1 记录头较小的链表
 * cur2 记录头较大的链表
 * pre  记录上次 比较时 较小的 节点
 * <p/>
 * 一起走
 * 比较后，较小的往前走
 * 因为，此前 cur1 记录头较小的链表
 * 所以，cur1 较小往前走，不操作 cur2，pre 顺带记录一下
 * <p/>
 * cur2 较小的话
 * 先保存 cur2.next，因为等下要操作 cur2
 * pre  记录上次 比较时 较小的 节点
 * 所以 pre.next = cur2
 * cur2.next = cur1
 * 完成 cur2 并入到 cur1 的链表
 * 最后拿到刚才保存的 cur2.next
 * 作为 cur2 的新引用，继续走
 * <p/>
 * 最后的最后，处理一下长短不一的问题，谁没走完，就把它并入到 pre 后，即 pre.next
 *
 * @author CaMnter
 */
public class MergingOrderedLinkLists<T extends Comparable<T>> {

    public Node<T> mergingOrderedLinkLists(Node<T> head1, Node<T> head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        // 选头较小的作为返回的 head
        Node<T> head = head1.value.compareTo(head2.value) <= 0 ? head1 : head2;
        // 头比较小 链表
        Node<T> cur1 = head == head1 ? head1 : head2;
        // 头比较大 链表
        Node<T> cur2 = head == head1 ? head2 : head1;
        // pre 表示上次 比较时 较小的 节点
        Node<T> pre = cur1;
        Node<T> temp = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.value.compareTo(cur2.value) <= 0) {
                // cur1 较小
                pre = cur1;
                cur1 = cur1.next;
            } else {
                // cur2 较小，
                temp = cur2.next;
                // 并入 cur1 所在的链表中
                pre.next = cur2;
                cur2.next = cur1;
                // 继续记录较小节点
                pre = cur2;
                // cur2 往下走
                cur2 = temp;
            }
        }
        // 处理 两个链表不同长度的情况
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(1);
        node1.next = new Node<Integer>(3);
        node1.next.next = new Node<Integer>(5);
        node1.next.next.next = new Node<Integer>(7);
        node1.next.next.next.next = new Node<Integer>(9);

        Node<Integer> node2 = new Node<Integer>(2);
        node2.next = new Node<Integer>(4);
        node2.next.next = new Node<Integer>(6);
        node2.next.next.next = new Node<Integer>(8);

        MergingOrderedLinkLists<Integer> mergingOrderedLinkLists = new MergingOrderedLinkLists<Integer>();
        Node.printLinkList(mergingOrderedLinkLists.mergingOrderedLinkLists(node1, node2));
    }

}
