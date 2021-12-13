package pers.yzcam.threadwait.test;

import pers.yzcam.threadwait.ThreadWaitAndNotify;

/**
 * @author cat
 */
public class ThreadWaitAndNotifyTest {
    public static void main(String[] args) {
        ThreadWaitAndNotify threadWaitAndNotify = new ThreadWaitAndNotify();

        Thread thread1 = new Thread(threadWaitAndNotify, "thread-1");
        Thread thread2 = new Thread(threadWaitAndNotify, "thread-2");

        thread1.start();
        thread2.start();
    }
}
