package pers.yzcam.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cat
 */
public class CommandDao {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public void addData() {
        synchronized (this) {
            for (int i = 0; i < 50; i++) {
                list.add(i);
                System.out.println("插入" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void deleteData() {
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
            System.out.println("正在删除");
        }
    }
}
