package pers.yzcam.multithreading.test;

import pers.yzcam.multithreading.thread.ComputingCenter;

/**
 * @author cat
 */
public class ComputingCenterTest {
    public static void main(String[] args) {
        ComputingCenter computingCenter = new ComputingCenter();
        computingCenter.setTarget(1000000000);

        Thread thread1 = new Thread(computingCenter, "count1");
        Thread thread2 = new Thread(computingCenter, "count2");

        thread1.start();
        thread2.start();

        while (true) {
            if (thread1.getState() == Thread.State.TERMINATED && thread2.getState() == Thread.State.TERMINATED) {
                break;
            }
        }
        computingCenter.setSum(computingCenter.getSum1() + computingCenter.getSum2());
        System.out.println(computingCenter.getSum());
    }
}
