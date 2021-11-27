package pers.yzcam.multithreading.test;

import pers.yzcam.multithreading.thread.MyRunnable;

/**
 * @author cat
 */
public class MyRunnableTest {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();

        Thread thread1 = new Thread(runnable, "线程A");
        Thread thread2 = new Thread(runnable, "线程B");

        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
