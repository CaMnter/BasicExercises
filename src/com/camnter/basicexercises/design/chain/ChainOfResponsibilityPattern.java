package com.camnter.basicexercises.design.chain;

/**
 * 责任链模式
 *
 * 模仿 okhttp 责任链模式
 * 如果有 错误 response 直接返回，没有的话，传递下个拦截器处理
 *
 * 职责链模式 (Chain of Responsibility Pattern)：避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求
 * 将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。职责链模式是一种对象行为型模式
 *
 * 职责链模式总结
 * 职责链模式通过建立一条链来组织请求的处理者，请求将沿着链进行传递，请求发送者无须知道请求在何时、何处以及如何被处
 * 理，实现了请求发送者与处理者的解耦。
 * 1.主要优点
 * 优点：
 * (1) 职责链模式使得一个对象无须知道是其他哪一个对象处理其请求，对象仅需知道该请求会被处理即可，接收者和发送者都没
 * 有对方的明确信息，且链中的对象不需要知道链的结构，由客户端负责链的创建，降低了系统的耦合度
 * (2) 请求处理对象仅需维持一个指向其后继者的引用，而不需要维持它对所有的候选处理者的引用，可简化对象的相互连接。
 * (3) 在给对象分派职责时，职责链可以给我们更多的灵活性，可以通过在运行时对该链进行动态的增加或修改来增加或改变处理
 * 一个请求的职责
 * (4) 在系统中增加一个新的具体请求处理者时无须修改原有系统的代码，只需要在客户端重新建链即可，从这一点来看是符合
 * “开闭原则” 的
 * 2.主要缺点
 * 缺点：
 * (1) 由于一个请求没有明确的接收者，那么就不能保证它一定会被处理，该请求可能一直到链的末端都得不到处理；一个请求也
 * 可能因职责链没有被正确配置而得不到处理
 * (2) 对于比较长的职责链，请求的处理可能涉及到多个处理对象，系统性能将受到一定影响，而且在进行代码调试时不太方便
 * (3) 如果建链不当，可能会造成循环调用，将导致系统陷入死循环
 * 3.适用场景
 * 在以下情况下可以考虑使用职责链模式：
 * (1) 有多个对象可以处理同一个请求，具体哪个对象处理该请求待运行时刻再确定，客户端只需将请求提交到链上，而无须关心
 * 请求的处理对象是谁以及它是如何处理的。
 * (2) 在不明确指定接收者的情况下，向多个对象中的一个提交一个请求
 * (3) 可动态指定一组对象处理请求，客户端可以动态创建职责链来处理请求，还可以改变链中处理者之间的先后次序
 *
 * @author CaMnter
 */

class ChainOfResponsibilityPattern {

    public static void main(String[] args) {
        RetryAndFollowUpInterceptor retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor();
        BridgeInterceptor bridgeInterceptor = new BridgeInterceptor();
        CacheInterceptor cacheInterceptor = new CacheInterceptor();
        ConnectInterceptor connectInterceptor = new ConnectInterceptor();
        CallServerInterceptor callServerInterceptor = new CallServerInterceptor();

        retryAndFollowUpInterceptor.setNext(bridgeInterceptor);
        bridgeInterceptor.setNext(cacheInterceptor);
        cacheInterceptor.setNext(connectInterceptor);
        connectInterceptor.setNext(callServerInterceptor);

        Response response = retryAndFollowUpInterceptor.execute(new Request("", ""));
        System.out.println(
            "[response.code] = " + response.code + "   [response.data] = " + response.data);
    }


    /**
     * 请求类
     */
    public static class Request {

        private final String head;
        private final String body;


        public Request(String head, String body) {
            this.head = head;
            this.body = body;
        }


        public String getHead() {
            return head;
        }


        public String getBody() {
            return body;
        }

    }


    public static class Response {

        private final int code;
        private final String data;


        public Response(int code, String data) {
            this.code = code;
            this.data = data;
        }


        public int getCode() {
            return code;
        }


        public String getData() {
            return data;
        }

    }


    /**
     * 抽象拦截器
     */
    public static abstract class AbstractInterceptor {

        protected AbstractInterceptor next;


        public void setNext(AbstractInterceptor next) {
            this.next = next;
        }


        public abstract Response intercept(Request request);


        public Response execute(Request request) {
            Response response;
            response = intercept(request);
            if (response.code != 200) return response;
            if (this.next != null) {
                response = next.execute(request);
            }
            return response;
        }

    }


    /**
     * 具体拦截器 - 重试和重定向拦截器
     */
    public static class RetryAndFollowUpInterceptor extends AbstractInterceptor {

        @Override
        public Response intercept(Request request) {
            return retryAndFollowUp(request);
        }


        public Response retryAndFollowUp(Request request) {
            // 重试和重定向
            // ...
            return new Response(200, "[RetryAndFollowUpInterceptor]   [retryAndFollowUp]");
        }

    }


    /**
     * 具体拦截器 - 用户请求转化为向服务器请求拦截器
     */
    public static class BridgeInterceptor extends AbstractInterceptor {

        @Override
        public Response intercept(Request request) {
            return bridge(request);
        }


        public Response bridge(Request request) {
            // 用户请求转化为向服务器请求
            // ...
            return new Response(200, "[BridgeInterceptor]   [bridge]");
        }

    }


    /**
     * 具体拦截器 - 缓存拦截器
     */
    public static class CacheInterceptor extends AbstractInterceptor {

        @Override
        public Response intercept(Request request) {
            return cache(request);
        }


        public Response cache(Request request) {
            // 缓存 是否命中
            // ...
            return new Response(200, "[CacheInterceptor]   [cache]");
        }

    }


    /**
     * 具体拦截器 - 建立连接的拦截器
     */
    public static class ConnectInterceptor extends AbstractInterceptor {

        @Override
        public Response intercept(Request request) {
            return connect(request);
        }


        public Response connect(Request request) {
            // 建立连接
            // ...
            return new Response(200, "[ConnectInterceptor]   [connect]");
        }

    }


    /**
     * 具体拦截器 - 真正向服务器发出请求且得到响应的拦截器
     */
    public static class CallServerInterceptor extends AbstractInterceptor {

        @Override
        public Response intercept(Request request) {
            return callServer(request);
        }


        public Response callServer(Request request) {
            // 真正向服务器发出请求且得到响应
            // ...
            return new Response(200, "[CallServerInterceptor]   [callServer]");
        }

    }

}
