package pers.yzcam.deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cat
 */
public class DeathLock {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public synchronized void add1() {
        for (int i = 0; i < 100; i++) {
            System.out.println("当前线程 " + Thread.currentThread().getName() + " 调用add1");
            list.add(i);
            if (i == 20) {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                add2();
            }
        }
    }

    public synchronized void add2() {
        for (int i = 0; i < 100; i++) {
            System.out.println("当前线程 " + Thread.currentThread().getName() + " 调用add2");
            list.add(i);
            if (i == 20) {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            add1();
        }
    }
}
