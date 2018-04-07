package com.camnter.basicexercises.linklist;

import com.camnter.basicexercises.core.Node;

/**
 * 打印两个有序链表的公共部分
 * <p/>
 * head1 < head2，head1 往前走
 * head1 > head2，head2 往前走
 * head1 = head2，一起走
 * <p/>
 * 小的走，同则一起走
 *
 * @author CaMnter
 */
public class PrintLinkListCommonPart<T extends Comparable<T>> {

    void printLinkListCommonPart(Node<T> head1, Node<T> head2) {
        while (head1 != null && head2 != null) {
            if (head1.value.compareTo(head2.value) < 0) {
                head1 = head1.next;
            } else if (head1.value.compareTo(head2.value) > 0) {
                head2 = head2.next;
            } else {
                // ==
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        // 1 2 3 4 5 6
        Node<Integer> head1 = new Node<Integer>(1);
        head1.next = new Node<Integer>(2);
        head1.next.next = new Node<Integer>(3);
        head1.next.next.next = new Node<Integer>(4);
        head1.next.next.next.next = new Node<Integer>(5);
        head1.next.next.next.next.next = new Node<Integer>(6);

        // 3 4 5 6 7 8
        Node<Integer> head2 = new Node<Integer>(3);
        head2.next = new Node<Integer>(4);
        head2.next.next = new Node<Integer>(5);
        head2.next.next.next = new Node<Integer>(6);
        head2.next.next.next.next = new Node<Integer>(7);
        head2.next.next.next.next.next = new Node<Integer>(8);

        PrintLinkListCommonPart<Integer> printLinkListCommonPart = new PrintLinkListCommonPart<Integer>();
        printLinkListCommonPart.printLinkListCommonPart(head1, head2);
    }

}
