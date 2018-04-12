package com.camnter.basicexercises.tree;

import com.camnter.basicexercises.core.TreeNode;

/**
 * 二叉树中的最大搜索二叉子树
 * <p/>
 * -            6
 * -
 * -       1         12
 * -
 * -    0    3    10     13
 * -
 * -            4   14 20  16
 * -
 * -           2 5 11 15
 * <p/>
 * -      10
 * -
 * -    4   14
 * -
 * -   2 5 11 15
 * <p/>
 * 就是一步一步走下去
 * 方法栈一个节点一个节点走下去，以每个节点为一棵树的 root 节点
 * 开始尝试这个 root 是否是 BST
 * 不是的话，继续走下去以 左右 为新的 root ，继续走
 * 这就是这个递归的思路
 * <p/>
 * 由于要知道左右节点与根节点的关系。所以，要先知道左右节点，再根节点
 * 这个过程就和 后序遍历 一样
 * <p/>
 * 过程中需要记录
 * 左子树下：最大搜索二叉子树（lBST），节点数（lSize），最小最大值（lMin, lMax）
 * 右子树下：最大搜索二叉子树（rBST），节点数（rSize），最小最大值（rMin, rMax）
 * <p/>
 *
 * @author CaMnter
 */
public class BiggestSubBST {

    public TreeNode<Integer> biggestSubBST(TreeNode<Integer> root) {
        int record[] = new int[3];
        return postOrder(root, record);
    }

    /**
     * @param root   root
     * @param record [0] = Size，[1] = Max，[2] = Min
     */
    public TreeNode<Integer> postOrder(TreeNode<Integer> root, int[] record) {
        if (root == null) {
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
            return null;
        }

        // 当前 root 的 value，left，right
        int value = root.value;
        TreeNode<Integer> left = root.left;
        TreeNode<Integer> right = root.right;

        // 左子树往下走，不断递归下去找，找到最大搜索二叉子树的根节点
        TreeNode<Integer> lBST = postOrder(left, record);
        // 获取左子树下，节点数（lSize），最小最大值（lMin, lMax）
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];

        // 右子树往下走，不断递归下去找，找到最大搜索二叉子树的根节点
        TreeNode<Integer> rBST = postOrder(right, record);
        // 获取右子树下，节点数（rSize），最小最大值（rMin, rMax）
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];

        // 记录最小值和最大值，一共递归方法栈返回
        record[1] = Math.min(lMin, value);
        record[2] = Math.max(rMax, value);

        // 开始判断当前 root 节点是否是一颗 BST
        if (left == lBST && right == rBST && lMax < value && rMin > value) {
            record[0] = lSize + rSize + 1;
            return root;
        }

        record[0] = Math.max(lSize, rSize);
        /**
         * 当前 root 节点，不是一颗 BST
         * 那么，放回之前方法栈找到的
         * 左子树下 最大搜索二叉子树的根节点
         * 右子树下 最大搜索二叉子树的根节点
         *
         * 哪边节点多，哪棵就更大
         */
        return lSize > rSize ? lBST : rBST;
    }

    public static void main(String[] args) {

        /**
         * -            6
         * -
         * -       1         12
         * -
         * -    0    3    10     13
         * -
         * -            4   14 20  16
         * -
         * -           2 5 11 15
         */
        TreeNode<Integer> root = new TreeNode<Integer>(6);
        root.left = new TreeNode<Integer>(1);
        root.right = new TreeNode<Integer>(12);
        root.left.left = new TreeNode<Integer>(0);
        root.left.right = new TreeNode<Integer>(3);
        root.right.left = new TreeNode<Integer>(10);
        root.right.right = new TreeNode<Integer>(13);
        root.right.left.left = new TreeNode<Integer>(4);
        root.right.left.right = new TreeNode<Integer>(14);
        root.right.right.left = new TreeNode<Integer>(20);
        root.right.right.right = new TreeNode<Integer>(16);
        root.right.left.left.left = new TreeNode<Integer>(2);
        root.right.left.left.right = new TreeNode<Integer>(5);
        root.right.left.right.left = new TreeNode<Integer>(11);
        root.right.left.right.right = new TreeNode<Integer>(15);

        CountLayer<Integer> countLayer = new CountLayer<Integer>();
        countLayer.countLayer(root);

        BiggestSubBST biggestSubBST = new BiggestSubBST();
        TreeNode<Integer> biggestSubBSTNode = biggestSubBST.biggestSubBST(root);

        countLayer.countLayer(biggestSubBSTNode);
    }

}
