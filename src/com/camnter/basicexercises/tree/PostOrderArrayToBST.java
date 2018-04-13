package com.camnter.basicexercises.tree;

import com.camnter.basicexercises.core.TreeNode;

/**
 * BST 的后序遍历重构 BST
 * <p/>
 * 1 2 3 6 5 4 9 10 8 7
 * <p/>
 * -            7
 * -        4       8
 * -      3   5       10
 * -     2     6     9
 * -    1
 * <p/>
 * <p/>
 * <p/>
 * 原理参照：校验 BST 的后序遍历
 * https://github.com/CaMnter/BasicExercises/blob/master/src/com/camnter/basicexercises/tree/IsPostOrderArrayOfBST.java
 *
 * @author CaMnter
 */
public class PostOrderArrayToBST<T extends Comparable<T>> {

    public TreeNode<T> postOrderArrayToBST(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return postOrderArrayToBST(array, 0, array.length - 1);
    }

    public TreeNode<T> postOrderArrayToBST(T[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        // 创建根节点
        TreeNode<T> root = new TreeNode<T>(array[end]);

        /**
         * less 记录 左数组 最右边那个 value 的 index
         * more 记录 右数组 最左边那个 value 的 index
         *
         * 正常情况的规则上，左右数组相邻
         */
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (array[end].compareTo(array[i]) > 0) {
                less = i;
            } else {
                /**
                 * 非常有趣的是
                 *
                 * 在 else 进去一次后
                 * more 的值在 后续的 遍历中，将不会改变
                 * 所以，more 记录 右数组 最左边那个 value 的 index
                 */
                more = more == end ? i : more;
            }
        }

        /**
         * 有了 less 和 more
         * 就知道了左数组 和 右数组
         * 就知道了 左子树 和 右子树
         * 开始重建
         */
        root.left = postOrderArrayToBST(array, start, less);
        root.right = postOrderArrayToBST(array, more, end - 1);
        return root;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 6, 5, 4, 9, 10, 8, 7};
        PostOrderArrayToBST<Integer> postOrderArrayToBST = new PostOrderArrayToBST<Integer>();

        CountLayer<Integer> countLayer = new CountLayer<Integer>();
        countLayer.countLayer(postOrderArrayToBST.postOrderArrayToBST(array));
    }

}
