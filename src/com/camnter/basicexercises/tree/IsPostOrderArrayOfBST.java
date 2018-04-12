package com.camnter.basicexercises.tree;

/**
 * 校验 BST 的后序遍历
 * <p/>
 * 比如，校验 1 2 3 6 5 4 9 10 8 7 是否是一颗 BST 的后序遍历结果
 * -            7
 * -        4       8
 * -      3   5       10
 * -     2     6     9
 * -    1
 * <p/>
 * 后序遍历的特点：根节点在最后
 * BST 后序遍历的特点：比根节点小的数组在前，比根节点小的数组在后
 * BST 的后序遍历一定满足这些要求
 * <p/>
 * 比如，1 2 3 6 5 4 9 10 8 7
 * [1 2 3 6 5 4] [9 10 8] 7
 * 然后，
 * 1 2 3 6 5 4 可以划分为 [1 2 3] [6 5] 4
 * 9 10 8 可以划分为 [9] [10] 8
 * 满足要求
 * <p/>
 * 思路，就是不断划分左右数组
 *
 * @author CaMnter
 */
public class IsPostOrderArrayOfBST<T extends Comparable<T>> {

    public boolean isPostOrderArrayOfBST(T[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        return isPostOrderArrayOfBST(array, 0, array.length - 1);
    }

    public boolean isPostOrderArrayOfBST(T[] array, int start, int end) {
        if (start == end) {
            return true;
        }
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
         * 左数组 或者 右数组 不存在
         * 意味着 有半边不存在
         * 那么 倒数子二个
         * 就是下一个 大的 root 根节点
         * 比如
         * -            7
         * -        4
         * -      3   5
         * -     2     6
         * -    1
         *
         * 1 2 3 6 5 4 7
         *
         * 只有左边
         * 下个大的 root 节点 就是 4
         * 再次划分 1 2 3 6 5 4
         * 划分之后 [1 2 3] [6 5] 4
         *
         * 然后继续递归
         *
         * 这是一种特殊情况
         */
        if (less == -1 || more == end) {
            return isPostOrderArrayOfBST(array, start, end - 1);
        }
        // 左右数组 不相邻，不是 BST 的后序遍历结构规则
        if (less != more - 1) {
            return false;
        }

        // 左右数组继续递归
        return isPostOrderArrayOfBST(array, start, less) && isPostOrderArrayOfBST(array, more, end - 1);
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 6, 5, 4, 9, 10, 8, 7};
        IsPostOrderArrayOfBST<Integer> integerIsPostOrderArrayOfBST = new IsPostOrderArrayOfBST<Integer>();
        System.out.println(integerIsPostOrderArrayOfBST.isPostOrderArrayOfBST(array));
    }

}
