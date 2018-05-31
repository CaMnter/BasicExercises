package com.camnter.basicexercises.design.factory;

/**
 * 工厂模式
 * <p/>
 * 就是简单工程模式的延伸版本。
 * 特点就是把工程类也抽象出去了。
 * 这样的话，新增一个产品，就不需要修改原来的工厂类方法（ 加 if else）
 * 只需要创建一个新的工厂类即可，因为工厂类抽象出去了
 * <p/>
 * 工厂方法模式是简单工厂模式的延伸，它继承了简单工厂模式的优点，同时还弥补了简单工厂模式的不足。工厂方法模式是使用频率最高的设计模式之一，是很多开源框架和 API 类库的核心模式。
 * 主要优点
 * 工厂方法模式的主要优点如下：
 * (1) 在工厂方法模式中，工厂方法用来创建客户所需要的产品，同时还向客户隐藏了哪种具体产品类将被实例化这一细节，用户只需要关心所需产品对应的工厂，无须关心创建细节，甚至无须知道具体产品类的类名。
 * (2) 基于工厂角色和产品角色的多态性设计是工厂方法模式的关键。它能够让工厂可以自主确定创建何种产品对象，而如何创建这个对象的细节则完全封装在具体工厂内部。工厂方法模式之所以又被称为多态工厂模式，就正是因为所有的具体工厂类都具有同一抽象父类。
 * (3) 使用工厂方法模式的另一个优点是在系统中加入新产品时，无须修改抽象工厂和抽象产品提供的接口，无须修改客户端，也无须修改其他的具体工厂和具体产品，而只要添加一个具体工厂和具体产品就可以了，这样，系统的可扩展性也就变得非常好，完全符合“开闭原则”。
 * 主要缺点
 * 工厂方法模式的主要缺点如下：
 * (1) 在添加新产品时，需要编写新的具体产品类，而且还要提供与之对应的具体工厂类，系统中类的个数将成对增加，在一定程度上增加了系统的复杂度，有更多的类需要编译和运行，会给系统带来一些额外的开销。
 * (2) 由于考虑到系统的可扩展性，需要引入抽象层，在客户端代码中均使用抽象层进行定义，增加了系统的抽象性和理解难度，且在实现时可能需要用到DOM、反射等技术，增加了系统的实现难度。
 * 适用场景
 * 在以下情况下可以考虑使用工厂方法模式：
 * (1) 客户端不知道它所需要的对象的类。在工厂方法模式中，客户端不需要知道具体产品类的类名，只需要知道所对应的工厂即可，具体的产品对象由具体工厂类创建，可将具体工厂类的类名存储在配置文件或数据库中。
 * (2) 抽象工厂类通过其子类来指定创建哪个对象。在工厂方法模式中，对于抽象工厂类只需要提供一个创建产品的接口，而由其子类来确定具体要创建的对象，利用面向对象的多态性和里氏代换原则，在程序运行时，子类对象将覆盖父类对象，从而使得系统更容易扩展。
 *
 * @author CaMnter
 */
public class FactoryPattern {

    interface Logger {

        void writeLog();

    }

    static class DatabaseLogger implements Logger {

        @Override
        public void writeLog() {
            System.out.println("[DatabaseLogger]   [writeLog]");
        }

    }

    static class FileLogger implements Logger {

        public void writeLog() {
            System.out.println("[FileLogger]   [writeLog]");
        }

    }

    interface LoggerFactory {

        Logger createLogger();

    }

    static class DatabaseLoggerFactory implements LoggerFactory {

        @Override
        public Logger createLogger() {
            return new DatabaseLogger();
        }

    }

    static class FileLoggerFactory implements LoggerFactory {

        @Override
        public Logger createLogger() {
            return new FileLogger();
        }

    }


    public static void main(String[] args) {
        // 不需要知道具体 LoggerFactory
        final LoggerFactory loggerFactory = new FileLoggerFactory();
        // 不需要知道具体 Logger
        final Logger logger = loggerFactory.createLogger();
        logger.writeLog();
    }

}
