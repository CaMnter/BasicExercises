package com.camnter.basicexercises.sorting;

/**
 * 归并排序
 * <p/>
 * 归并操作(merge)，也叫归并算法，指的是将两个顺序序列合并成一个顺序序列的方法。
 * 如　设有数列{6，202，100，301，38，8，1}
 * 初始状态：6,202,100,301,38,8,1
 * 第一次归并后：{6,202},{100,301},{8,38},{1}，比较次数：3；
 * 第二次归并后：{6,100,202,301}，{1,8,38}，比较次数：4；
 * 第三次归并后：{1,6,8,38,100,202,301},比较次数：5；
 * 总的比较次数为：3+4+5=12,；
 * 逆序数为14；
 * <p/>
 * @author CaMnter
 */
public class MergeSort {

    public void mergeSort(final int[] rawArray) {
        final int[] temp = new int[rawArray.length];
        mergeSort(rawArray, 0, rawArray.length - 1, temp);
    }

    private void mergeSort(final int[] rawArray,
                           final int left,
                           final int right,
                           final int[] temp) {
        if (left >= right) return;
        final int mid = (left + right) / 2;
        // 左边归并排序，使得左子序列有序
        mergeSort(rawArray, left, mid, temp);
        // 右边归并排序，使得右子序列有序
        mergeSort(rawArray, mid + 1, right, temp);
        // 将两个有序子数组合并操作
        merge(rawArray, left, mid, right, temp);
    }

    private void merge(final int[] rawArray,
                       int left,
                       final int mid,
                       final int right,
                       final int[] temp) {

        int l = left;
        int r = mid + 1;
        int t = 0;

        while (l <= mid && r <= right) {
            if (rawArray[l] <= rawArray[r]) {
                temp[t++] = rawArray[l++];
            } else {
                temp[t++] = rawArray[r++];
            }
        }

        // 将左边剩余元素填充进 temp 中
        while (l <= mid) {
            temp[t++] = rawArray[l++];
        }

        // 将右序列剩余元素填充进 temp 中
        while (r <= right) {
            temp[t++] = rawArray[r++];
        }


        // 将 temp 中的元素全部拷贝到原数组中
        t = 0;
        while (left <= right) {
            rawArray[left++] = temp[t++];
        }

    }

    public static void main(String args[]) {
        int[] object = {26, 19, 7, 37, 27, 57, 67, 99, 87, 17};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(object);
        System.out.println("\n归并排序\n");
        for (int i : object) {
            System.out.print(i + " ");
        }
    }

}

