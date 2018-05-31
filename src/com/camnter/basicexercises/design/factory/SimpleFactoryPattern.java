package com.camnter.basicexercises.design.factory;

/**
 * 简单工厂模式
 * 静态工厂方法 ( Static Factory Method ) 模式
 * <p/>
 * 就是抽象类，抽象出差异实现方法，把公共方法保留在抽象类中
 * 然后定义一个 工厂类，提供 实现类，全程值访问 工厂类取 实现类
 * <p/>
 * 简单工厂模式提供了专门的工厂类用于创建对象，将对象的创建和对象的使用分离开，它作为一种最简单的工厂模式在软件开发中得到了较为广泛的应用。
 * 主要优点
 * 简单工厂模式的主要优点如下：
 * (1) 工厂类包含必要的判断逻辑，可以决定在什么时候创建哪一个产品类的实例，客户端可以免除直接创建产品对象的职责，而仅仅“消费”产品，简单工厂模式实现了对象创建和使用的分离。
 * (2) 客户端无须知道所创建的具体产品类的类名，只需要知道具体产品类所对应的参数即可，对于一些复杂的类名，通过简单工厂模式可以在一定程度减少使用者的记忆量。
 * (3) 通过引入配置文件，可以在不修改任何客户端代码的情况下更换和增加新的具体产品类，在一定程度上提高了系统的灵活性。
 * 主要缺点
 * 简单工厂模式的主要缺点如下：
 * (1) 由于工厂类集中了所有产品的创建逻辑，职责过重，一旦不能正常工作，整个系统都要受到影响。
 * (2) 使用简单工厂模式势必会增加系统中类的个数（引入了新的工厂类），增加了系统的复杂度和理解难度。
 * (3) 系统扩展困难，一旦添加新产品就不得不修改工厂逻辑，在产品类型较多时，有可能造成工厂逻辑过于复杂，不利于系统的扩展和维护。
 * (4) 简单工厂模式由于使用了静态工厂方法，造成工厂角色无法形成基于继承的等级结构。
 * 适用场景
 * 在以下情况下可以考虑使用简单工厂模式：
 * (1) 工厂类负责创建的对象比较少，由于创建的对象较少，不会造成工厂方法中的业务逻辑太过复杂。
 * (2) 客户端只知道传入工厂类的参数，对于如何创建对象并不关心。
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
