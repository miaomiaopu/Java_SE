package pers.yzcam.threadsafe.test;

import pers.yzcam.threadsafe.thread.ThreadLeft;
import pers.yzcam.threadsafe.thread.ThreadRight;
import pers.yzcam.threadsafe.util.SyncDataSupport;

/**
 * @author cat
 */
public class SyncDataSupportTest {
    public static void main(String[] args) {
        SyncDataSupport syncDataSupport = new SyncDataSupport();
        ThreadLeft left = new ThreadLeft();
        left.setName("left");
        left.setSyncDataSupport(syncDataSupport);
        ThreadRight right = new ThreadRight();
        right.setName("right");
        right.setSyncDataSupport(syncDataSupport);

        left.start();
        right.start();

        while (true) {
            if (left.getState() == Thread.State.TERMINATED && right.getState() == Thread.State.TERMINATED) {
                System.out.println(syncDataSupport.getList().size());
                break;
            }
        }
    }
}
