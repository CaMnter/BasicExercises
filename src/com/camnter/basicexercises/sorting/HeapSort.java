package com.camnter.basicexercises.sorting;


/**
 * 堆排序
 * <p/>
 * 大顶堆：非叶子节点，一定要比自己的左右子节点大
 * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 * <p/>
 * 小顶堆：非叶子节点，一定要比自己的左右子节点小
 * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 * <p/>
 * 步骤：
 * 构造初始堆。将给定无序序列构造成一个大顶堆（一般升序采用大顶堆，降序采用小顶堆)
 * 将堆顶元素与末尾元素进行交换，使末尾元素最大。然后继续调整堆，再将堆顶元素与末尾元素交换，得到第二大元素。如此反复进行交换、重建、交换
 * <p/>
 * 思路：
 * 将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
 * 将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端
 * 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
 * <p/>
 * 大顶堆到小顶堆 实现 升序
 * 小顶堆到大顶堆 实现 降序
 * <p/>
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 * <p/>
 *
 * @author CaMnter
 */
public class HeapSort {

    /**
     * 关于 第一个非叶子结点 推导
     * <p/>
     * [4 6 8 5 9]
     * <p/>
     * 得到的树
     * <p/>
     * -       4
     * -   6       8
     * - 5   9
     * <p/>
     * 第一个 非叶子节点 6
     * <p/>
     * array.length / 2 - 1 = 5 / 2 - 1 = 1
     * 所以公式是：array.length / 2 - 1
     *
     * 关于 小顶堆
     *
     * 将堆顶元素与末尾元素进行交换，使末尾元素最大。然后继续调整堆，再将堆顶元素与末
     * 尾元素交换，得到第二大元素。如此反复进行交换、重建、交换
     *
     * @param array array
     */
    public void heapSort(final int[] array) {
        final int length = array.length;
        // 1.构建大顶堆
        for (int i = length / 2 - 1; i >= 0; i--) {
            // 从第一个非叶子结点从下至上，从右至左调整结构
            fitHeap(array, i, length);
        }
        // 2.调整堆结构 + 交换堆顶元素与末尾元素
        for (int j = length - 1; j > 0; j--) {
            // 将堆顶元素与末尾元素进行交换
            swap(array, 0, j);
            // 重新对堆进行调整
            fitHeap(array, 0, j);
        }
    }

    private void fitHeap(final int[] array, int i, final int length) {
        // 先取出当前元素 i
        int temp = array[i];
        /**
         * 从当前 i 节点下的左节点开始
         * 所以，初始化 k = 2 * i + 1，得到的是  i 节点下的左节点
         *
         * 下次循环就是下个 左节点
         * 所以，k = 2 * k + 1
         */
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            /**
             * k + 1 < length 以防没有 左节点
             *
             * 这里是，如果存在左节点 && 右节点 > 左节点
             * 指向 右节点
             *
             * 这里就是寻找 左右节点中 较大者
             */
            if (k + 1 < length && array[k + 1] > array[k]) {
                k++;
            }

            /**
             * 如果左右节点 大于 根节点，temp 上面记录是 根节点
             * 交换 根节点 与 左右节点中的较大者
             * 这里，就是大值上浮
             *
             * 反之，左右节点 小于 根节点
             * 结束调整
             */
            if (array[k] > temp) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        // begin 一直记录较小值 较小值 放到最终的位置
        array[i] = temp;
    }


    public void swap(final int[] array, final int first, final int second) {
        final int temp = array[first];
        array[first] = second;
        array[second] = temp;
    }

    public static void main(String args[]) {
        int[] object = {26, 19, 7, 37, 27, 57, 67, 99, 87, 17};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(object);
        System.out.println("\n堆排序\n");
        for (int i : object) {
            System.out.print(i + " ");
        }
    }

}
