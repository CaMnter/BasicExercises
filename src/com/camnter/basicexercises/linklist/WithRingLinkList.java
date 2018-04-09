package com.camnter.basicexercises.linklist;

import com.camnter.basicexercises.core.Node;

/**
 * 链表找环
 * <p/>
 * 快慢指针法
 * <p/>
 * 首先创建两个指针 A 和 B（在 Java 里就是两个对象引用），同时指向这个链表的头节点。然后开始一个大循环，在循环体
 * 中，让指针 A 每次向下移动一个节点，让指针 B 每次向下移动两个节点，然后比较两个指针指向的节点是否相同。如果相
 * 同，则判断出链表有环，如果不同，则继续下一次循环
 * <p/>
 * 更生动的例子来形容：在一个环形跑道上，两个运动员在同一地点起跑，一个运动员速度快，一个运动员速度慢。当两人跑了
 * 一段时间，速度快的运动员必然会从速度慢的运动员身后再次追上并超过，原因很简单，因为跑道是环形的
 *
 * @author CaMnter
 */
public class WithRingLinkList<T> {

    public boolean withRingLinkList(Node<T> head) {
        Node<T> slow;
        Node<T> fast;

        slow = fast = head;
        /**
         * 这个判断比较奇妙
         *
         * 如果无环链表，最后都为 null
         * 有环链表，就会无止境跑下去
         * 两个指针一定会相遇
         */
        while (fast != null && fast.next != null) {
            // 走一步
            slow = slow.next;
            // 走两步
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WithRingLinkList<Integer> withRingLinkList = new WithRingLinkList<Integer>();
        System.out.println(withRingLinkList.withRingLinkList(Node.getLinkList()));
        System.out.println(withRingLinkList.withRingLinkList(Node.getWithRingLinkList()));
    }


}
