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
public class InOrderRecursive<T> {

    void inOrderRecursive(TreeNode<T> root) {
        if (root == null) return;
        inOrderRecursive(root.left);
        System.out.print(root.value + " ");
        inOrderRecursive(root.right);
    }

    public static void main(String args[]) {
        InOrderRecursive<Integer> inOrder = new InOrderRecursive<Integer>();
        inOrder.inOrderRecursive(TreeNode.getTree());
        System.out.println("");
    }

}
