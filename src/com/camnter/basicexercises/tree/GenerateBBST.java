package com.camnter.basicexercises.tree;

import com.camnter.basicexercises.core.TreeNode;

/**
 * 有序数组生成 平衡搜索二叉树
 * <p/>
 * 平衡二叉树：B 树
 * 二叉搜索树：BST 树
 * 平衡搜索二叉树：BBST 树
 * <p/>
 * B 树：
 * 空树也是平衡树。
 * 左子树和右子树的高度差绝对值不超过 1
 * 左子树和右子树也是平衡的
 * <p/>
 * BST 树；
 * 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值
 * 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值
 * 任意节点的左、右子树也分别为二叉查找树
 * 没有键值相等的节点
 * <p/>
 * 思路：
 * 有序数组最中间的数生成 根节点
 * 这个数的左边生成左子树
 * 这个数的右边生成右子树
 *
 * @author CaMnter
 */
public class GenerateBBST<T> {

    public TreeNode<T> generateBBST(T[] array) {
        if (array == null || array.length == 0) return null;
        return generateBBST(array, 0, array.length - 1);
    }

    public TreeNode<T> generateBBST(T[] array, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode<T> root = new TreeNode<T>(array[mid]);
        root.left = generateBBST(array, start, mid - 1);
        root.right = generateBBST(array, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        GenerateBBST<Integer> generateBBST = new GenerateBBST<Integer>();
        TreeNode<Integer> root = generateBBST.generateBBST(array);

        CountLayer<Integer> countLayer = new CountLayer<Integer>();
        countLayer.countLayer(root);
    }
}
