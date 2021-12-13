package pers.yzcam.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cat
 */
public class MethodSynchronizedRunnable implements Runnable {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public synchronized void addData1() {
        for (int i = 10; i < 100; i++) {
            list.add(i);
            System.out.println("当前线程对象" + Thread.currentThread().getName() + "执行addData1方法");
        }
    }

    public synchronized void addData2() {
        for (int i = 10; i < 100; i++) {
            list.add(i);
            System.out.println("当前线程对象" + Thread.currentThread().getName() + "执行addData2方法");
        }
    }

    public void addData3() {
        for (int i = 10; i < 100; i++) {
            list.add(i);
            System.out.println("当前线程对象" + Thread.currentThread().getName() + "执行addData3方法");
        }
    }

    @Override
    public void run() {
        addData3();
        addData1();
        addData2();
    }
}
