package pers.yzcam.multithreading.thread;

/**
 * @author cat
 */
public class ThreadJoinRunnable implements Runnable {
    String leader = "leader";
    String normal1 = "normal1";
    String normal2 = "normal2";

    @Override
    public void run() {
        if (leader.equals(Thread.currentThread().getName())) {
            for (int i = 0; i < 100000000; i++) {
                if (i % 1000000 == 0) {
                    System.out.println("当前领导在通过路段" + i);
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "正在通过此路段");
    }
}
