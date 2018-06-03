package com.camnter.basicexercises.design.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 深克隆原型模式
 *
 * 浅克隆和深克隆的主要区别在于是否支持引用类型的成员变量的复制
 *
 * 深克隆可以完成 对象内的引用 也 clone 一份
 * 在 Java 语言中，如果需要实现深克隆，可以通过序列化 ( Serialization ) 等方式来实现。
 * 序列化就是将对象写到流的过程，写到流中的对象是原有对象的一个拷贝，而原对象仍然存在
 * 于内存中。通过序列化实现的拷贝不仅可以复制对象本身，而且可以复制其引用的成员对象，因
 * 此通过序列化将对象写到一个流中，再从流里将其读出来，可以实现深克隆。需要注意的是能够
 * 实现序列化的对象其类必须实现 Serializable 接口，否则无法实现序列化操作。下面我们使
 * 用深克隆技术来实现工作周报和附件对象的复制，由于要将附件对象和工作周报对象都写入流中
 * 因此两个类均需要实现 Serializable 接口
 *
 * @author CaMnter
 */

public class DeepClonePrototypePattern {

    public static void main(String[] args) {
        final WeeklyLog previous = new WeeklyLog();
        previous.setAttachment(new Attachment());
        final WeeklyLog current = previous.deepClone();

        System.out.println(previous == current);
        System.out.println(previous.attachment == current.attachment);
    }


    public static class Attachment implements Serializable {

        private String name;


        public String getName() {
            return this.name;
        }


        public void setName(String name) {
            this.name = name;
        }

    }


    public static class WeeklyLog implements Serializable {

        private Attachment attachment;
        private String name;
        private String date;
        private String content;


        public Attachment getAttachment() {
            return attachment;
        }


        public void setAttachment(Attachment attachment) {
            this.attachment = attachment;
        }


        public String getName() {
            return name;
        }


        public void setName(String name) {
            this.name = name;
        }


        public String getDate() {
            return date;
        }


        public void setDate(String date) {
            this.date = date;
        }


        public String getContent() {
            return content;
        }


        public void setContent(String content) {
            this.content = content;
        }


        public WeeklyLog deepClone() {
            try {
                // 写当前对象
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    byteArrayOutputStream);
                objectOutputStream.writeObject(this);

                // 读当前对象
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                    byteArrayOutputStream.toByteArray());
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                return (WeeklyLog) objectInputStream.readObject();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

    }

}
