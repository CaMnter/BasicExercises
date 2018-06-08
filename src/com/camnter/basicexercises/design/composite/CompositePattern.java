package com.camnter.basicexercises.design.composite;

import java.util.ArrayList;

/**
 * 组合模式
 *
 * 一个抽象的实现，一堆这种抽象，组装在一起
 * 然后这个持有一堆抽象的 这个抽象实现，就实现了组合模式
 *
 * 组合模式总结
 * 组合模式使用面向对象的思想来实现树形结构的构建与处理，描述了如何将容器对象和叶子对象进行递归组合，实现简单，灵活性好
 *
 * 主要优点
 * 组合模式的主要优点如下：
 * (1) 组合模式可以清楚地定义分层次的复杂对象，表示对象的全部或部分层次，它让客户端忽略了层次的差异，方便对整个层次结构进行控制。
 * (2) 客户端可以一致地使用一个组合结构或其中单个对象，不必关心处理的是单个对象还是整个组合结构，简化了客户端代码。
 * (3) 在组合模式中增加新的容器构件和叶子构件都很方便，无须对现有类库进行任何修改，符合“开闭原则”。
 * (4) 组合模式为树形结构的面向对象实现提供了一种灵活的解决方案，通过叶子对象和容器对象的递归组合，可以形成复杂的树形结构，但对树形结构的控制却非常简单。
 * 主要缺点
 * 组合模式的主要缺点如下：
 * 在增加新构件时很难对容器中的构件类型进行限制。有时候我们希望一个容器中只能有某些特定类型的对象，例如在某个文件夹中
 * 只能包含文本文件，使用组合模式时，不能依赖类型系统来施加这些约束，因为它们都来自于相同的抽象层，在这种情况下，必须
 * 通过在运行时进行类型检查来实现，这个实现过程较为复杂。
 *
 * @author CaMnter
 */

public class CompositePattern {

    public static void main(String args[]) {
        AbstractFile file1, file2, file3, file4, file5, folder1, folder2, folder3;

        file1 = new ImageFile("image_file_1");
        file2 = new VideoFile("video_file_2");
        file3 = new ImageFile("image_file_3");
        file4 = new VideoFile("video_file_4");
        file5 = new ImageFile("image_file_5");

        folder1 = new Folder("folder_1");
        folder2 = new Folder("folder_2");
        folder3 = new Folder("folder_3");

        folder1.add(file1);
        folder2.add(file2);
        folder2.add(file3);
        folder3.add(file4);
        folder3.add(file5);

        folder1.add(folder2);
        folder1.add(folder3);

        folder1.killVirus();
    }


    /**
     * 抽象文件
     * 抽象构件
     */
    public static abstract class AbstractFile {

        public abstract void add(AbstractFile file);

        public abstract void remove(AbstractFile file);

        public abstract AbstractFile getChild(int i);

        public abstract void killVirus();

    }


    /**
     * 抽象非文件夹
     */
    public static abstract class File extends AbstractFile {

        protected final String name;


        public File(String name) {
            this.name = name;
        }


        @Override
        public void add(AbstractFile file) {
            System.out.println("UnSupported!");
        }


        @Override
        public void remove(AbstractFile file) {
            System.out.println("UnSupported!");
        }


        @Override
        public AbstractFile getChild(int i) {
            System.out.println("不支持");
            return null;
        }

    }


    /**
     * 图像文件类
     * 叶子构件
     */
    public static class ImageFile extends File {

        public ImageFile(String name) {
            super(name);
        }


        @Override
        public void killVirus() {
            System.out.println("[ImageFile]   [killVirus]   [name]" + this.name);
        }

    }


    /**
     * 视频文件类
     * 叶子构件
     */
    public static class VideoFile extends File {

        public VideoFile(String name) {
            super(name);
        }


        @Override
        public void killVirus() {
            System.out.println("[VideoFile]   [killVirus]   [name]" + this.name);
        }

    }


    /**
     * 文件化
     * 开始组合
     */
    public static class Folder extends AbstractFile {

        private final String name;
        private ArrayList<AbstractFile> fileList = new ArrayList<AbstractFile>();


        public Folder(String name) {
            this.name = name;
        }


        @Override
        public void add(AbstractFile file) {
            this.fileList.add(file);
        }


        @Override
        public void remove(AbstractFile file) {
            this.fileList.remove(file);
        }


        @Override
        public AbstractFile getChild(int i) {
            return this.fileList.get(i);
        }


        @Override
        public void killVirus() {
            for (AbstractFile file : fileList) {
                file.killVirus();
            }
        }

    }

}
