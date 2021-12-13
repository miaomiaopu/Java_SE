package pers.yzcam.threadwait;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cat
 */
public class ThreadWaitAndNotify implements Runnable {

    private List<Integer> list = new ArrayList<>();

    public ThreadWaitAndNotify() {
    }

    public ThreadWaitAndNotify(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            for (int i = 0; i < 100; i++) {
                if (i == 20 && "thread-1".equals(Thread.currentThread().getName())) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if ("thread-2".equals(Thread.currentThread().getName())) {
                    list.notify();
                }
                System.out.println("当前执行线程" + Thread.currentThread().getName());
                System.out.println("当前 i 的值为 " + i);
                list.add(i);
            }
        }
    }
}
