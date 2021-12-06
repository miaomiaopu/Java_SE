package pers.yzcam.threadsafe.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author cat
 */
public class SyncDataSupport {
    private List<Integer> list = new ArrayList<>();
    private Vector<Integer> vector = new Vector<>();

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public Vector<Integer> getVector() {
        return vector;
    }

    public void setVector(Vector<Integer> vector) {
        this.vector = vector;
    }

    public void addData() {
        for (int i = 0; i < 100000; i++) {
            synchronized (list) {
                list.add(i);
            }
            // vector.add(i);
        }
    }
}
