package pers.yzcam.multithreading.test;

import pers.yzcam.multithreading.thread.ThreadOne;
import pers.yzcam.multithreading.thread.ThreadTwo;

/**
 * @author cat
 */
public class StartTest {
    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();

        threadOne.start();
        threadTwo.start();
    }
}
