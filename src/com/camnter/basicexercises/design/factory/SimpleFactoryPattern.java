package com.camnter.basicexercises.design.factory;

/**
 * 简单工厂模式
 * 静态工厂方法 ( Static Factory Method ) 模式
 * <p/>
 * 就是抽象类，抽象出差异实现方法，把公共方法保留在抽象类中
 * 然后定义一个 工厂类，提供 实现类，全程值访问 工厂类取 实现类
 *
 * @author CaMnter
 */
public class SimpleFactoryPattern {

    static abstract class Product {

        /**
         * 公共业务方法
         */
        public void methodSame() {
            // 公共业务实现
        }

        public abstract void methodDiff();

    }

    static class ProductA extends Product {

        @Override
        public void methodDiff() {
            System.out.println("[ProductA]   [methodDiff]");
        }

    }

    static class ProductB extends Product {

        @Override
        public void methodDiff() {
            System.out.println("[ProductB]   [methodDiff]");
        }

    }

    enum ProductType {

        A("A"), B("B");

        String value;

        ProductType(String value) {
            this.value = value;
        }

    }

    static final class Factory {

        public static Product getProduct(ProductType type) {
            Product product = null;
            switch (type) {
                case A:
                    product = new ProductA();
                    break;
                case B:
                    product = new ProductB();
                    break;
            }
            return product;
        }

    }

    public static void main(String[] args) {
        final Product product = Factory.getProduct(ProductType.A);
        product.methodSame();
        product.methodDiff();
    }

}
