package pers.yzcam.multithreading.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * @author cat
 */
public class LandlordAndFarmerRunnable implements Runnable {

    private Thread landlord;
    private Thread farmer;
    /**
     * 收割的玉米数目
     */
    private List<Integer> list = new ArrayList<>();

    public Thread getLandlord() {
        return landlord;
    }

    public void setLandlord(Thread landlord) {
        this.landlord = landlord;
    }

    public Thread getFarmer() {
        return farmer;
    }

    public void setFarmer(Thread farmer) {
        this.farmer = farmer;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        if (Thread.currentThread() == farmer) {
            for (int i = 0; i < 1000; i++) {
                Random random = new Random();
                list.add(random.nextInt(1000));
                try {
                    if (list.size() == 100 || list.size() == 500 || list.size() == 800) {
                        sleep(1000 * 60 * 3);
                    }
                } catch (InterruptedException e) {
                    System.out.println("唤醒");
                    e.printStackTrace();
                }
            }
        }
        if (Thread.currentThread() == landlord) {
            while (list.size() != 1000) {
                if (farmer.getState() == Thread.State.TIMED_WAITING) {
                    System.out.println("唤醒农民线程");
                    farmer.interrupt();
                }
            }
        }
        System.out.println("玉米重量" + list.size());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
