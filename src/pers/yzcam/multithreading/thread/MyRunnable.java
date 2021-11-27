package pers.yzcam.multithreading.thread;

/**
 * 实现 Runnable 接口
 *
 * @author cat
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread.getName());
        }
    }
}
