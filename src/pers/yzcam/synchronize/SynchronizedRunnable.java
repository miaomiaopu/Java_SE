package pers.yzcam.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cat
 */
public class SynchronizedRunnable implements Runnable {
    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            for (int i = 0; i < 10; i++) {
                list.add("字符串" + i);
                System.out.println("当前持有对象监视器的线程对象" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("当前线程对象" + Thread.currentThread().getName());
    }
}
