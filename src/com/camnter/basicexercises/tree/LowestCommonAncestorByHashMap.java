package com.camnter.basicexercises.tree;

import com.camnter.basicexercises.core.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最小公共父节点
 * <p/>
 * 使用 哈希表 解
 * <p/>
 * -            1
 * -        2       3
 * -      4   5       6
 * -        7   8
 * <p/>
 * 建立一张 哈希表 记录每个节点的父节点
 * <p/>
 * key  value
 * 1    null
 * 2     1
 * 3     1
 * 4     2
 * 5     2
 * 6     3
 * 7     5
 * 8     5
 * <p/>
 * 比如找 8 和 6 的 公共无节点
 * 根据这张表 先建立一个 8 到跟节点路径上的所有节点 A 集合
 * 8 5 2 1
 * 然后，在根据这张表，找到 6 以上的所有不接电
 * 先是 6，不在 A 集合
 * 再是 3，不在 A 集合
 * 再是 1，在 A 集合
 *
 * @author CaMnter
 */
public class LowestCommonAncestorByHashMap<T> {

    private final Map<TreeNode<T>, TreeNode<T>> map;

    public LowestCommonAncestorByHashMap(TreeNode<T> root) {
        map = new HashMap<TreeNode<T>, TreeNode<T>>();
        if (root != null) map.put(root, null);
        // 建立 哈希表
        setMap(root);
    }

    private void setMap(TreeNode<T> root) {
        if (root == null) return;
        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);
        setMap(root.left);
        setMap(root.right);
    }


    public TreeNode<T> lowestCommonAncestorByHashMap(TreeNode<T> node1, TreeNode<T> node2) {
        /**
         * 建立 node1 节点 到跟节点路径上的所有节点 路径集合
         */
        Set<TreeNode<T>> path = new HashSet<TreeNode<T>>();
        while (map.containsKey(node1)) {
            path.add(node1);
            node1 = map.get(node1);
        }
        /**
         * 拿 node2 路径上的每个节点，从下往上
         * 对比 是否在 node1 的 路径集合 上
         */
        while (!path.contains(node2)) {
            node2 = map.get(node2);
        }
        /**
         * node2 路径上的最后个节点一定是根节点
         */
        return node2;
    }

    public static void main(String args[]) {
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);
        root.left.right.left = new TreeNode<Integer>(7);
        root.left.right.right = new TreeNode<Integer>(8);
        LowestCommonAncestorByHashMap<Integer> lowestCommonAncestorByHashMap = new LowestCommonAncestorByHashMap<Integer>(root);
        System.out.println("7 8 最小公共父节点是 " + lowestCommonAncestorByHashMap.lowestCommonAncestorByHashMap(root.left.right.left, root.left.right.right).value);
        System.out.println("4 6 最小公共父节点是 " + lowestCommonAncestorByHashMap.lowestCommonAncestorByHashMap(root.left.left, root.right.right).value);
        System.out.println("4 8 最小公共父节点是 " + lowestCommonAncestorByHashMap.lowestCommonAncestorByHashMap(root.left.left, root.left.right.right).value);
    }

}
