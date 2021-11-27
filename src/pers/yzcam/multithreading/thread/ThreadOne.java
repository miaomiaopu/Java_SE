package pers.yzcam.multithreading.thread;

import static java.lang.Thread.sleep;

/**
 * @author cat
 */
public class ThreadOne extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("线程一，运行中");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
