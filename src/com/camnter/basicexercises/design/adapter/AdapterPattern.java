package com.camnter.basicexercises.design.adapter;

/**
 * 适配器模式
 *
 * 没有总结，因为很简单
 *
 * 适配器模式总结
 * 适配器模式将现有接口转化为客户类所期望的接口，实现了对现有类的复用，它是一种使用频率非常高的设计模式。
 *
 * 主要优点
 * 无论是对象适配器模式还是类适配器模式都具有如下优点：
 * (1) 将目标类和适配者类解耦，通过引入一个适配器类来重用现有的适配者类，无须修改原有结构。
 * (2) 增加了类的透明性和复用性，将具体的业务实现过程封装在适配者类中，对于客户端类而言是透明的，而且提高了适配者的复用性，同一个适配者类可以在多个不同的系统中复用。
 * (3) 灵活性和扩展性都非常好，通过使用配置文件，可以很方便地更换适配器，也可以在不修改原有代码的基础上增加新的适配器类，完全符合“开闭原则”。
 * 具体来说，类适配器模式还有如下优点：
 * 由于适配器类是适配者类的子类，因此可以在适配器类中置换一些适配者的方法，使得适配器的灵活性更强。
 * 对象适配器模式还有如下优点：
 * (1) 一个对象适配器可以把多个不同的适配者适配到同一个目标；
 * (2) 可以适配一个适配者的子类，由于适配器和适配者之间是关联关系，根据“里氏代换原则”，适配者的子类也可通过该适配器进行适配。
 *
 * 对象适配器模式的缺点如下：
 * 与类适配器模式相比，要在适配器中置换适配者类的某些方法比较麻烦。如果一定要置换掉适配者类的一个或多个方法，可以先做一个适配者类
 * 的子类，将适配者类的方法置换掉，然后再把适配者类的子类当做真正的适配者进行适配，实现过程较为复杂。
 *
 * 适用场景
 * 在以下情况下可以考虑使用适配器模式：
 * (1) 系统需要使用一些现有的类，而这些类的接口（如方法名）不符合系统的需要，甚至没有这些类的源代码。
 * (2) 想创建一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，包括一些可能在将来引进的类一起工作。
 *
 * @author CaMnter
 */

public class AdapterPattern {

    interface ScoreOperation {

        public int[] sort(int array[]);

        public int search(int array[], int key);

    }


    public static class QuickSort {

        public int[] quickSort(int array[]) {
            sort(array, 0, array.length - 1);
            return array;
        }


        public void sort(int array[], int p, int r) {
            int q = 0;
            if (p < r) {
                q = partition(array, p, r);
                sort(array, p, q - 1);
                sort(array, q + 1, r);
            }
        }


        public int partition(int[] a, int p, int r) {
            int x = a[r];
            int j = p - 1;
            for (int i = p; i <= r - 1; i++) {
                if (a[i] <= x) {
                    j++;
                    swap(a, j, i);
                }
            }
            swap(a, j + 1, r);
            return j + 1;
        }


        public void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

    }


    public static class BinarySearch {

        public int binarySearch(int array[], int key) {
            int low = 0;
            int high = array.length - 1;
            while (low <= high) {
                int mid = (low + high) >>> 2;
                int midVal = array[mid];
                if (midVal < key) {
                    low = mid + 1;
                } else if (midVal > key) {
                    high = mid - 1;
                } else {
                    return 1;
                }
            }
            return -1;
        }

    }


    /**
     * 适配器
     */
    public static class OperationAdapter implements ScoreOperation {

        private QuickSort quickSort;
        private BinarySearch binarySearch;


        public OperationAdapter() {
            quickSort = new QuickSort();
            binarySearch = new BinarySearch();
        }


        public int[] sort(int array[]) {
            return quickSort.quickSort(array);
        }


        public int search(int array[], int key) {
            return binarySearch.binarySearch(array, key);
        }

    }

}
