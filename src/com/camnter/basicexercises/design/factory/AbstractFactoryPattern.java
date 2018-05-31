package com.camnter.basicexercises.design.factory;

/**
 * 抽象工厂模式
 * <p/>
 * 因为工程模式的话，新增一个产品，就新增一个工厂
 * 这样造成很多新生类
 * 抽象工厂的话，实现一个工厂，可以创建多种产品
 * <p/>
 * 抽象工厂模式是工厂方法模式的进一步延伸，由于它提供了功能更为强大的工厂类并且具备较好的可扩展性，在软件开发中得以广泛应用，尤其是在一些框架和API类库的设计中，例如在Java语言的AWT（抽象窗口工具包）中就使用了抽象工厂模式，它使用抽象工厂模式来实现在不同的操作系统中应用程序呈现与所在操作系统一致的外观界面。抽象工厂模式也是在软件开发中最常用的设计模式之一。
 * 主要优点
 * 抽象工厂模式的主要优点如下：
 * (1) 抽象工厂模式隔离了具体类的生成，使得客户并不需要知道什么被创建。由于这种隔离，更换一个具体工厂就变得相对容易，所有的具体工厂都实现了抽象工厂中定义的那些公共接口，因此只需改变具体工厂的实例，就可以在某种程度上改变整个软件系统的行为。
 * (2) 当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象。
 * (3) 增加新的产品族很方便，无须修改已有系统，符合“开闭原则”。
 * 主要缺点
 * 抽象工厂模式的主要缺点如下：
 * 增加新的产品等级结构麻烦，需要对原有系统进行较大的修改，甚至需要修改抽象层代码，这显然会带来较大的不便，违背了“开闭原则”。
 * 适用场景
 * 在以下情况下可以考虑使用抽象工厂模式：
 * (1) 一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有类型的工厂模式都是很重要的，用户无须关心对象的创建过程，将对象的创建和使用解耦。
 * (2) 系统中有多于一个的产品族，而每次只使用其中某一产品族。可以通过配置文件等方式来使得用户可以动态改变产品族，也可以很方便地增加新的产品族。
 * (3) 属于同一个产品族的产品将在一起使用，这一约束必须在系统的设计中体现出来。同一个产品族中的产品可以是没有任何关系的对象，但是它们都具有一些共同的约束，如同一操作系统下的按钮和文本框，按钮与文本框之间没有直接关系，但它们都是属于某一操作系统的，此时具有一个共同的约束条件：操作系统的类型。
 * (4) 产品等级结构稳定，设计完成之后，不会向系统中增加新的产品等级结构或者删除已有的产品等级结构。
 *
 * @author CaMnter
 */
public class AbstractFactoryPattern {

    interface Button {

        public void display();

    }

    static class AButton implements Button {

        @Override
        public void display() {
            System.out.println("[AButton]   [display]");
        }

    }

    static class BButton implements Button {

        @Override
        public void display() {
            System.out.println("[BButton]   [display]");
        }

    }

    interface TextView {

        public void display();

    }

    static class ATextView implements TextView {

        @Override
        public void display() {
            System.out.println("[ATextView]   [display]");
        }

    }

    static class BTextView implements TextView {

        @Override
        public void display() {
            System.out.println("[BTextView]   [display]");
        }

    }

    interface ListView {

        public void display();

    }

    static class AListView implements ListView {

        @Override
        public void display() {
            System.out.println("[AListView]   [display]");
        }

    }

    static class BListView implements ListView {

        @Override
        public void display() {
            System.out.println("[BListView]   [display]");
        }

    }

    /**
     * 抽象工厂
     */
    interface AbstractFactory {

        public Button createButton();

        public TextView createTextView();

        public ListView createListView();

    }

    /**
     * 具体工厂
     * 管理一个产品线
     */
    static class AFactory implements AbstractFactory {

        @Override
        public Button createButton() {
            return new AButton();
        }

        @Override
        public TextView createTextView() {
            return new ATextView();
        }

        @Override
        public ListView createListView() {
            return new AListView();
        }

    }

    /**
     * 具体工厂
     * 管理一个产品线
     */
    static class BFactory implements AbstractFactory {

        @Override
        public Button createButton() {
            return new BButton();
        }

        @Override
        public TextView createTextView() {
            return new BTextView();
        }

        @Override
        public ListView createListView() {
            return new BListView();
        }

    }

    public static void main(String[] args) {
        final AbstractFactory aFactory = new AFactory();
        final AbstractFactory bFactory = new BFactory();
        Button aButton = aFactory.createButton();
        TextView aTextView = aFactory.createTextView();
        ListView aListView = aFactory.createListView();
        Button bButton = bFactory.createButton();
        TextView bTextView = bFactory.createTextView();
        ListView bListView = bFactory.createListView();

        aButton.display();
        aTextView.display();
        aListView.display();
        bButton.display();
        bTextView.display();
        bListView.display();
    }

}
