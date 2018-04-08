package com.camnter.basicexercises.linklist;

import com.camnter.basicexercises.core.Node;

/**
 * 环形链表的约瑟夫问题
 * <p/>
 * 约瑟夫环（约瑟夫问题）是一个数学的应用问题：
 * 已知 n 个人（以编号 1，2，3...n 分别表示）围坐在一张圆桌周围
 * 从编号为 k 的人开始报数，数到 m 的那个人出列
 * 他的下一个人又从1开始报数，数到 m 的那个人又出列
 * 依此规律重复下去，直到圆桌只剩一个人
 * <p/>
 * 如果链表为 null 或者长度为 1，再或者 m 小于 1，直接返回
 * 在环形链表中不断旋转
 * 当报数达到 m 时，删除当前报数的节点
 * 删除节点后重新连接为环形，继续报数，继续删除
 * 直到环形链表中只剩下一个节点
 * <p/>
 * 1 2 3 4 5 6，m = 2
 * 1 3 4 5 6
 * 1 3 5 6
 * 1 3 5
 * 1 5
 * 5
 *
 * @author CaMnter
 */
public class Josephus<T> {

    public Node<T> josephus(Node<T> head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }

        /**
         * 找到 尾节点
         * 只是为了找到一个 head 的前节点
         */
        Node<T> last = head;
        while (last.next != head) {
            last = last.next;
        }

        /**
         * 上面拿到了 last，意味着是 head 的上一节点
         * 下面的循环就一直能保证 last 是 head 的前一个阶段
         */
        int count = 0;
        while (head != last) {
            if (++count == m) {
                // 前节点的 next 指向当前节点的 next
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Josephus<Integer> josephus = new Josephus<Integer>();
        System.out.println(josephus.josephus(Node.getRingLinkList(), 2).value);
    }

}
