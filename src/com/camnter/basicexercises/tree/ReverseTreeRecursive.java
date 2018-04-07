package com.camnter.basicexercises.tree;

import com.camnter.basicexercises.core.TreeNode;

/**
 * 反转二叉树
 * <p/>
 * -            1
 * -        2       3
 * -      4   5       6
 * -        7   8
 * <p/>
 * -            1
 * -        3       2
 * -      6       5   4
 * -           8   7
 *
 * @author CaMnter
 */
public class ReverseTreeRecursive<T> {

    private TreeNode<T> reverseTree(TreeNode<T> root) {
        if (root != null) {
            reverse(root);
        }
        return root;
    }

    private void reverse(TreeNode<T> root) {
        if (root != null) {
            TreeNode<T> t = root.left;
            root.left = root.right;
            root.right = t;

            reverse(root.left);
            reverse(root.right);
        }
    }

    public static void main(String args[]) {
        ReverseTreeRecursive<Integer> reverseTreeRecursive = new ReverseTreeRecursive<Integer>();
        CountLayer<Integer> countLayer = new CountLayer<Integer>();
        countLayer.countLayer(reverseTreeRecursive.reverseTree(TreeNode.getTree()));
    }

}
