package com.camnter.basicexercises.sorting;

/**
 * 快速排序
 *
 * @author CaMnter
 */
public class QuickSort {
    public <T extends Comparable<T>> void quickSorting(T[] array, int left, int right) {
        int r, l;
        if (left > right) return;
        // 基准数
        T temp = array[left];
        l = left;
        r = right;
        while (l != r) {
            /**
             * 要先从右往左找
             * 如果比基准数大，就一直找下去，直到找到比基准数小的
             */
            while ((array[r].compareTo(temp) >= 0) && l < r) r--;
            /**
             * 要先从左往右找
             * 如果比基准数小，就一直找下去，直到找到比基准数大的
             */
            while ((array[l].compareTo(temp) <= 0) && l < r) l++;
            if (l < r) {
                /**
                 * 交换
                 */
                T t = array[l];
                array[l] = array[r];
                array[r] = t;
            }
        }
        /**
         * 基准数与中间位置的数字交换
         */
        array[left] = array[l];
        array[l] = temp;
        /**
         * 继续处理左边的,这里是一个递归的过程
         */
        quickSorting(array, left, l - 1);
        /**
         * 继续处理右边的,这里是一个递归的过程
         */
        quickSorting(array, l + 1, right);
    }

    public static void main(String args[]) {
        Integer[] object = {26, 19, 7, 37, 27, 57, 67, 99, 87, 17};
        QuickSort quickSorting = new QuickSort();
        quickSorting.quickSorting(object, 0, object.length - 1);
        System.out.println("\n快速排序\n");
        for (int i : object) {
            System.out.print(i + " ");
        }
    }
}
