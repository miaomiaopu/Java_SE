package pers.yzcam.interface_.test;

import pers.yzcam.interface_.interface_.impl.ClockImpl;
import pers.yzcam.interface_.interface_.Computer;

public class InterfaceComputerTest {
    public static void main(String[] args) {
        // Computer computer = new Computer(); /// 接口不能直接实例化
        Computer computer = new ClockImpl("Java窗体");
    }
}
