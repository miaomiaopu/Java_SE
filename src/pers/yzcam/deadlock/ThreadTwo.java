package pers.yzcam.deadlock;

/**
 * @author cat
 */
public class ThreadTwo extends Thread {
    private DeathLock lock;

    public ThreadTwo(DeathLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.add2();
    }
}
