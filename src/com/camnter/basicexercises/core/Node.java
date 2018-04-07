package com.camnter.basicexercises.core;

/**
 * @author CaMnter
 */
public class Node<T> {

    public T value;
    public Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    /**
     * 1 2 3 4 5 6
     *
     * @return Node<Integer>
     */
    public static Node<Integer> getLinkList() {
        Node<Integer> node = new Node<Integer>(1);
        node.next = new Node<Integer>(2);
        node.next.next = new Node<Integer>(3);
        node.next.next.next = new Node<Integer>(4);
        node.next.next.next.next = new Node<Integer>(5);
        node.next.next.next.next.next = new Node<Integer>(6);
        return node;
    }

    public static <T> void printLinkList(Node<T> head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

}
