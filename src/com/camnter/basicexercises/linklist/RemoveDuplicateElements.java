package com.camnter.basicexercises.linklist;

import com.camnter.basicexercises.core.Node;

import java.util.HashSet;

/**
 * 删除无序表中的重复元素
 * <p/>
 * 用一个 哈希表 HashSet 去实现
 * cur 记录当前节点
 * pre 记录上一个未被删除的节点
 * <p/>
 * 当前节点的值，在 HashSet 内找，有的话，就删除节点，此时用到 pre 节点
 * 无的话，两个指针正常走下去
 *
 * @author CaMnter
 */
public class RemoveDuplicateElements {

    public Node<Integer> removeDuplicateElements(Node<Integer> head) {
        if (head == null || head.next == null) return head;

        Node<Integer> pre = head;
        Node<Integer> cur = head.next;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(head.value);
        while (cur != null) {
            if (hashSet.contains(cur.value)) {
                // 删除当前节点
                pre.next = cur.next;
            } else {
                hashSet.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicateElements removeDuplicateElements = new RemoveDuplicateElements();
        // 7 3 2 3 5 5 5 1 2 8 6 7 6 -> 7 3 2 5 1 8 6
        Node.printLinkList(removeDuplicateElements.removeDuplicateElements(Node.getDuplicateElementsLinkList()));
    }

}
