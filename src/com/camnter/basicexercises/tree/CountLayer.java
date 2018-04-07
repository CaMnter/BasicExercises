package com.camnter.basicexercises.tree;


import com.camnter.basicexercises.core.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的深度计算
 * -            1
 * -        2       3
 * -      4   5       6
 * -        7   8
 * <p/>
 * 深度 4
 *
 * @author CaMnter
 */
public class CountLayer<T> {

    public void countLayer(TreeNode<T> root) {
        if (root == null) return;
        Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        queue.add(root);
        int currentLayer = 1;
        int nextLayer = 0;
        int layerCount = 0;
        TreeNode<T> current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current.value + " ");
            currentLayer--;

            if (current.left != null) {
                queue.add(current.left);
                nextLayer++;
            }
            if (current.right != null) {
                queue.add(current.right);
                nextLayer++;
            }

            if (currentLayer == 0) {
                System.out.println("");
                currentLayer = nextLayer;
                nextLayer = 0;
                layerCount++;
            }
        }

        System.out.println("深度 = " + layerCount);
    }

    public static void main(String args[]) {
        CountLayer<Integer> countLayer = new CountLayer<Integer>();
        countLayer.countLayer(TreeNode.getTree());
    }

}
