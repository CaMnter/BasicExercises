package com.camnter.basicexercises.tree;

import com.camnter.basicexercises.core.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断 完全二叉树
 * <p/>
 * 四个要点
 * <p/>
 * 按层遍历二叉树，从每层的左边向右边依次遍历所有的节点
 * 如果当前节点有有右节点，但是没有左节点，返回 false
 * 如果当前节点并不是左右节点全有，那之后的节点必须是叶子节点，否则返回 false
 * 遍历过程中如果不返回 false，遍历结束后要返回 true
 *
 * @author CaMnter
 */
public class IsCompleteBinaryTree<T> {

    public boolean isCompleteBinaryTree(TreeNode<T> root) {
        if (root == null) return false;

        Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        queue.add(root);
        TreeNode<T> l;
        TreeNode<T> r;
        boolean leaf = false;
        while (!queue.isEmpty()) {
            root = queue.poll();
            l = root.left;
            r = root.right;

            /**
             * 如果当前节点并不是左右节点全有，那之后的节点必须是叶子节点，否则返回 false
             * 如果当前节点有有右节点，但是没有左节点，返回 false
             */
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }

            if (l != null) queue.add(l);

            if (r != null) {
                queue.add(r);
            } else {
                /**
                 * 经过上面判断，如果接下来 右节点没的话
                 * 并且如果是完全二叉树的话，不管是同一层还是下一层的节点
                 * 都是叶子节点了
                 */
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsCompleteBinaryTree<Integer> isCompleteBinaryTree = new IsCompleteBinaryTree<Integer>();
        System.out.println(isCompleteBinaryTree.isCompleteBinaryTree(TreeNode.getCBT()));
        System.out.println(isCompleteBinaryTree.isCompleteBinaryTree(TreeNode.getBST()));
    }

}
