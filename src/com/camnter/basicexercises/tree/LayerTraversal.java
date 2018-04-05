package com.camnter.basicexercises.tree;

import com.camnter.basicexercises.core.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的 广度优先遍历 也叫 层次遍历
 * <p/>
 * <p/>
 * -            1
 * -        2       3
 * -      4   5       6
 * -        7   8
 * <p/>
 * 1 2 3 4 5 6 7 8
 * <p/>
 * @author CaMnter
 */
public class LayerTraversal<T> {

    void layerTraversal(TreeNode<T> root) {
        if (root == null) return;
        Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public static void main(String args[]) {
        LayerTraversal<Integer> layerTraversal = new LayerTraversal<Integer>();
        layerTraversal.layerTraversal(TreeNode.getTree());
    }

}
