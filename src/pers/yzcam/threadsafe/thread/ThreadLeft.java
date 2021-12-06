package pers.yzcam.threadsafe.thread;

import pers.yzcam.threadsafe.util.SyncDataSupport;

/**
 * @author cat
 */
public class ThreadLeft extends Thread{
    private SyncDataSupport syncDataSupport;

    public SyncDataSupport getSyncDataSupport() {
        return syncDataSupport;
    }

    public void setSyncDataSupport(SyncDataSupport syncDataSupport) {
        this.syncDataSupport = syncDataSupport;
    }

    @Override
    public void run() {
        syncDataSupport.addData();
    }
}
