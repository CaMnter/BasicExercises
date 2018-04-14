package com.camnter.basicexercises.tree;

import com.camnter.basicexercises.core.TreeNode;

/**
 * 节点之间的最大距离
 * <p/>
 * -         1
 * -     2       3
 * -   4   5   6   7
 * 节点距离就是，节点之间的距离
 * 比如：
 * 4 和 2 的节点距离是 2 [4, 2]
 * 5 和 6 的节点距离是 5 [5, 2, 1, 3, 6]
 * 那么这个树的 节点之间的最大距离 5
 * <p/>
 * 最大距离的出现情况：一个 root 为根节点的树
 * root 左子树上的最大距离
 * root 右子树上的最大距离
 * root 左子树上离 root.left 最远的距离 + root 右子树上离 root.right 最远的距离 + 1（根节点）
 * <p/>
 * 解法
 * 记录以下四个值：
 * lMax           左子树上的最大距离
 * rMax           右子树上的最大距离
 * maxFromLeft    root 左子树上离 root.left 最远的距离
 * maxFromRight   root 右子树上离 root.right 最远的距离
 * 最后操作
 * Math.max(Math.max(lMax, rMax), maxFromLeft + maxFromRight + 1)
 *
 * @author CaMnter
 */
public class MaximumDistanceBetweenNodes<T> {

    public int maximumDistanceBetweenNodes(TreeNode<T> root) {
        int[] record = new int[1];
        return postOrder(root, record);
    }

    public int postOrder(TreeNode<T> root, int[] record) {
        if (root == null) {
            record[0] = 0;
            return 0;
        }

        // 递归下去寻找 左子树最大距离
        int lMax = postOrder(root.left, record);
        // 拿到当前 root 左子树上离 root.left 最远的距离
        int maxFromLeft = record[0];

        // 递归下去寻找 右子树最大距离
        int rMax = postOrder(root.right, record);
        // 拿到 root 右子树上离 root.right 最远的距离
        int maxFromRight = record[0];

        // 拿到绕过当前 root 节点下的 最大节点距离
        int curNodeMax = maxFromLeft + maxFromRight + 1;
        //  拿到距离 root.left 和 root.right 最长的距离，记录下来
        record[0] = Math.max(maxFromLeft, maxFromRight) + 1;
        /**
         * 最大距离的出现情况：一个 root 为根节点的树
         * root 左子树上的最大距离
         * root 右子树上的最大距离
         * root 左子树上离 root.left 最远的距离 + root 右子树上离 root.right 最远的距离 + 1（根节点）
         */
        return Math.max(Math.max(lMax, rMax), curNodeMax);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);

        MaximumDistanceBetweenNodes<Integer> maximumDistanceBetweenNodes = new MaximumDistanceBetweenNodes<Integer>();
        System.out.println(maximumDistanceBetweenNodes.maximumDistanceBetweenNodes(root));
    }

}
