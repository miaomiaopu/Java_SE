package pers.yzcam.synchronize.test;

import pers.yzcam.synchronize.MethodSynchronizedRunnable;

/**
 * @author cat
 */
public class MethodSynchronizedRunnableTest {
    public static void main(String[] args) {
        MethodSynchronizedRunnable runnable = new MethodSynchronizedRunnable();
        Thread thread1 = new Thread(runnable, "thread-1");
        Thread thread2 = new Thread(runnable, "thread-2");
        Thread thread3 = new Thread(runnable, "thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
