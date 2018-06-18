package com.camnter.basicexercises.design.command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 命令队列
 *
 * @author CaMnter
 */

class CommandQueue {

    public static void main(String[] args) {
        RealCommandQueue realCommandQueue = new RealCommandQueue();
        realCommandQueue.addCommand(new HelpCommand());
        realCommandQueue.addCommand(new MinimizeCommand());

        Invoker invoker = new Invoker(realCommandQueue);
        invoker.call();
    }


    /**
     * 调用者
     */
    public static class Invoker {

        private RealCommandQueue realCommandQueue;


        public Invoker(RealCommandQueue realCommandQueue) {
            this.realCommandQueue = realCommandQueue;
        }


        public void setRealCommandQueue(RealCommandQueue realCommandQueue) {
            this.realCommandQueue = realCommandQueue;
        }


        public void call() {
            this.realCommandQueue.execute();
        }

    }


    /**
     * 命令队列
     */
    public static class RealCommandQueue {

        private Queue<Command> commands = new LinkedList<Command>();


        public void addCommand(Command command) {
            this.commands.add(command);
        }


        public void removeCommand(Command command) {
            this.commands.remove(command);
        }


        public void execute() {
            while (!this.commands.isEmpty()) {
                this.commands.poll().execute();
            }
        }
    }


    /**
     * 抽象命令类
     */
    public static abstract class Command {

        public abstract void execute();

    }


    /**
     * 具体命令类 - 帮助
     */
    public static class HelpCommand extends Command {

        private final HelpHandler helpHandler;


        public HelpCommand() {
            this.helpHandler = new HelpHandler();
        }


        @Override
        public void execute() {
            this.helpHandler.help();
        }


        private static class HelpHandler {

            public void help() {
                System.out.println("[HelpHandler]   [help]");
            }

        }

    }


    /**
     * 具体命令类 - 窗口最小化
     */
    public static class MinimizeCommand extends Command {

        private final WindowHandler windowHandler;


        public MinimizeCommand() {
            this.windowHandler = new WindowHandler();
        }


        @Override
        public void execute() {
            this.windowHandler.minimize();
        }


        public static class WindowHandler {

            public void minimize() {
                System.out.println("[WindowHandler]   [minimize]");
            }

        }

    }


    /**
     * 功能按钮
     */
    public static class FunctionButton {

        private final String name;
        private Command command;


        public FunctionButton(String name) {
            this.name = name;
        }


        public void setCommand(Command command) {
            this.command = command;
        }


        public void onClick() {
            System.out.println("[FunctionButton]   [name] = " + this.name);
            this.command.execute();
        }

    }

}
