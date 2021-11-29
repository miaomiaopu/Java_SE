package pers.yzcam.multithreading.test;

import pers.yzcam.multithreading.thread.LandlordAndFarmerRunnable;

/**
 * @author cat
 */
public class LandlordAndFarmerRunnableTest {
    public static void main(String[] args) {
        LandlordAndFarmerRunnable landlordAndFarmerRunnable = new LandlordAndFarmerRunnable();

        Thread farmer = new Thread(landlordAndFarmerRunnable, "farmer");
        Thread landlord = new Thread(landlordAndFarmerRunnable, "landlord");

        landlordAndFarmerRunnable.setLandlord(landlord);
        landlordAndFarmerRunnable.setFarmer(farmer);

        farmer.start();
        landlord.start();
    }
}
