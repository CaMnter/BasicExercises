package com.camnter.basicexercises.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 *
 * 观察者模式(Observer Pattern)：定义对象之间的一种一对多依赖关系，使得每当一个对象状态发生
 * 改变时，其相关依赖对象皆得到通知并被自动更新。观察者模式的别名包括发布-订阅（Publish/Subscribe）模式、模型-视图
 * （Model/View）模式、源-监听器（Source/Listener）模式或从属者（Dependents）模式。观察者模式是一种对象行为型模
 * 式
 *
 * 1.主要优点
 * 观察者模式的主要优点如下：
 * (1) 观察者模式可以实现表示层和数据逻辑层的分离，定义了稳定的消息更新传递机制，并抽象了更新接口，使得可以有各种各样不同的表示层充当具体观察者角色。
 * (2) 观察者模式在观察目标和观察者之间建立一个抽象的耦合。观察目标只需要维持一个抽象观察者的集合，无须了解其具体观察者。由于观察目标和观察者没有紧密地耦合在一起，因此它们可以属于不同的抽象化层次。
 * (3) 观察者模式支持广播通信，观察目标会向所有已注册的观察者对象发送通知，简化了一对多系统设计的难度。
 * (4) 观察者模式满足“开闭原则”的要求，增加新的具体观察者无须修改原有系统代码，在具体观察者与观察目标之间不存在关联关系的情况下，增加新的观察目标也很方便。
 * 2.主要缺点
 * 观察者模式的主要缺点如下：
 * (1) 如果一个观察目标对象有很多直接和间接观察者，将所有的观察者都通知到会花费很多时间。
 * (2) 如果在观察者和观察目标之间存在循环依赖，观察目标会触发它们之间进行循环调用，可能导致系统崩溃。
 * (3) 观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅只是知道观察目标发生了变化。
 * 3.适用场景
 * 在以下情况下可以考虑使用观察者模式：
 * (1) 一个抽象模型有两个方面，其中一个方面依赖于另一个方面，将这两个方面封装在独立的对象中使它们可以各自独立地改变和复用。
 * (2) 一个对象的改变将导致一个或多个其他对象也发生改变，而并不知道具体有多少对象将发生改变，也不知道这些对象是谁。
 * (3) 需要在系统中创建一个触发链，A对象的行为将影响B对象，B对象的行为将影响C对象……，可以使用观察者模式创建一种链式触发机制。
 *
 * @author CaMnter
 */

public class ObserverPattern {

    public static void main(String[] args) {
        final MessageObserver o1 = new BaseMessageObserver(1, "2222");
        final MessageObserver o2 = new BaseMessageObserver(2, "3333");
        final MessageDispatcher dispatcher = new MessageDispatcher();
        dispatcher.register(o1);
        dispatcher.register(o2);
        dispatcher.dispatchAll(new Message("Hello"));
        dispatcher.dispatchAll(new Message("World"));
    }


    /**
     * 抽象观察者
     */
    interface MessageObserver {

        void onMessage(Message message);

    }


    /**
     * 消息
     */
    private static class Message {

        private final String content;


        private Message(String content) {this.content = content;}


        public String getContent() {
            return content;
        }

    }


    /**
     * 观察者实现类
     */
    public static class BaseMessageObserver implements MessageObserver {

        private final int id;

        private final String name;


        public BaseMessageObserver(int id, String name) {
            this.id = id;
            this.name = name;
        }


        @Override
        public void onMessage(Message message) {
            System.out.println(
                "[BaseMessageObserver] = " + this.name + "   [onMessage]   [Message] = " +
                    message.content);
        }

    }


    /**
     * 被观察者
     */
    public static class MessageDispatcher {

        private final List<MessageObserver> messageObservers = new ArrayList<MessageObserver>();


        public void register(MessageObserver messageObserver) {
            this.messageObservers.add(messageObserver);
        }


        public void unregister(MessageObserver messageObserver) {
            this.messageObservers.remove(messageObserver);
        }


        public void dispatchAll(Message message) {
            for (MessageObserver observer : messageObservers) {
                observer.onMessage(message);
            }
        }

    }

}
