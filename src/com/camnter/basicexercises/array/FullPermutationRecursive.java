package com.camnter.basicexercises.array;

import java.util.Arrays;

/**
 * 全排列
 * <p/>
 * 不去重递归 版本
 * <p/>
 * 如果原始要排列的数组顺序为 1、2、3、4，现在只要分别交换1、2， 1、3， 1、4 然后对剩下的 3 个元素进行递归的排列
 * <p/>
 *
 * @author CaMnter
 */
public class FullPermutationRecursive {

    /**
     * @param array array
     * @param s     s
     */
    public void fullPermutation(int[] array, int s) {
        if (s == array.length - 1) {
            /**
             * 如果到了数组最后一个元素，前面的元素已经排好
             * 输出
             */
            System.out.println(Arrays.toString(array));
        }
        for (int i = s; i < array.length; i++) {
            /**
             * 第一个元素分别与后面的元素进行交换
             * 然后递归的调用其子数组进行排序
             */
            swap(array, i, s);
            fullPermutation(array, s + 1);
            /**
             * 子数组排序返回后要将第一个元素交换回来
             * 如果不交换回来会出错，比如说第一次 1、2 交换，第一个位置为 2
             * 子数组排序返回后如果不将 1、2
             * 交换回来第二次交换的时候就会将 2、3 交换，因此必须将 1、2 交换使 1 还是在第一个位置
             */
            swap(array, i, s);
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        FullPermutationRecursive fullPermutationRecursive = new FullPermutationRecursive();
        fullPermutationRecursive.fullPermutation(array, 0);
    }

}
