package com.camnter.basicexercises.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 全子集
 *
 * 不去重 版本
 *
 * <p/>
 * 输入 {1, 2, 3}
 * 输出 {}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}
 *
 * @author CaMnter
 */
public class Subsets {

    /**
     * {1,2,3}
     * 先放入一个 {}
     * ------------------------------------------
     * 第一趟循环 拿到 1
     * {} 取出来，备份。 加入 1，得到 {1}
     * 此时就是 {}, {1}
     * ------------------------------------------
     * 第二趟循环 拿到 2
     * {}, {1} 取出来，备份。 加入 2，得到 {2}, {1, 2}
     * 此时就是 {}, {1}, {2}, {1, 2}
     * ------------------------------------------
     * 第二趟循环 拿到 2
     * {}, {1}, {2}, {1, 2} 取出来，备份。 加入 3，得到 {3}, {1, 3}, {2, 3}, {1, 2, 3}
     * 此时就是 {}, {1}, {2}, {1, 2}, {3}, {1, 3}, {2, 3}, {1, 2, 3}
     *
     * @param array array
     * @return List
     */
    public List<List<Integer>> subsets(int[] array) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(new ArrayList<Integer>());
        for (int anArray : array) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for (List<Integer> l : lists) {
                temp.add(l);
                List<Integer> clone = new ArrayList<Integer>();
                clone.addAll(l);
                clone.add(anArray);
                temp.add(clone);
            }
            lists = temp;
        }
        return lists;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] array = {1, 2, 3};
        List<List<Integer>> lists = subsets.subsets(array);
        for (List<Integer> list : lists) {
            System.out.print("{ ");
            for (int v : list) {
                System.out.print(v + " ");
            }
            System.out.print("}");
            System.out.println("");
        }

    }


}
