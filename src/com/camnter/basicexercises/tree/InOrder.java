package com.camnter.basicexercises.tree;


import com.camnter.basicexercises.core.TreeNode;

import java.util.Stack;

/**
 * 中序遍历
 * <p/>
 * 左根右
 * <p/>
 * <p/>
 * -            1
 * -        2       3
 * -      4   5       6
 * -        7   8
 * <p/>
 * 4 2 7 5 8 1 3 6
 * <p/>
 *
 * @author CaMnter
 */
public class InOrder<T> {

    void inOrder(TreeNode<T> root) {
        if (root == null) return;
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        TreeNode<T> current = root;
        while (!stack.isEmpty() || current != null) {

            // 处理所有左结点，入栈
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 执行到这里，栈顶元素没有左孩子或者左子树都被访问过
            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current.value + " ");
                current = current.right;
            }

        }
    }

    public static void main(String args[]) {
        InOrder<Integer> inOrder = new InOrder<Integer>();
        inOrder.inOrder(TreeNode.getTree());
    }

}
