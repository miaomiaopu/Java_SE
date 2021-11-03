package pers.yzcam.innerclass.interface_.impl;

import pers.yzcam.innerclass.interface_.Computer;

/**
 * Computer 实现类
 * 实现 NoteBook
 */
public class NoteBookComputerImpl implements Computer {
    /**
     * 使用电脑方法
     *
     * @param num1 一个数字
     * @param num2 另一个数字
     */
    @Override
    public void useComputer(double num1, double num2) {

        class Memory {
            /**
             * 存储数据并且计算再存储
             *
             * @param num1 加法左侧数字
             * @param num2 加法右侧数字
             */
            public void store(double num1, double num2) {
                double num = num1 + num2;
                System.out.println("完成存储和计算" + num);
            }
        }

        Memory memory = new Memory();
        memory.store(num1, num2);
        // 创建本地的静态内部类对象
        Hoard hoard = new NoteBookComputerImpl.Hoard();
        hoard.displaySelfInfo();
    }

    /**
     * Cpu 内部类
     */
    public class Cpu {

        public void handleData() {
            System.out.println("CPU处理数据");
        }
    }

    /**
     * Hoard 静态内部类
     */
    private static class Hoard {

        public void displaySelfInfo() {
            System.out.println("我是主板");
        }
    }
}
