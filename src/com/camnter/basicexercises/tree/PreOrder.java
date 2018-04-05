package com.camnter.basicexercises.tree;


import com.camnter.basicexercises.core.TreeNode;

import java.util.Stack;

/**
 * 前序遍历
 * <p/>
 * 根左右
 * <p/>
 * <p/>
 * -            1
 * -        2       3
 * -      4   5       6
 * -        7   8
 * <p/>
 * 1 2 4 5 7 8 3 6
 * <p/>
 *
 * @author CaMnter
 */
public class PreOrder<T> {

    void preOrderRecursive(TreeNode<T> root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    void preOrder(TreeNode<T> root) {
        if (root == null) return;
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        TreeNode<T> t;
        stack.push(root);
        while (!stack.isEmpty()) {
            // 根
            t = stack.pop();
            System.out.print(t.value + " ");

            // 后进先出，先放右，后放左边
            // 出栈就是 先左后右，完成 根左右
            if (t.right != null) stack.push(t.right);
            if (t.left != null) stack.push(t.left);
        }
    }

    public static void main(String args[]) {
        PreOrder<Integer> preOrder = new PreOrder<Integer>();
        preOrder.preOrderRecursive(TreeNode.getTree());
        System.out.println("");
        preOrder.preOrder(TreeNode.getTree());
    }


}
