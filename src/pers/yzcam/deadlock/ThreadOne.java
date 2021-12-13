package pers.yzcam.deadlock;

/**
 * @author cat
 */
public class ThreadOne extends Thread {
    private DeathLock lock;

    public ThreadOne(DeathLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.add1();
    }
}
