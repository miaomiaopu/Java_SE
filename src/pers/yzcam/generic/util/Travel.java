package pers.yzcam.generic.util;

import java.util.List;

/**
 * @author cat
 */
public class Travel {

    public void useVehicle(List<? extends AbstractVehicle> vehicleList) {
        AbstractVehicle abstractVehicle = vehicleList.get(0);
        System.out.println(abstractVehicle.getClass().getName());
    }

    public void vehicleBeUsed(List<? super ElectricShip> vehicleList) {

    }
}
