package com.camnter.basicexercises.sorting;

/**
 * 选择排序
 *
 * @author CaMnter
 */
public class SelectionSort {
    /**
     * 1.选择排序
     * <p/>
     * 选择排序的基本思想是遍历数组的过程中，以 i 代表当前需要排序的序号
     * 则需要在剩余的 [i…n-1] 中找出其中的最小值，然后将找到的最小值与 i
     * 指向的值进行交换。因为每一趟确定元素的过程中都会有一个选择最大值的
     * 子流程，所以人们形象地称之为选择排序。
     * 1.	初始： [38, 17, 16, 16, 7, 31, 39, 32, 2, 11]
     * 2.
     * 3.	i = 0:  [2 , 17, 16, 16, 7, 31, 39, 32, 38 , 11] (0th [38]<->8th [2])
     * 4.
     * 5.	i = 1:  [2, 7 , 16, 16, 17 , 31, 39, 32, 38, 11] (1st [17]<->4th [7])
     * 6.
     * 7.	i = 2:  [2, 7, 11 , 16, 17, 31, 39, 32, 38, 16 ] (2nd [11]<->9th [16])
     * 8.
     * 9.	i = 3:  [2, 7, 11, 16, 17, 31, 39, 32, 38, 16] ( 无需交换 )
     * 10.
     * 11.	i = 4:  [2, 7, 11, 16, 16 , 31, 39, 32, 38, 17 ] (4th [17]<->9th [16])
     * 12.
     * 13.	i = 5:  [2, 7, 11, 16, 16, 17 , 39, 32, 38, 31 ] (5th [31]<->9th [17])
     * 14.
     * 15.	i = 6:  [2, 7, 11, 16, 16, 17, 31 , 32, 38, 39 ] (6th [39]<->9th [31])
     * 16.
     * 17.	i = 7:  [2, 7, 11, 16, 16, 17, 31, 32, 38, 39] ( 无需交换 )
     * 18.
     * 19.	i = 8:  [2, 7, 11, 16, 16, 17, 31, 32, 38, 39] ( 无需交换 )
     * 20.
     * 21.	i = 9:  [2, 7, 11, 16, 16, 17, 31, 32, 38, 39] ( 无需交换 )
     * <p/>
     * 由例子可以看出，选择排序随着排序的进行（ i 逐渐增大），比较的次数会越来越少
     * 但是不论数组初始是否有序，选择排序都会从 i 至数组末尾进行一次选择比较，所以
     * 给定长度的数组，选择排序的比较次数是固定的： 1 + 2 + 3 + …. + n = n * (n + 1) / 2
     * 而交换的次数则跟初始数组的顺序有关，如果初始数组顺序为随机，则在最坏情况下，数组元素
     * 将会交换 n 次，最好的情况下则可能 0 次（数组本身即为有序）。
     * <p/>
     * 由此可以推出，选择排序的时间复杂度和空间复杂度分别为 O(n2 ) 和 O(1)
     * （选择排序只需要一个额外空间用于数组元素交换）
     *
     * @param array
     * @param ascend
     * @param <T>
     */
    public <T extends Comparable<T>> T[] selectionSorting(T[] array, boolean ascend) {
        // 取得数组长度
        int len = array.length;
        //逐个选择比较
        for (int i = 0; i < len; i++) {
            int selected = i;
            /**
             * 与选择后的 其他元素比较
             * Comparable.compareTo() 方法
             * -1 ： 小于
             *  0 ： 等于
             *  1 ： 大于
             */
            for (int j = i + 1; j < len; j++) {
                int compare = array[j].compareTo(array[selected]);
                /**
                 *  如果
                 *  array[j] != array[selected]
                 *  并且
                 *  array[j] 小于 array[selected]
                 *  都成立的时候
                 */
                if ((compare != 0 && compare < 0) == ascend) {
                    selected = j;
                }
            }

            /**
             * 基准数 和 被选择的交换
             * 当然要是没找到选择的数，那么被选择数一直没变是i
             * 也就是基准数自己和自己的交换
             */
            T t = array[i];
            array[i] = array[selected];
            array[selected] = t;
            System.out.print("i = " + i + "  array = ");
            for (T data : array) {
                System.out.print(data + " ");
            }
            System.out.println("");
        }
        return array;
    }


    public static void main(String[] args) {
        /**
         * 选择排序
         */
        SelectionSort selectionSorting = new SelectionSort();
        Integer[] object = {38, 17, 16, 16, 7, 31, 39, 32, 2, 11};
        System.out.println("\n选择排序\n");
        Integer[] result = selectionSorting.selectionSorting(object, true);
        System.out.println("\n选择排序\n");
        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}
