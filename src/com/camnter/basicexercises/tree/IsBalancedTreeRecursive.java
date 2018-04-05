package com.camnter.basicexercises.tree;

import com.camnter.basicexercises.core.TreeNode;

/**
 * 判断平衡二叉树（递归）
 * <p/>
 * 空树也是平衡树。
 * 左子树和右子树的高度差绝对值不超过 1
 * 左子树和右子树也是平衡的
 *
 * @author CaMnter
 */
public class IsBalancedTreeRecursive<T> {

    public boolean isBalancedTreeRecursive(TreeNode<T> root) {
        if (root == null) return true;
        int diff = Math.abs(height(root.left) - height(root.right));
        return diff < 2 && isBalancedTreeRecursive(root.left) && isBalancedTreeRecursive(root.right);
    }

    private int height(TreeNode<T> root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        IsBalancedTreeRecursive<Integer> isBalancedTreeRecursive = new IsBalancedTreeRecursive<Integer>();
        System.out.println(isBalancedTreeRecursive.isBalancedTreeRecursive(TreeNode.getTree()));
        System.out.println(isBalancedTreeRecursive.isBalancedTreeRecursive(TreeNode.getUnBalancedTree()));
    }

}
