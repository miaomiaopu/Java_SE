package pers.yzcam.deadlock;

/**
 * @author cat
 */
public class DeathLockTest {
    public static void main(String[] args) {
        DeathLock lock = new DeathLock();

        ThreadOne one = new ThreadOne(lock);
        ThreadTwo two = new ThreadTwo(lock);

        one.start();
        two.start();
    }
}
