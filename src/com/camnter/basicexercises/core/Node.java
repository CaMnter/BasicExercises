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

    /**
     * 环链表
     * <p/>
     * 1 2 3 4 5 6 1
     *
     * @return Node<Integer>
     */
    public static Node<Integer> getRingLinkList() {
        Node<Integer> node = new Node<Integer>(1);
        node.next = new Node<Integer>(2);
        node.next.next = new Node<Integer>(3);
        node.next.next.next = new Node<Integer>(4);
        node.next.next.next.next = new Node<Integer>(5);
        node.next.next.next.next.next = new Node<Integer>(6);
        node.next.next.next.next.next.next = node;
        return node;
    }

    /**
     * 带环链表
     * <p/>
     * 1 2 3 4 5 3
     *
     * @return Node<Integer>
     */
    public static Node<Integer> getWithRingLinkList() {
        Node<Integer> node = new Node<Integer>(1);
        node.next = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        node.next.next = node3;
        node.next.next.next = new Node<Integer>(4);
        node.next.next.next.next = new Node<Integer>(5);
        node.next.next.next.next.next = node3;
        node.next.next.next.next.next.next = node;
        return node;
    }

    /**
     * 回文链表
     * <p/>
     * 1 2 3 3 2 1
     *
     * @return Node<Integer>
     */
    public static Node<Integer> getPalindromeLinkList() {
        Node<Integer> node = new Node<Integer>(1);
        node.next = new Node<Integer>(2);
        node.next.next = new Node<Integer>(3);
        node.next.next.next = new Node<Integer>(3);
        node.next.next.next.next = new Node<Integer>(2);
        node.next.next.next.next.next = new Node<Integer>(1);
        return node;
    }

    /**
     * 7 3 2 3 5 5 5 1 2 8 6 7 6
     *
     * @return Node<Integer>
     */
    public static Node<Integer> getDuplicateElementsLinkList() {
        Node<Integer> node = new Node<Integer>(7);
        node.next = new Node<Integer>(3);
        node.next.next = new Node<Integer>(2);
        node.next.next.next = new Node<Integer>(3);
        node.next.next.next.next = new Node<Integer>(5);
        node.next.next.next.next.next = new Node<Integer>(5);
        node.next.next.next.next.next.next = new Node<Integer>(5);
        node.next.next.next.next.next.next.next = new Node<Integer>(1);
        node.next.next.next.next.next.next.next.next = new Node<Integer>(2);
        node.next.next.next.next.next.next.next.next.next = new Node<Integer>(8);
        node.next.next.next.next.next.next.next.next.next.next = new Node<Integer>(6);
        node.next.next.next.next.next.next.next.next.next.next.next = new Node<Integer>(7);
        node.next.next.next.next.next.next.next.next.next.next.next.next = new Node<Integer>(6);
        return node;
    }

    public static <T> void printLinkList(Node<T> head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

}
