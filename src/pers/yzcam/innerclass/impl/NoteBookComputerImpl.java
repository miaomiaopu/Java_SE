package pers.yzcam.innerclass.impl;

import pers.yzcam.innerclass.interface_.Computer;

/**
 * Computer 实现类
 * 实现 NoteBook
 */
public class NoteBookComputerImpl implements Computer {
    /**
     * 使用电脑方法
     */
    @Override
    public void useComputer() {
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
