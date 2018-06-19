package com.camnter.basicexercises.design.command;

/**
 * 撤销命令
 *
 * @author CaMnter
 */

class UndoCommand {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        AbstractCommand abstractCommand = new Command();
        calculator.setCommand(abstractCommand);

        calculator.compute(10);
        calculator.compute(10);
        calculator.compute(10);
        calculator.undo();
    }


    /**
     * 加法
     */
    public static class Adder {

        private int num;


        public int add(int value) {
            this.num += value;
            return this.num;
        }

    }


    /**
     * 抽象命令类
     */
    public static abstract class AbstractCommand {

        public abstract int execute(int value);

        /**
         * 撤销
         *
         * @return int
         */
        public abstract int undo();

    }


    /**
     * 具体命令类
     */
    public static class Command extends AbstractCommand {

        private Adder adder = new Adder();
        // 记录上一次操作的值
        private int value;


        @Override
        public int execute(int value) {
            this.value = value;
            return this.adder.add(this.value);
        }


        @Override
        public int undo() {
            return this.adder.add(-this.value);
        }

    }


    /**
     * 计算器
     */
    public static class Calculator {

        private AbstractCommand command;


        public void setCommand(AbstractCommand command) {
            this.command = command;
        }


        public void compute(int value) {
            final int result = this.command.execute(value);
            System.out.println("[Calculator]   [compute]   [result] = " + result);
        }


        public void undo() {
            final int result = this.command.undo();
            System.out.println("[Calculator]   [undo]   [result] = " + result);
        }

    }

}
