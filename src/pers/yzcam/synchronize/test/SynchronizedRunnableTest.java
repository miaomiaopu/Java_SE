package pers.yzcam.synchronize.test;

import pers.yzcam.synchronize.SynchronizedRunnable;

/**
 * @author cat
 */
public class SynchronizedRunnableTest {
    public static void main(String[] args) {
        testSyncCode();
    }

    private static void testSyncCode() {
        SynchronizedRunnable synchronizedRunnable = new SynchronizedRunnable();
        Thread thread1 = new Thread(synchronizedRunnable, "thread1");
        Thread thread2 = new Thread(synchronizedRunnable, "thread2");

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
    }
}
