package pers.yzcam.multithreading.test;

import pers.yzcam.multithreading.thread.ThreadJoinRunnable;

/**
 * @author cat
 */
public class ThreadJoinRunnableTest {
    public static void main(String[] args) {
        ThreadJoinRunnable threadJoinRunnable = new ThreadJoinRunnable();

        Thread thread1 = new Thread(threadJoinRunnable, "leader");
        Thread thread2 = new Thread(threadJoinRunnable, "norm1");
        Thread thread3 = new Thread(threadJoinRunnable, "norm2");

        thread1.start();
        try {
            thread1.join(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        thread3.start();
    }
}
