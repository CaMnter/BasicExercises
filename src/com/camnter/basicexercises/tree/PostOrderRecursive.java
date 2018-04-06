package com.camnter.basicexercises.tree;


import com.camnter.basicexercises.core.TreeNode;

import java.util.Stack;

/**
 * 后续遍历
 * <p/>
 * 左右根
 * <p/>
 * <p/>
 * -            1
 * -        2       3
 * -      4   5       6
 * -        7   8
 * <p/>
 * 4 7 8 5 2 6 3 1
 * <p/>
 *
 * @author CaMnter
 */
public class PostOrderRecursive<T> {

    void postOrderRecursive(TreeNode<T> root) {
        if (root == null) return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.value + " ");
    }


    public static void main(String args[]) {
        PostOrderRecursive<Integer> postOrder = new PostOrderRecursive<Integer>();
        postOrder.postOrderRecursive(TreeNode.getTree());
    }

}
