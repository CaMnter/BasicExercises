package com.camnter.basicexercises.sorting;

/**
 * 希尔排序
 *
 * ***************************
 * ***
 * ***
 * 希尔排序的诞生是由于插入排序在处理大规模数组的时候会遇到需要移动太多元素的问题。希尔排序的思想是将一个大的数组“分而治之”，划分为若干
 * 个小的数组，以 gap 来划分，比如数组 [1, 2, 3, 4, 5, 6, 7, 8] ，如果以 gap = 2 来划分，可以分为 [1, 3, 5, 7] 和 [2, 4, 6, 8]
 * 两个数组（对应的，如 gap = 3 ，则划分的数组为： [1, 4, 7] 、 [2, 5, 8] 、 [3, 6] ）然后分别对划分出来的数组进行插入排序，待各个
 * 子数组排序完毕之后再减小 gap 值重复进行之前的步骤，直至 gap = 1 ，即对整个数组进行插入排序，此时的数组已经基本上快排好序了，所以需
 * 要移动的元素会很小很小，解决了插入排序在处理大规模数组时较多移动次数的问题。
 * ---
 * [26, 19, 7, 37, 27, 57, 67, 99, 87, 17]
 * ---
 * gap = 10 / 2 = 5
 * ---
 * 26 19 7 37 27
 * 57 67 99 87 17
 * ---
 * 列排序后
 * ---
 * 26 19 7 37 17
 * 57 67 99 87 27
 * ---
 * 取回 [26, 19, 7, 37, 17, 57, 67, 99, 87, 27]
 * ---
 * gap = 5 / 2 = 2
 * ---
 * 26 19
 * 7 37
 * 17 57
 * 67 99
 * 87 27
 * ---
 * 列排序后
 * ---
 * 7 19
 * 17 27
 * 26 37
 * 67 57
 * 87 99
 * ---
 * 取回 [7, 19, 17, 27, 26, 37, 67 ,57, 87, 99]
 * ---
 * gap = 2 / 2 = 1
 * ---
 * 7
 * 19
 * 17
 * 27
 * 26
 * 37
 * 67
 * 57
 * 87
 * 99
 * ---
 * 列排序后
 * ---
 * 7
 * 17
 * 19
 * 26
 * 27
 * 37
 * 57
 * 67
 * 87
 * 99
 * ---
 * 取回 [7, 17, 19, 26, 27, 37, 57 ,67, 87, 99]
 * ---
 * ---
 * ---
 * **
 * ***************************
 * @author CaMnter
 */
public class ShellSort {

    public <T extends Comparable<T>> void shellSorting(T[] array) {
        int len = array.length;
        int i, j, gap;
        // 逐渐减小步长
        for (gap = len / 2; gap > 0; gap /= 2) {
            // 布置行数据
            for (i = 0; i < gap; i++) {
                // 布置列数据
                for (j = gap; j < len; j += gap) {
                    if (array[j - gap + i].compareTo(array[j + i]) > 0) {
                        T temp = array[j - gap + i];
                        array[j - gap + i] = array[j + i];
                        array[j + i] = temp;
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        Integer[] object = {26, 19, 7, 37, 27, 57, 67, 99, 87, 17};
        System.out.println("\n希尔排序\n");
        ShellSort shellSorting = new ShellSort();
        shellSorting.shellSorting(object);
        System.out.println("\n希尔排序\n");
        for (int i : object) {
            System.out.print(i + " ");
        }
    }
}
