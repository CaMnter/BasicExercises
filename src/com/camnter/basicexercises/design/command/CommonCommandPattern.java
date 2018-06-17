package com.camnter.basicexercises.design.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令模式
 *
 * 命令模式 (Command Pattern)：将一个请求封装为一个对象，从而让我们可用不同的请求对客户进行参数化；对请求排队或者
 * 记录请求日志，以及支持可撤销的操作。命令模式是一种对象行为型模式，其别名为动作 (Action) 模式或
 * 事务 (Transaction) 模式
 *
 * @author CaMnter
 */

public class CommonCommandPattern {

    public static void main(String[] args) {
        FunctionMenu functionMenu = new FunctionMenu();

        FunctionButton help = new FunctionButton("帮助");
        help.setCommand(new HelpCommand());

        FunctionButton minimize = new FunctionButton("最小化");
        minimize.setCommand(new MinimizeCommand());

        functionMenu.addFunctionButton(help);
        functionMenu.addFunctionButton(minimize);

        functionMenu.execute();
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


    /**
     * 功能菜单
     */
    public static class FunctionMenu {

        private List<FunctionButton> functionButtons = new ArrayList<FunctionButton>();


        public void addFunctionButton(FunctionButton functionButton) {
            this.functionButtons.add(functionButton);
        }


        public void removeFunctionButton(FunctionButton functionButton) {
            this.functionButtons.remove(functionButton);
        }


        public void execute() {
            for (FunctionButton functionButton : functionButtons) {
                functionButton.onClick();
            }
        }

    }

}
