package com.camnter.basicexercises.tree;

import com.camnter.basicexercises.core.TreeNode;

/**
 * 最小公共父节点
 * <p/>
 * 如果结点 p, q 都在某个结点左子树或者右子树，即在同一边上，那么它们的 LCA 也一定在左子树或者右子树上。
 * 这样就可以分解成相同的小规模去解决问题，运用递归。如果 p, q 在某个结点的两边，那么这个结点即为 LCA
 * -            1
 * -        2       3
 * -      4   5       6
 * -        7   8
 * <p/>
 * 7 8 最小公共父节点是 5
 * 4 6 最小公共父节点是 1
 * 4 8 最小公共父节点是 2
 *
 * @author CaMnter
 */
public class LeastCommonAncestorRecursive<T> {

    TreeNode<T> lowestCommonAncestorRecursive(TreeNode<T> root, T p, T q) {
        // 在当前节点的左子树下找到，则继续左子树的左子树继续找，持续下去
        if (existNode(root.left, p) && existNode(root.left, q)) {
            return lowestCommonAncestorRecursive(root.left, p, q);
        }
        // 在当前节点的右子树下找到，则继续右子树的右子树继续找，持续下去
        if (existNode(root.right, p) && existNode(root.right, q)) {
            return lowestCommonAncestorRecursive(root.right, p, q);
        }
        return root;
    }

    private boolean existNode(TreeNode<T> root, T t) {
        if (root == null) return false;
        if (root.value == t) return true;
        return existNode(root.left, t) || existNode(root.right, t);
    }

    public static void main(String args[]) {
        LeastCommonAncestorRecursive<Integer> leastCommonAncestorRecursive = new LeastCommonAncestorRecursive<Integer>();
        TreeNode<Integer> root = TreeNode.getTree();
        System.out.println("7 8 最小公共父节点是 " + leastCommonAncestorRecursive.lowestCommonAncestorRecursive(root, 7, 8).value);
        System.out.println("4 6 最小公共父节点是 " + leastCommonAncestorRecursive.lowestCommonAncestorRecursive(root, 4, 6).value);
        System.out.println("4 8 最小公共父节点是 " + leastCommonAncestorRecursive.lowestCommonAncestorRecursive(root, 4, 8).value);
    }

}
