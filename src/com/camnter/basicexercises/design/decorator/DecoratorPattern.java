package com.camnter.basicexercises.design.decorator;

/**
 * 装饰模式
 *
 * 首先有个要装饰的抽象，然后定义一个装饰类的抽象
 * 在这个装饰类的抽象 中 持有 要装饰的抽象
 * 装饰类的抽象 调用了 要装饰的抽象
 * 在具体装饰类中 完成 super 方法，调用 装饰的抽象
 * 关键点在这个 super  方法前后
 * 这个 super 方法前后对 装饰的抽象 进行操作，完成装饰功能
 *
 * 装饰模式是一种用于替代继承的技术，它通过一种无须定义子类的方式来给对象动态增加职责，使用对象之间的关联关系取代类
 * 之间的继承关系。在装饰模式中引入了装饰类，在装饰类中既可以调用待装饰的原有类的方法，还可以增加新的方法，以扩充原
 * 有类的功能
 *
 * 装饰模式总结
 * 装饰模式降低了系统的耦合度，可以动态增加或删除对象的职责，并使得需要装饰的具体构件类和具体装饰类可以独立变化，以便
 * 增加新的具体构件类和具体装饰类。
 *
 * 1.主要优点
 * 装饰模式的主要优点如下：
 * (1) 对于扩展一个对象的功能，装饰模式比继承更加灵活性，不会导致类的个数急剧增加。
 * (2) 可以通过一种动态的方式来扩展一个对象的功能，通过配置文件可以在运行时选择不同的具体装饰类，从而实现不同的行为。
 * (3) 可以对一个对象进行多次装饰，通过使用不同的具体装饰类以及这些装饰类的排列组合，可以创造出很多不同行为的组合，得
 * 到功能更为强大的对象。
 * (4) 具体构件类与具体装饰类可以独立变化，用户可以根据需要增加新的具体构件类和具体装饰类，原有类库代码无须改变，符合
 * “开闭原则”。
 * 2.主要缺点
 * 装饰模式的主要缺点如下：
 * (1) 使用装饰模式进行系统设计时将产生很多小对象，这些对象的区别在于它们之间相互连接的方式有所不同，而不是它们的类
 * 或者属性值有所不同，大量小对象的产生势必会占用更多的系统资源，在一定程序上影响程序的性能。
 * (2) 装饰模式提供了一种比继承更加灵活机动的解决方案，但同时也意味着比继承更加易于出错，排错也很困难，对于多次装饰
 * 的对象，调试时寻找错误可能需要逐级排查，较为繁琐。
 * 3.适用场景
 * 在以下情况下可以考虑使用装饰模式：
 * (1) 在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
 * (2) 当不能采用继承的方式对系统进行扩展或者采用继承不利于系统扩展和维护时可以使用装饰模式。不能采用继承的情况主要
 * 有两类：第一类是系统中存在大量独立的扩展，为支持每一种扩展或者扩展之间的组合将产生大量的子类，使得子类数目呈爆炸性增长；第二类是因为类已定义为不能被继承（如Java语言中的final类）。
 *
 * @author CaMnter
 */

public class DecoratorPattern {

    public static void main(String[] args) {
        // 装饰一个窗口 -> 有滚动条窗口
        final Component window = new Window();
        final Component scrollBarDecorator = new ScrollBarDecorator(window);
        scrollBarDecorator.display();
    }


    /**
     * 抽象构件
     *
     * 包含 构件的抽象概念 和 装饰的抽象概念
     */
    public static abstract class Component {

        public abstract void display();

    }


    /**
     * 具体构件 - 窗口
     */
    public static class Window extends Component {

        @Override
        public void display() {
            System.out.println("[Window]   [display]");
        }

    }


    /**
     * 具体构件 - 文本
     */
    public static class TextView extends Component {

        @Override
        public void display() {
            System.out.println("[TextView]   [display]");
        }

    }


    /**
     * 具体构件 - 列表
     */
    public static class ListView extends Component {

        @Override
        public void display() {
            System.out.println("[ListView]   [display]");
        }

    }


    /**
     * 抽象装饰类
     *
     * 持有 要装饰的抽象
     * 调用 要装饰的抽象
     */
    public static abstract class ComponentDecorator extends Component {

        private final Component component;


        public ComponentDecorator(Component component) {this.component = component;}


        @Override
        public void display() {
            this.decorate(this.component);
            this.component.display();
        }


        protected abstract void decorate(Component component);

    }


    /**
     * 具体装饰类 - 滚动条
     */
    public static class ScrollBarDecorator extends ComponentDecorator {

        public ScrollBarDecorator(Component component) {
            super(component);
        }


        @Override
        protected void decorate(Component component) {
            System.out.println("[ScrollBarDecorator]   [decorate]");
        }

    }


    /**
     * 具体装饰类 - 边框
     */
    public static class BorderDecorator extends ComponentDecorator {

        public BorderDecorator(Component component) {
            super(component);
        }


        @Override
        protected void decorate(Component component) {
            System.out.println("[BlackBorderDecorator]   [decorate]");
        }

    }

}
