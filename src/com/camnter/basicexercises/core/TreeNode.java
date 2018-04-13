package com.camnter.basicexercises.core;

/**
 * 树的节点
 * <p/>
 * 二叉树是一种树形结构，其特点是每个结点至多只有两颗子树，并且二叉树的子树有左右之分
 * 非空二叉树叶子结点数等于度为 2 的结点的个数加 1，即 N0 = N2 + 1
 * 非空二叉树上第K层上至多有 2^(k-1) 个结点
 * 高度为 H 的二叉树至多有 2^H - 1 个结点
 *
 * @author CaMnter
 */
public class TreeNode<T> {

    public TreeNode<T> parent;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public T value;

    public TreeNode(final T value) {
        this.value = value;
    }

    /**
     * -            1
     * -        2       3
     * -      4   5       6
     * -        7   8
     *
     * @return TreeNode<Integer>
     */
    public static TreeNode<Integer> getTree() {
        TreeNode<Integer> root = new TreeNode<Integer>(1);

        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);

        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);

        root.right.right = new TreeNode<Integer>(6);

        root.left.right.left = new TreeNode<Integer>(7);
        root.left.right.right = new TreeNode<Integer>(8);

        return root;
    }

    /**
     * -            1
     * -        2       3
     * -      4   5       6
     * -     7     8     9
     * -   10
     *
     * @return TreeNode<Integer>
     */
    public static TreeNode<Integer> getUnBalancedTree() {
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);
        root.left.left.left = new TreeNode<Integer>(7);
        root.left.right.right = new TreeNode<Integer>(8);
        root.right.right.left = new TreeNode<Integer>(9);
        root.left.left.left.left = new TreeNode<Integer>(10);
        return root;
    }

    /**
     * 二叉搜索树
     * <p/>
     * 左节点比根 小
     * 右节点比根 大
     * <p/>
     * -            7
     * -        4       8
     * -      3   5       10
     * -     2     6     9
     * -    1
     *
     * @return TreeNode<Integer>
     */
    public static TreeNode<Integer> getBST() {
        TreeNode<Integer> root = new TreeNode<Integer>(7);
        root.left = new TreeNode<Integer>(4);
        root.right = new TreeNode<Integer>(8);
        root.left.left = new TreeNode<Integer>(3);
        root.left.right = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(10);
        root.left.left.left = new TreeNode<Integer>(2);
        root.left.right.right = new TreeNode<Integer>(6);
        root.right.right.left = new TreeNode<Integer>(9);
        root.left.left.left.left = new TreeNode<Integer>(1);
        return root;
    }

    /**
     * 完全二叉树
     * <p/>
     * 完全二叉树：叶节点只能出现在最下层和次下层，并且最下面一层的结点都集中在该层最左边的若干位置的二叉树
     * <p/>
     * -            7
     * -        4       8
     * -      3   5   10
     *
     * @return TreeNode<Integer>
     */
    public static TreeNode<Integer> getCBT() {
        TreeNode<Integer> root = new TreeNode<Integer>(7);
        root.left = new TreeNode<Integer>(4);
        root.right = new TreeNode<Integer>(8);
        root.left.left = new TreeNode<Integer>(3);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(10);
        return root;
    }


}
