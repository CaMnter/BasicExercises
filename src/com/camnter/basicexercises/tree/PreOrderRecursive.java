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
public class PreOrderRecursive<T> {

    void preOrderRecursive(TreeNode<T> root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    public static void main(String args[]) {
        PreOrderRecursive<Integer> preOrder = new PreOrderRecursive<Integer>();
        preOrder.preOrderRecursive(TreeNode.getTree());
    }


}
