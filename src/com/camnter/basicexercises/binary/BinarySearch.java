package com.camnter.basicexercises.binary;

/**
 * 二分搜索
 *
 * @author CaMnter
 */
public class BinarySearch {

    /**
     * 递归方式
     *
     * @param array array
     * @param left  left
     * @param right right
     * @param key   key
     * @return index
     */
    public static int binarySearch(int[] array, int left, int right, int key) {
        if (left <= right) {
            int mid = (left + right) >> 1;
            System.out.println(mid);
            if (key == array[mid])
                return mid;
            else if (key < array[mid])
                return binarySearch(array, left, mid - 1, key);
            else if (key > array[mid])
                return binarySearch(array, mid + 1, right, key);

            else return -1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] array = {16, 26, 36, 46, 76, 86, 93, 106};
        System.out.print("index = \t" + binarySearch(array, 0, array.length - 1, 76));
    }

}
