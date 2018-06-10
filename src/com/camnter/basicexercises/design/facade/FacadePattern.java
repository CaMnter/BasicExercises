package com.camnter.basicexercises.design.facade;

/**
 * 外观模式
 *
 * 就是一个外观类，持有一堆业务类的引用
 * 然后根据业务方需求，调用外观类，然后外观类调用这堆业务类的引用完成需求
 * 良好的外观模式：尽量少修改外观类，实在不行就把外观类抽象出去
 *
 * 外观模式：为子系统中的一组接口提供一个统一的入口。外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
 *
 * 外观模式又称为门面模式，它是一种对象结构型模式。外观模式是迪米特法则的一种具体实现，通过引入一个新的外观角色可以
 * 降低原有系统的复杂度，同时降低客户类与子系统的耦合度
 *
 * 模式优点
 * 外观模式的主要优点如下：
 * (1) 它对客户端屏蔽了子系统组件，减少了客户端所需处理的对象数目，并使得子系统使用起来更加容易。通过引入外观模式，客户端代码将变得很简单，与之关联的对象也很少。
 * (2) 它实现了子系统与客户端之间的松耦合关系，这使得子系统的变化不会影响到调用它的客户端，只需要调整外观类即可。
 * (3) 一个子系统的修改对其他子系统没有任何影响，而且子系统内部变化也不会影响到外观对象。
 * 模式缺点
 * 外观模式的主要缺点如下：
 * (1) 不能很好地限制客户端直接使用子系统类，如果对客户端访问子系统类做太多的限制则减少了可变性和灵活 性。
 * (2) 如果设计不当，增加新的子系统可能需要修改外观类的源代码，违背了开闭原则。
 * 模式适用场景
 * 在以下情况下可以考虑使用外观模式：
 * (1) 当要为访问一系列复杂的子系统提供一个简单入口时可以使用外观模式。
 * (2) 客户端程序与多个子系统之间存在很大的依赖性。引入外观类可以将子系统与客户端解耦，从而提高子系统的独立性和可移植性。
 * (3) 在层次化结构中，可以使用外观模式定义系统中每一层的入口，层与层之间不直接产生联系，而通过外观类建立联系，降低层之间的耦合度。
 *
 * @author CaMnter
 */

public class FacadePattern {

    public static void main(String[] args) {
        BaseEncryptFacade baseEncryptFacade = new BaseEncryptFacade(new NormalCipher());
        baseEncryptFacade.fileEncrypt("a.txt", "b.txt");

        baseEncryptFacade = new BaseEncryptFacade(new NewCipher());
        baseEncryptFacade.fileEncrypt("a.txt", "b.txt");
    }


    /**
     * 抽象 - 加密
     */
    public interface Cipher {

        public String encrypt(String content);

    }


    /**
     * 抽象外观类
     */
    public interface EncryptFacade {

        public boolean fileEncrypt(String filePath, String outputPath);

    }


    /**
     * 业务类 - 文件读取
     */
    public static class FileReader {

        public String read(String filePath) {
            System.out.println("[FileReader]   [read]   [filePath] = " + filePath);
            return "[FileReader]   [read]";
        }

    }


    /**
     * 业务类 - 普通加密
     */
    public static class NormalCipher implements Cipher {

        @Override
        public String encrypt(String content) {
            System.out.println("[NormalCipher]   [encrypt]");
            return content;
        }

    }


    /**
     * 业务类 - 新版本加密类
     */
    public static class NewCipher implements Cipher {

        @Override
        public String encrypt(String content) {
            System.out.println("[NewCipher]   [encrypt]");
            return content;
        }

    }


    /**
     * 业务类 - 文件保存
     */
    public static class FileWriter {

        public boolean write(String content, String outputPath) {
            System.out.println("[FileWriter]   [write]   [outputPath] = " + outputPath);
            return true;
        }

    }


    /**
     * 具体外观类
     */
    public static class BaseEncryptFacade implements EncryptFacade {

        private final FileReader fileReader;
        private final Cipher cipher;
        private final FileWriter fileWriter;


        protected BaseEncryptFacade(Cipher cipher) {
            this.fileReader = new FileReader();
            this.cipher = cipher;
            this.fileWriter = new FileWriter();
        }


        @Override
        public boolean fileEncrypt(String filePath, String outputPath) {
            final String content = this.fileReader.read(filePath);
            final String cipherText = this.cipher.encrypt(content);
            return this.fileWriter.write(cipherText, outputPath);
        }

    }

}
