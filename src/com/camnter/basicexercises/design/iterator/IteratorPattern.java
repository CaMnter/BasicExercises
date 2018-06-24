package com.camnter.basicexercises.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 *
 * 迭代器模式(Iterator Pattern)：提供一种方法来访问聚合对象，而不用暴露这个对象的内部表示，其别名为游标(Cursor)
 * 迭代器模式是一种对象行为型模式
 *
 * 主要优点
 * 迭代器模式的主要优点如下：
 * (1) 它支持以不同的方式遍历一个聚合对象，在同一个聚合对象上可以定义多种遍历方式。在迭代器模式中只需要用一个不同的迭代器来替换原有迭代器即可改变遍历算法，我们也可以自己定义迭代器的子类以支持新的遍历方式
 * (2) 迭代器简化了聚合类。由于引入了迭代器，在原有的聚合对象中不需要再自行提供数据遍历等方法，这样可以简化聚合类的设计
 * (3) 在迭代器模式中，由于引入了抽象层，增加新的聚合类和迭代器类都很方便，无须修改原有代码，满足“开闭原则”的要求
 * 主要缺点
 * 迭代器模式的主要缺点如下：
 * (1) 由于迭代器模式将存储数据和遍历数据的职责分离，增加新的聚合类需要对应增加新的迭代器类，类的个数成对增加，这在一定程度上增加了系统的复杂性
 * (2) 抽象迭代器的设计难度较大，需要充分考虑到系统将来的扩展，例如 JDK 内置迭代器 Iterator 就无法实现逆向遍历，如果需要实现逆向遍历，只能通过其子类 ListIterator 等来实现，而 ListIterator 迭代器无法用于操作 Set 类型的聚合对象。在自定义迭代器时，创建一个考虑全面的抽象迭代器并不是件很容易的事情
 * 适用场景
 * 在以下情况下可以考虑使用迭代器模式：
 * (1) 访问一个聚合对象的内容而无须暴露它的内部表示。将聚合对象的访问与内部数据的存储分离，使得访问聚合对象时无须了解其内部实现细节
 * (2) 需要为一个聚合对象提供多种遍历方式
 * (3) 为遍历不同的聚合结构提供一个统一的接口，在该接口的实现类中为不同的聚合结构提供不同的遍历方式，而客户端可以一致性地操作该接口
 *
 * @author CaMnter
 */

public class IteratorPattern {

    public static void main(String[] args) {
        final List<Product> productList = new ArrayList<Product>();
        productList.add(new Product("A", 1.1d));
        productList.add(new Product("B", 2.2d));
        productList.add(new Product("C", 3.3d));
        productList.add(new Product("D", 4.4d));

        ProductList<Product> objectList = new ProductList<Product>(productList);
        ProductIterator<Product> iterator = new ProductIterator<Product>(objectList);

        while (!iterator.isLast()) {
            System.out.print(iterator.getNextItem().getName() + " ");
            iterator.next();
        }
        System.out.println("");
        while (!iterator.isFirst()) {
            System.out.print(iterator.getPreviousItem().getName() + " ");
            iterator.previous();
        }
    }


    /**
     * 抽象迭代器
     */
    interface AbstractIterator {

        /**
         * 移至下一个元素
         */
        public void next();

        /**
         * 判断是否为最后一个元素
         *
         * @return boolean
         */
        public boolean isLast();

        /**
         * 移至上一个元素
         */
        public void previous();

        /**
         * 判断是否为第一个元素
         *
         * @return boolean
         */
        public boolean isFirst();

        /**
         * 获取下一个元素
         *
         * @return Object
         */
        public Object getNextItem();

        /**
         * 获取上一个元素
         *
         * @return Object
         */
        public Object getPreviousItem();

    }


    /**
     * 抽象聚合类
     */
    public static abstract class AbstractObjectList<T> {

        protected final List<T> objects;


        public AbstractObjectList(List<T> objects) {
            this.objects = objects;
        }


        public List<T> getObjects() {
            return this.objects;
        }


        public void addObjects(T t) {
            this.objects.add(t);
        }


        public void removeObject(T t) {
            this.objects.remove(t);
        }


        /**
         * 抽象工程方法
         *
         * @return AbstractIterator
         */
        public abstract AbstractIterator createIterator();

    }


    /**
     * 产品
     */
    public static class Product {

        private final String name;
        private final double price;


        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }


        public String getName() {
            return this.name;
        }


        public double getPrice() {
            return this.price;
        }

    }


    /**
     * 具体迭代器
     *
     * @param <T> T
     */
    public static class ProductIterator<T> implements AbstractIterator {

        private ProductList<T> productList;
        private List<T> products;

        /**
         * 游标，用于记录正向遍历的位置
         */
        private int front;

        /**
         * 游标，用于记录逆向遍历的位置
         */
        private int reverse;


        public ProductIterator(ProductList<T> productList) {
            this.productList = productList;
            this.products = productList.getObjects();
            this.front = 0;
            this.reverse = this.products.size() - 1;
        }


        @Override
        public void next() {
            if (this.front < this.products.size()) {
                this.front++;
            }
        }


        @Override
        public boolean isLast() {
            return this.front == products.size();
        }


        @Override
        public void previous() {
            if (this.reverse > -1) {
                this.reverse--;
            }
        }


        @Override
        public boolean isFirst() {
            return this.reverse == -1;
        }


        @Override
        public T getNextItem() {
            return this.products.get(this.front);
        }


        @Override
        public T getPreviousItem() {
            return this.products.get(this.reverse);
        }

    }


    /**
     * 具体聚合类
     *
     * @param <T> T
     */
    public static class ProductList<T> extends AbstractObjectList<T> {

        public ProductList(List<T> objects) {
            super(objects);
        }


        @Override
        public AbstractIterator createIterator() {
            return new ProductIterator<T>(this);
        }

    }

}
