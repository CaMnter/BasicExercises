package com.camnter.basicexercises.design.prototype;

/**
 * 浅克隆原型模式
 *
 * 浅克隆和深克隆的主要区别在于是否支持引用类型的成员变量的复制
 *
 * @author CaMnter
 */

public class ShallowClonePrototypePattern {

    public static void main(String[] args) {
        final WeeklyLog previous = new WeeklyLog();
        previous.setAttachment(new Attachment());
        final WeeklyLog current = previous.clone();

        System.out.println(previous == current);
        System.out.println(previous.attachment == current.attachment);
    }


    public static class Attachment {

        private String name;


        public String getName() {
            return this.name;
        }


        public void setName(String name) {
            this.name = name;
        }

    }


    public static class WeeklyLog implements Cloneable {

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


        public WeeklyLog clone() {
            WeeklyLog weeklyLog = null;
            try {

                weeklyLog = (WeeklyLog) super.clone();

            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return weeklyLog;
        }

    }

}
