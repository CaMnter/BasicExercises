package com.camnter.basicexercises.design.proxy;

/**
 * 代理模式
 *
 * 就和 JDK 自带的动态代理（InvocationHandler）一样
 * 可以做任何事情自己调用方法，或者在方法前后做很多事情
 *
 * 代理模式是一种对象结构型模式。在代理模式中引入了一个新的代理对象，代理对象在客户端对象和目标对象之间起到中介的作
 * 用，它去掉客户不能看到的内容和服务或者增添客户需要的额外的新服务
 *
 * 代理模式的共同优点如下：
 * (1) 能够协调调用者和被调用者，在一定程度上降低了系统的耦合度。
 * (2) 客户端可以针对抽象主题角色进行编程，增加和更换代理类无须修改源代码，符合开闭原则，系统具有较好的灵活性和可扩展性。
 * 代理模式的主要缺点如下：
 * (1) 由于在客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢，例如保护代理。
 * (2) 实现代理模式需要额外的工作，而且有些代理模式的实现过程较为复杂，例如远程代理。
 *
 * @author CaMnter
 */

public class ProxyPattern {

    public static void main(String[] args) {
        final RealSearcher realSearcher = new RealSearcher();
        final ProxySearcher proxySearcher = new ProxySearcher(realSearcher);
        proxySearcher.search("233", "233");
    }


    /**
     * 业务接口
     */
    interface Searcher {

        String search(String userId, String keyword);

    }


    public static class Validator {

        public boolean validate(String userId) {
            System.out.println("[Validator]   [validate]   [userId] = " + userId);
            return true;
        }

    }


    public static class Logger {

        public void log(String userId) {
            System.out.println("[Logger]   [log]   [userId] = " + userId);
        }

    }


    /**
     * 被代理类
     */
    public static class RealSearcher implements Searcher {

        @Override
        public String search(String userId, String keyword) {
            System.out.println("[RealSearcher]   [search]   [userId] = " + userId);
            return "yes";
        }

    }


    /**
     * 代理类
     */
    public static class ProxySearcher implements Searcher {

        private final Validator validator;
        private final RealSearcher realSearcher;
        private final Logger logger;


        public ProxySearcher(RealSearcher realSearcher) {
            this.validator = new Validator();
            this.realSearcher = realSearcher;
            this.logger = new Logger();
        }


        @Override
        public String search(String userId, String keyword) {
            System.out.println("[ProxySearcher]   [search]   [userId] = " + userId);
            if (!this.validator.validate(userId)) return "no";
            this.realSearcher.search(userId, keyword);
            this.logger.log(userId);
            return "yes";
        }

    }

}
