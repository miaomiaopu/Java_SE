package pers.yzcam.innerclass.test;

import pers.yzcam.innerclass.impl.Staff;
import pers.yzcam.innerclass.interface_.Computer;

public class StaffTest {
    public static void main(String[] args) {
        Staff mark = new Staff();
        double a = 11;
        double b = 12;
        // 匿名类对象的实现
        mark.useComputerWorking(new Computer() {
            @Override
            public void useComputer(double a, double b) {
                double res = a + b;
                System.out.println("利用计算机完成计算" + res);
            }
        }, a, b);
    }
}
