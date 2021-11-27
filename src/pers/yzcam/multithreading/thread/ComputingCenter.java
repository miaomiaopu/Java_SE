package pers.yzcam.multithreading.thread;

/**
 * 计算中心
 *
 * @author cat
 */
public class ComputingCenter implements Runnable {
    /**
     * 累加和
     */
    private long sum = 0;
    /**
     * 前部分累加和
     */
    private long sum1 = 0;
    /**
     * 后部分累加和
     */
    private long sum2 = 0;
    /**
     * 目标计算的数
     */
    private long target;

    @Override
    public void run() {
        long limit = target / 2;
        String threadCount1Name = "count1";
        String threadCount2Name = "count2";
        if (threadCount1Name.equals(Thread.currentThread().getName())) {
            for (long i = 1; i < limit; i++) {
                sum1 += i;
            }
        }
        if (threadCount2Name.equals(Thread.currentThread().getName())) {
            for (long i = limit; i <= target; i++) {
                sum2 += i;
            }
        }

    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public long getSum1() {
        return sum1;
    }

    public void setSum1(long sum1) {
        this.sum1 = sum1;
    }

    public long getSum2() {
        return sum2;
    }

    public void setSum2(long sum2) {
        this.sum2 = sum2;
    }

    public long getTarget() {
        return target;
    }

    public void setTarget(long target) {
        this.target = target;
    }
}
