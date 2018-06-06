package com.camnter.basicexercises.design.bridge;

/**
 * 桥接模式
 *
 * 简单来说，就是一个抽象，持有另外一个抽象，去完成需要的功能
 * 这也就不关心实现类怎么变化了，面向抽象编程，很常用
 *
 * 桥接模式总结
 * 桥接模式是设计 Java 虚拟机和实现 JDBC 等驱动程序的核心模式之一，应用较为广泛。在软件开发中如果一个类或一个系统有
 * 多个变化维度时，都可以尝试使用桥接模式对其进行设计。桥接模式为多维度变化的系统提供了一套完整的解决方案，并且降低了
 * 系统的复杂度。
 * 1.主要优点
 * 桥接模式的主要优点如下：
 * (1)分离抽象接口及其实现部分。桥接模式使用“对象间的关联关系”解耦了抽象和实现之间固有的绑定关系，使得抽象和实现可以
 * 沿着各自的维度来变化。所谓抽象和实现沿着各自维度的变化，也就是说抽象和实现不再在同一个继承层次结构中，而是“子类化”
 * 它们，使它们各自都具有自己的子类，以便任何组合子类，从而获得多维度组合对象。
 * (2)在很多情况下，桥接模式可以取代多层继承方案，多层继承方案违背了“单一职责原则”，复用性较差，且类的个数非常多，桥
 * 接模式是比多层继承方案更好的解决方法，它极大减少了子类的个数。
 * (3)桥接模式提高了系统的可扩展性，在两个变化维度中任意扩展一个维度，都不需要修改原有系统，符合“开闭原则”。
 * 2.主要缺点
 * 桥接模式的主要缺点如下：
 * (1)桥接模式的使用会增加系统的理解与设计难度，由于关联关系建立在抽象层，要求开发者一开始就针对抽象层进行设计与编程。
 * (2)桥接模式要求正确识别出系统中两个独立变化的维度，因此其使用范围具有一定的局限性，如何正确识别两个独立维度也需要
 * 一定的经验积累。
 * 3.适用场景
 * 在以下情况下可以考虑使用桥接模式：
 * (1)如果一个系统需要在抽象化和具体化之间增加更多的灵活性，避免在两个层次之间建立静态的继承关系，通过桥接模式可以使
 * 它们在抽象层建立一个关联关系。
 * (2)“抽象部分”和“实现部分”可以以继承的方式独立扩展而互不影响，在程序运行时可以动态将一个抽象化子类的对象和一个实现
 * 化子类的对象进行组合，即系统需要对抽象化角色和实现化角色进行动态耦合。
 * (3)一个类存在两个（或多个）独立变化的维度，且这两个（或多个）维度都需要独立进行扩展。
 * (4)对于那些不希望使用继承或因为多层继承导致系统类的个数急剧增加的系统，桥接模式尤为适用。
 *
 * @author CaMnter
 */

public class BridgePattern {

    public static void main(String[] args) {

        PNGImage pngImage = new PNGImage();
        UnixImp unixImp = new UnixImp();
        pngImage.setImageImp(unixImp);

        pngImage.parseFile("x.png");
    }


    interface ImageImp {
        public void doPaint(Matrix m);
    }


    public static class Matrix {}


    public static class WindowsImp implements ImageImp {

        @Override
        public void doPaint(Matrix m) {
            System.out.println("[WindowsImp]   [doPaint]");
        }

    }


    public static class LinuxImp implements ImageImp {

        @Override
        public void doPaint(Matrix m) {
            System.out.println("[LinuxImp]   [doPaint]");
        }

    }


    public static class UnixImp implements ImageImp {

        @Override
        public void doPaint(Matrix m) {
            System.out.println("[UnixImp]   [doPaint]");
        }

    }


    public static class JPGImage extends Image {

        @Override
        public void parseFile(String fileName) {
            Matrix m = new Matrix();
            this.imageImp.doPaint(m);
            System.out.println("[JPGImage]   [parseFile]");
        }

    }


    public static class PNGImage extends Image {

        @Override
        public void parseFile(String fileName) {
            Matrix m = new Matrix();
            this.imageImp.doPaint(m);
            System.out.println("[PNGImage]   [parseFile]");
        }

    }


    public static class BMPImage extends Image {

        @Override
        public void parseFile(String fileName) {
            Matrix m = new Matrix();
            this.imageImp.doPaint(m);
            System.out.println("[BMPImage]   [parseFile]");
        }

    }


    public static class GIFImage extends Image {

        @Override
        public void parseFile(String fileName) {
            Matrix m = new Matrix();
            this.imageImp.doPaint(m);
            System.out.println("[GIFImage]   [parseFile]");
        }

    }


    public static abstract class Image {

        protected ImageImp imageImp;


        public void setImageImp(ImageImp imageImp) {
            this.imageImp = imageImp;
        }


        public abstract void parseFile(String fileName);

    }

}
